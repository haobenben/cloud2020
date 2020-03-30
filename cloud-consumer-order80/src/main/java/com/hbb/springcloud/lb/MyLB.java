package com.hbb.springcloud.lb;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

/**
 * @ahthor yj
 * @date 2020/3/25
 * @description:
 */
@Component
public class MyLB implements LoadBalancer {

  private AtomicInteger atomicInteger = new AtomicInteger(0);

  private final int getAndIncrement(){
    int current;
    int next;
    do{
      current = this.atomicInteger.get();
      next = current >= 2147483647 ? 0 : current + 1;
    }while (!this.atomicInteger.compareAndSet(current,next));
    System.err.println("第几次访问next======================："+next);
    return next;
  }

  @Override
  public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
    int index = getAndIncrement() % serviceInstances.size();
    return serviceInstances.get(index  );
  }
}
