package com.hbb.springcloud.controller;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ahthor yj
 * @date 2020/3/23
 * @description:
 */
@RestController
@Slf4j
public class OrdeZKController  {

  public static final String INVOKE_URL = "http://cloud-provider-payment";

  @Resource
  private RestTemplate restTemplate;

  @GetMapping(value = "/consumer/payment/zk")
  public String paymentInfo(){
    String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    return result;
  }
}
