package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Orderlist;
import com.mapper.OrderlistMapper;
import com.service.OrderlistService;

@Service
public class OrderlistServiceImpl implements OrderlistService {

	@Autowired
	private OrderlistMapper orderlistMapper;

	@Override
	public int insert(Orderlist record) {		
		return orderlistMapper.insert(record);
	}
	
	@Override
	public List<Orderlist> findOrderlist(String openid, String orderstatus, String orderdate) {
		return orderlistMapper.findOrderlist(openid, orderstatus, orderdate);
	}

}