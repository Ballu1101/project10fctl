package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.PaymentDAOInt;
import com.rays.dto.PaymentDTO;

@Service
@Transactional
public class PaymentServiceImp extends BaseServiceImpl<PaymentDTO, PaymentDAOInt> implements PaymentServiceInt{

}
