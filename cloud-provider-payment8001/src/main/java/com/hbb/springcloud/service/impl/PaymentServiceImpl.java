package com.hbb.springcloud.service.impl;

import com.hbb.springcloud.dao.PaymentDao;
import com.hbb.springcloud.entities.Payment;
import com.hbb.springcloud.service.PaymentService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @ahthor yj
 * @date 2020/3/19
 * @description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {

  @Resource
  private PaymentDao paymentDao;

  @Override
  public int create(Payment payment) {
    return paymentDao.create(payment);
  }

  @Override
  public Payment getPaymentById(Long id) {
    return paymentDao.getPaymentById(id);
  }
}
