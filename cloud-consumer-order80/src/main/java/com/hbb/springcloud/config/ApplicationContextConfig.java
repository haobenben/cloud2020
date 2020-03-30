package com.hbb.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ahthor yj
 * @date 2020/3/20
 * @description:
 */
@Configuration
public class ApplicationContextConfig {

  @Bean
//  @LoadBalanced // 负载均衡
  public RestTemplate getRestTemplate(){
    return new RestTemplate();
  }
}
