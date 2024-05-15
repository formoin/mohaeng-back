package com.ssafy.user.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.user.dto.User;

public interface UserMapper {
//	User login(User loginInfo) throws SQLException;
	List<User> selectAll() throws SQLException;

	int join(User joinInfo);

	User findById(String id);

}
