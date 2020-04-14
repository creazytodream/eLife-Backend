package com.service.impl;

import java.util.List;

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
	public List<Orderdetail> findOrderdetail(String orderid){
		return orderdetailMapper.findOrderdetail(orderid);
	}
	

}