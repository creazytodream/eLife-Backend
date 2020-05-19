package com.entity;

import java.util.Date;
import java.util.List;

public class Orderlist {
    private String orderid;

	private String openid;

	private String orderdate;

	private String orderstatus;

	private String remarks;
	
	private String orderQuantity;
	
	private String orderAmount;
	
	private List<Orderdetail> orderDetailList;
	
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<Orderdetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<Orderdetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

}