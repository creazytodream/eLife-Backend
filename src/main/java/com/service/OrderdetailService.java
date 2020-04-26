package com.service;

import java.util.List;

import com.entity.Orderdetail;

public interface OrderdetailService {
	int insert(Orderdetail record);
	
	public List<Orderdetail> findOrderdetail(String orderid);
	
	public List<Orderdetail> findOrderdetailByDepartment(String department, String office, String goodsDate);
	
    public List<Orderdetail> findOrderDepartment();
    
    public List<Orderdetail> findOrderOffice();
}