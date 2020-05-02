package com.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.entity.Orderdetail;

@Mapper
public interface OrderdetailMapper {
    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);
    
    public List<Orderdetail> findOrderdetail(String orderid);
    
    public List<Map> findOrderdetailByDepartment(String department, String office, String goodsDate);
    
    public List<Map> findOrderDepartment();
    
    public List<Map> findOrderOffice();
    
    public List<Map> findOrderDetailList(String department, String office, String goodsDate);
}