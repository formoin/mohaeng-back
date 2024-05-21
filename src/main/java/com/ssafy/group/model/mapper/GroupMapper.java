package com.ssafy.group.model.mapper;

import java.util.List;

import com.ssafy.group.dto.Group;



public interface GroupMapper {
	
	int makeGroup(Group group);

	Group getGroupInfo(int groupId);
	
	List<Group> getMyGroup(int userId);
	
	int updateGroup(Group groupId);
	int deleteGroup(int groupId);
	
	int setTodayVisitZero();
	
	
	
	//music
	
	int deleteMusic(int groupId) ;

	int updateMusic(Group group) ;

}
