package com.hbb.springcloud.dao;

import com.hbb.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ahthor yj
 * @date 2020/3/19
 * @description:
 */
@Mapper
public interface PaymentDao {

  public int create(Payment payment);

  public Payment getPaymentById(@Param("id") Long id);
}
