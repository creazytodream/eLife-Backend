package com.service;

import java.util.List;
import java.util.Map;

import com.entity.Orderdetail;

public interface OrderdetailService {
	int insert(Orderdetail record);
	
	public List<Orderdetail> findOrderdetail(String orderid, String productStatus);
	
	public List<Map> findOrderdetailByDepartment(String department, String office, String goodsDate);
	
    public List<Map> findOrderDepartment();
    
    public List<Map> findOrderOffice();
    
    public List<Map> findOrderDetailList(String department, String office, String goodsDate);
}