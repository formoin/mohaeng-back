package com.ssafy.user.model.service;

import java.util.List;

import com.ssafy.user.dto.User;

public interface UserSerivce {
	User login(User loginInfo) throws Exception;
	User userInfo(String userId) throws Exception;
	List<User> selectAll() throws Exception;
	void saveRefreshToken(String userId, String refreshToken) throws Exception;
	Object getRefreshToken(String userId) throws Exception;
	void deleRefreshToken(String userId) throws Exception;
}
