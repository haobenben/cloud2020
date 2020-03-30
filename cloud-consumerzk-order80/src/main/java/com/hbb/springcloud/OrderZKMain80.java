package com.hbb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ahthor yj
 * @date 2020/3/23
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain80 {
  public static void main(String[] args){
    SpringApplication.run(OrderZKMain80.class, args);
  }
}
