package com.ssafy.user.model.service;

import java.util.List;

import com.ssafy.user.dto.User;

public interface UserSerivce {
	String login(User loginInfo) throws Exception;
	List<User> selectAll() throws Exception;
	String join(User joinInfo);
}
