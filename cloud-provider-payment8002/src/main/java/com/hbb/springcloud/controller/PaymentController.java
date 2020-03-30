package com.hbb.springcloud.controller;

import com.hbb.springcloud.entities.CommonResult;
import com.hbb.springcloud.entities.Payment;
import com.hbb.springcloud.service.PaymentService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

  @GetMapping(value = "/payment/lb")
  public String getPaymentLB() {
    return serverPort;
  }
}
