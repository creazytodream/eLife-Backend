package com.entity;

import java.util.Date;

public class Orderlist {
    private String orderid;

	private String openid;

	private Date orderdate;

	private String orderstatus;

	private String orderquantity;

	private String orderamount;

	private String remarks;
	
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

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getOrderquantity() {
		return orderquantity;
	}

	public void setOrderquantity(String orderquantity) {
		this.orderquantity = orderquantity;
	}

	public String getOrderamount() {
		return orderamount;
	}

	public void setOrderamount(String orderamount) {
		this.orderamount = orderamount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


}