package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.entity.Config;

@Mapper
public interface ConfigMapper {

	public Config selectByPrimaryKey(String paraname);
    
    public List<Config> findAllConfig();
    public List<Config> findParaValueByParaName(String paraName);
    
    public int updateOrderDueTime();
}