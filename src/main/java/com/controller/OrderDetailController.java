package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.entity.Orderdetail;
import com.entity.Orderlist;
import com.service.OrderdetailService;

@RestController
public class OrderDetailController {
	private static final Logger bizLogger = LoggerFactory.getLogger(OrderDetailController.class);

	@Autowired
	private OrderdetailService orderdetailService;

	@RequestMapping(value = "/insertOrderDetail", method = RequestMethod.POST)

	@ResponseBody
    public boolean insertOrderDetail(Orderdetail orderdetail) {
		bizLogger.info("insertOrderDetail");
    	try{
    		//System.out.println("OrderDetailController request = "+JSON.toJSONString(orderdetail));
    		orderdetailService.insert(orderdetail);
    		return true;
    	} catch (Exception e) {
    		System.out.println(e);
    		return false;
    	}
    }
	
	@RequestMapping(value = "/findOrderdetail", method = RequestMethod.POST)

	@ResponseBody
    public List<Orderdetail> findOrderdetail(@RequestParam(value = "orderid") String orderid) {
			bizLogger.info("findOrderdetail orderid = "+orderid);
    		//System.out.println(orderid);
    		return orderdetailService.findOrderdetail(orderid);
    }

}


