package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.entity.Orderdetail;

@Mapper
public interface OrderdetailMapper {
    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);
    
    public List<Orderdetail> findOrderdetail(String orderid);
    
    public List<Orderdetail> findOrderdetailByDepartment(String department, String office, String goodsDate);
    
    public List<Orderdetail> findOrderDepartment();
    
    public List<Orderdetail> findOrderOffice();
    
    public List<Orderdetail> findOrderDetailList(String department, String office, String goodsDate);
}