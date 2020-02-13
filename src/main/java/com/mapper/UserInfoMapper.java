package com.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.entity.UserInfo;

@Mapper
public interface UserInfoMapper {
	
    public void insertUserInfo(UserInfo userInfo);

    public void updateUserInfo(UserInfo userInfo);
    
    public void deleteUserInfo(int id);
    
    public UserInfo findUserInfo(String openid);
}