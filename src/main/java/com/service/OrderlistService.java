package com.service;

import java.util.List;

import com.entity.Orderlist;

public interface OrderlistService {
	public int insert(Orderlist record);
	
	public List<Orderlist> findOrderlist(String openid, String productStatus);
	
	public int updateOrderStaus(String orderid);
}