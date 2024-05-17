package com.ssafy.group.model.mapper;


import java.util.List;

import com.ssafy.user.dto.Groupuser;
import com.ssafy.user.dto.User;

public interface GroupUserMapper {
	List<User> getGroupUser(int groupId);
	int insertGroupUserList(List<Groupuser> groupUser);

}
