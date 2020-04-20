package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.entity.Orderdetail;

@Mapper
public interface OrderdetailMapper {
    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);
    
    public List<Orderdetail> findOrderdetail(String orderid);
}