package com.ssafy.user.model.mapper;

import java.util.List;

import com.ssafy.user.dto.User;

public interface UserMapper {
	User login(User loginInfo);

	List<User> selectAll();
}
