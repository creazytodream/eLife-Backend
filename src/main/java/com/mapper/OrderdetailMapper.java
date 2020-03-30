package com.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.entity.Orderdetail;

@Mapper
public interface OrderdetailMapper {
    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);
}