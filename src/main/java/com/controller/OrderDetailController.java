package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Orderdetail;
import com.service.OrderdetailService;

@RestController
public class OrderDetailController {
	private static final Logger bizLogger = LoggerFactory.getLogger(OrderDetailController.class);

	@Autowired
	private OrderdetailService orderdetailService;

	@RequestMapping(value = "/insertOrderDetail", method = RequestMethod.POST)

	@ResponseBody
    public boolean insertOrderDetail(Orderdetail orderdetail) {
    	try{
    		orderdetailService.insert(orderdetail);
    		return true;
    	} catch (Exception e) {
    		System.out.println(e);
    		return false;
    	}
    }

}


