package com.hbb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ahthor yj
 * @date 2020/3/19
 * @description:
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
  public static void main(String[] args){
    SpringApplication.run(EurekaMain7001.class, args);
  }
}
