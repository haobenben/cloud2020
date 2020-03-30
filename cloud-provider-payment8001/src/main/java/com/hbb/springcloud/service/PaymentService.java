package com.hbb.springcloud.service;

import com.hbb.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ahthor yj
 * @date 2020/3/19
 * @description:
 */
public interface PaymentService {

  public int create(Payment payment);

  public Payment getPaymentById(@Param("id") Long id);
}
