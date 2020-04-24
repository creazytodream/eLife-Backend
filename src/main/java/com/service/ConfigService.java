package com.service;

import java.util.List;

import com.entity.Config;

public interface ConfigService {
    
	public Config selectByPrimaryKey(String paraname);
    
    public List<Config> findAllConfig();
    
    public List<Config> findParaValueByParaName(String paraName);
}