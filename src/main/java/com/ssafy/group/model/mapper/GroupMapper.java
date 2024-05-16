package com.ssafy.group.model.mapper;

import java.util.List;

import com.ssafy.group.dto.Group;
import com.ssafy.user.dto.UserGroup;

public interface GroupMapper {
	
	int makeGroup(Group group);
	
	int makeUserGroup(int groupId, int userId);
	
	List<Group> getMyGroup(String userId);
	
	int deleteGroup(int groupId);
	
	Group updateGroup(int groupId);
	
	int insertUserGroup(UserGroup usergroup);
	
}
