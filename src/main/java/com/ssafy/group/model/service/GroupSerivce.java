package com.ssafy.group.model.service;

import java.util.List;

import com.ssafy.group.dto.Group;
import com.ssafy.group.dto.RequestMakegroup;
import com.ssafy.user.dto.Groupuser;
import com.ssafy.user.dto.User;

public interface GroupSerivce {
	int makeGroup(RequestMakegroup requestInfo);
	int addGroupUsers(RequestMakegroup requestInfo);

	int updateGroupInfo(Group group);
	
	int deleteGroup(int groupId);
	
	
	List<Group> getMyGroup(int userId);
	List<User> getGroupMember(int groupId);
}
