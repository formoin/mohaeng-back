package com.ssafy.user.model.service;

import java.util.List;

import com.ssafy.user.dto.User;

public interface UserSerivce {
	User login(User loginInfo);

	List<User> selectAll();
}
