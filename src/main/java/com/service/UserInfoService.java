package com.service;

import com.entity.UserInfo;

public interface UserInfoService {
    
    public void insertUserInfo(UserInfo userInfo);
    
    public void updateUserInfo(UserInfo userInfo);

    public UserInfo findUserInfo(String openid);
  
    public void deleteUserInfo(int id);
}