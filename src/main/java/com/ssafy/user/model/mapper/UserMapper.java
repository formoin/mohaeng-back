package com.ssafy.user.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.user.dto.User;

public interface UserMapper {
	List<User> selectByKeyword(String keyword) throws SQLException;

	int join(User joinInfo) throws SQLException;

	User findById(String id) throws SQLException;

	int update(User userInfo) throws SQLException;

	int deleteById(int id) throws SQLException;
	
	
}
