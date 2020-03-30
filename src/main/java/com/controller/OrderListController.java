package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Orderlist;
import com.service.OrderlistService;

@RestController
public class OrderListController {
	private static final Logger bizLogger = LoggerFactory.getLogger(OrderListController.class);

	@Autowired
	private OrderlistService orderlistService;

	@RequestMapping(value = "/insertOrderList", method = RequestMethod.POST)

	@ResponseBody
    public boolean insertOrderList(Orderlist orderlist) {
    	try{
    		orderlistService.insert(orderlist);
    		return true;
    	} catch (Exception e) {
    		System.out.println(e);
    		return false;
    	}
    }

}


