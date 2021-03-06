package com.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "/findOrderdetailByDepartment", method = RequestMethod.POST)

	@ResponseBody
    public List<Map> findOrderdetailByDepartment(@RequestParam(value = "department") String department, String office, String goodsDate) {
		bizLogger.info("findOrderdetailByDepartment department ["+department+"] office ["+office+"] goodsDate ["+goodsDate+"]");
    		
		return orderdetailService.findOrderdetailByDepartment(department, office, goodsDate);
    }
	
	@RequestMapping(value = "/findOrderDepartment", method = RequestMethod.POST)

	@ResponseBody
    public List<Map> findOrderDepartment() {
		bizLogger.info("findOrderDepartment");
    		
		return orderdetailService.findOrderDepartment();
    }
	
	@RequestMapping(value = "/findOrderOffice", method = RequestMethod.POST)

	@ResponseBody
    public List<Map> findOrderOffice() {
		bizLogger.info("findOrderOffice");
    		
		return orderdetailService.findOrderOffice();
    }
	
	@RequestMapping(value = "/findOrderDetailList", method = RequestMethod.POST)

	@ResponseBody
    public List<Map> findOrderDetailList(@RequestParam(value = "department") String department, String office, String goodsDate) {
		bizLogger.info("findOrderDetailList department ["+department+"] office ["+office+"] goodsDate ["+goodsDate+"]");
    		
		return orderdetailService.findOrderDetailList(department, office, goodsDate);
    }
}


