package com.hbb.springcloud.lb;

import java.util.List;
import org.springframework.cloud.client.ServiceInstance;

/**
 * @ahthor yj
 * @date 2020/3/25
 * @description:
 */
public interface LoadBalancer {

  ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
