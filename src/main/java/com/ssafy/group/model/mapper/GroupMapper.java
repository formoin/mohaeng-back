package com.ssafy.group.model.mapper;

import java.util.List;

import com.ssafy.group.dto.Group;
import com.ssafy.user.dto.Groupuser;

public interface GroupMapper {
	
	int makeGroup(Group group);
	
	List<Group> getMyGroup(int userId);
	
	int deleteGroup(int groupId);
	
	Group updateGroup(int groupId);
	
	
}
