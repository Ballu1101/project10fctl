package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.OrderDTO;
import com.rays.form.OrderForm;
import com.rays.service.OrderServiceInt;

@RestController
@RequestMapping(value = "order")
public class OrderCtl  extends BaseCtl<OrderForm, OrderDTO, OrderServiceInt>{

	
}
