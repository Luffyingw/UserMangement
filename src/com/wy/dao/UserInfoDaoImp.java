package com.wy.dao;

import com.wy.model.UserInfoForm;

public interface UserInfoDaoImp
    {
	public UserInfoForm queryUserInfo(String account);
	public boolean saveUserInfo(UserInfoForm userInfo);
    }
