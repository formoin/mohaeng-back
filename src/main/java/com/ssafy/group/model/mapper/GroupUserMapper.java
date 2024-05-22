package com.ssafy.group.model.mapper;


import java.util.List;

import com.ssafy.group.dto.Group;
import com.ssafy.user.dto.Groupuser;
import com.ssafy.user.dto.User;

public interface GroupUserMapper {
	List<User> getGroupUsers(int groupId);
	int insertGroupUserList(List<Groupuser> groupuserList);
	int deleteGroupUser(Groupuser groupuser);

	int setCheckTrue(int userId);
	List<Group> getGroupInfo(int userId);

}
