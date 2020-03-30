package com.hbb.springcloud.controller;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ahthor yj
 * @date 2020/3/23
 * @description:
 */
@RestController
@Slf4j
public class PaymentController {

  @Value("${server.port}")
  private String serverPort;

  @RequestMapping(value = "/payment/zk")
  public String paymentzk(){
    return "springcloud with zookeeper: "+serverPort+"\t"+ UUID.randomUUID().toString();
  }
}
