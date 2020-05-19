package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Orderdetail;
import com.mapper.OrderdetailMapper;
import com.service.OrderdetailService;

@Service
public class OrderdetailServiceImpl implements OrderdetailService {

	@Autowired
	private OrderdetailMapper orderdetailMapper;

	@Override
	public int insert(Orderdetail record) {		
		return orderdetailMapper.insert(record);
	}
	
	@Override
	public List<Orderdetail> findOrderdetail(String orderid, String productStatus){
		return orderdetailMapper.findOrderdetail(orderid, productStatus);
	}
	
	@Override
	public List<Map> findOrderdetailByDepartment(String department, String office, String goodsDate) {
		return orderdetailMapper.findOrderdetailByDepartment(department, office, goodsDate);
	}
	
	@Override
    public List<Map> findOrderDepartment() {
		return orderdetailMapper.findOrderDepartment();
	}
    
	@Override
    public List<Map> findOrderOffice(){
		return orderdetailMapper.findOrderOffice();
	}
	
	@Override
	public List<Map> findOrderDetailList(String department, String office, String goodsDate) {
		return orderdetailMapper.findOrderDetailList(department, office, goodsDate);
	}
}