package com.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.entity.Goodslist;
import com.entity.Orderlist;
import com.service.OrderdetailService;
import com.service.OrderlistService;

@RestController
public class OrderListController {
	private static final Logger bizLogger = LoggerFactory.getLogger(OrderListController.class);

	@Autowired
	private OrderlistService orderlistService;

	@Autowired
	private OrderdetailService orderdetailService;
	
	@RequestMapping(value = "/insertOrderList", method = RequestMethod.POST)

	@ResponseBody
    public boolean insertOrderList(Orderlist orderlist) {
		bizLogger.info("insertOrderList = "+JSON.toJSONString(orderlist));
    	try{
    		orderlistService.insert(orderlist);
    		return true;
    	} catch (Exception e) {
    		bizLogger.error("insertOrderList"+e);
    		return false;
    	}
    }
	
	@RequestMapping(value = "/findOrderlist", method = RequestMethod.POST)

	@ResponseBody
    public List<Orderlist> findOrderlist(@RequestParam(value = "openid") String openid, String productStatus) {
		bizLogger.info("findOrderlist openid ["+openid+"] productStatus ["+productStatus+"]");
    		
    	List<Orderlist> orderlist = orderlistService.findOrderlist(openid, productStatus);
    	for(Orderlist order : orderlist){
    		order.setOrderDetailList(orderdetailService.findOrderdetail(order.getOrderid(), productStatus));
    	}
    	return orderlist;
    }

	@RequestMapping(value = "/updateOrderStaus", method = RequestMethod.POST)

	@ResponseBody
    public boolean updateOrderStaus(@RequestParam(value = "orderid") String orderid) {
		bizLogger.info("updateOrderStaus orderid ["+orderid+"]");
    		
    	try{    		
    		orderlistService.updateOrderStaus(orderid);
    		return true;
    	} catch (Exception e) {
    		bizLogger.error("updateOrderStaus"+e);
    		return false;
    	}
    }
}


