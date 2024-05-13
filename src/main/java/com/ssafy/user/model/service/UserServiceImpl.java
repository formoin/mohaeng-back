package com.ssafy.user.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.user.dto.User;
import com.ssafy.user.model.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserSerivce {
	private final UserMapper userMapper;

	@Override
	public User login(User loginInfo) {
		
		return userMapper.login(loginInfo);
	}

	@Override
	public List<User> selectAll() {
		
		return userMapper.selectAll();
	}

}
