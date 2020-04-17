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
		bizLogger.info("insertOrderList orderId = "+orderlist.getOrderid());
    	try{
    		//System.out.println(JSON.toJSONString(orderlist));
    		orderlistService.insert(orderlist);
    		return true;
    	} catch (Exception e) {
    		System.out.println(e);
    		return false;
    	}
    }
	
	@RequestMapping(value = "/findOrderlist", method = RequestMethod.POST)

	@ResponseBody
    public List<Orderlist> findOrderlist(@RequestParam(value = "openid") String openid, String orderstatus, String orderdate) {
		bizLogger.info("findOrderlist openid = "+openid);
    		//System.out.println(openid);
    		//System.out.println(orderstatus);
    		//System.out.println(orderdate);
    		//return orderlistService.findOrderlist(openid, orderstatus, orderdate);
    		
    		List<Orderlist> orderlist = orderlistService.findOrderlist(openid, orderstatus, orderdate);
    		for(Orderlist order : orderlist){
    			
    			//System.out.println(order.getOrderdate());
    			
    			order.setOrderDetailList(orderdetailService.findOrderdetail(order.getOrderid()));
    		}
    		return orderlist;
    }

}


