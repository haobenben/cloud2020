package com.hbb.springcloud.controller;

import com.hbb.springcloud.entities.CommonResult;
import com.hbb.springcloud.entities.Payment;
import com.hbb.springcloud.service.PaymentService;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ahthor yj
 * @date 2020/3/19
 * @description:
 */
@RestController
@Slf4j
public class PaymentController {

  @Resource
  private PaymentService service;

  @Resource
  private DiscoveryClient discoveryClient;

  @Value("${server.port}")
  private String serverPort;

  @PostMapping(value = "/payment/create")
  public CommonResult create(@RequestBody Payment payment){
    int result = service.create(payment);
    if(result>0){
      log.info("插入的结果+++++++++"+ result);
      return new CommonResult(200,"插入pqyment数据成功,serverPort:"+serverPort,result);
    }else{
      return new CommonResult(200,"插入payment数据失败,serverPort:"+serverPort,null);
    }
  }

  @GetMapping(value = "/payment/get/{id}")
  public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
    Payment payment = service.getPaymentById(id);
    if(payment != null){
      return new CommonResult(200,"查询pqyment数据成功,serverPort:"+serverPort,payment);
    }else{
      return new CommonResult(200,"没有对应记录，查询payment数据失败,serverPort:"+serverPort,null);
    }
  }

  @GetMapping(value = "/payment/discovery")
  public Object discovery(){
    List<String> services = discoveryClient.getServices();
    services.forEach(x->{
      log.info("***********element："+x);
    });
    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
    instances.forEach(x->{
      log.info(x.getInstanceId()+"\t"+x.getHost()+"\t"+x.getPort()+"\t"+x.getUri());
    });
    return discoveryClient;
  }

  @GetMapping(value = "/payment/lb")
  public String getPaymentLB() {
    return serverPort;
  }

  @GetMapping(value = "/payment/feign/timeout")
  public String paymentFeignTimeout() {
    // 业务逻辑处理正确，但是需要耗费3秒钟
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return serverPort;
  }

  @GetMapping("/payment/zipkin")
  public String paymentZipkin() {
    return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
  }
}
