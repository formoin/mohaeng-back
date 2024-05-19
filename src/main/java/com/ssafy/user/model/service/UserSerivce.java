package com.ssafy.user.model.service;

import java.util.List;

import com.ssafy.user.dto.User;

public interface UserSerivce {
	String login(User loginInfo) throws Exception;
	List<User> selectByKeyword(String keyword) throws Exception;
	String join(User joinInfo) throws Exception;
	int update(User joinInfo) throws Exception;
	User userInfo(String token) throws Exception;

	int deleteUserInfo(int userId) throws Exception;
}
