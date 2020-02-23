package com.mapper;

import com.entity.Storelist;

public interface StorelistMapper {
    int deleteByPrimaryKey(String storeid);

    int insert(Storelist record);

    int insertSelective(Storelist record);

    Storelist selectByPrimaryKey(String storeid);

    int updateByPrimaryKeySelective(Storelist record);

    int updateByPrimaryKey(Storelist record);
}