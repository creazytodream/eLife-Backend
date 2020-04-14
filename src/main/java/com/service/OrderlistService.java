package com.service;

import java.util.List;

import com.entity.Orderlist;

public interface OrderlistService {
	int insert(Orderlist record);
	
	public List<Orderlist> findOrderlist(String openid, String orderstatus, String orderdate);
}