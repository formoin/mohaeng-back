package com.ssafy.group.model.service;

import java.util.List;

import com.ssafy.group.dto.Group;
import com.ssafy.group.dto.RequestMakegroup;
import com.ssafy.user.dto.Groupuser;
import com.ssafy.user.dto.User;

public interface GroupSerivce {
	int makeGroup(RequestMakegroup requestInfo);
	Group getGroupInfo(int groupId);

	int updateGroupInfo(Group group);
	
	int deleteGroup(int groupId);
	List<User> getGroupUsers(int groupId);
	int addGroupUsers(RequestMakegroup requestInfo);
	List<Group> getMyGroup(int userId);
	int deleteGroupUsers(int groupId, int userId);

}
