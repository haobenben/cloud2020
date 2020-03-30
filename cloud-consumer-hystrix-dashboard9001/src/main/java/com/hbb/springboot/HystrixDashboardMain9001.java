package com.hbb.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ahthor yj
 * @date 2020/3/26
 * @description:
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {

  public static void main(String[] args){
    SpringApplication.run(HystrixDashboardMain9001.class);

  }
}
