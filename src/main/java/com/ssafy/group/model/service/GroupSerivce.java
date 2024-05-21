package com.ssafy.group.model.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.ssafy.group.dto.Group;
import com.ssafy.group.dto.MakegroupRequest;
import com.ssafy.user.dto.Groupuser;
import com.ssafy.user.dto.User;

public interface GroupSerivce {
	int makeGroup(MakegroupRequest requestInfo);
	Group getGroupInfo(int groupId);

	int updateGroupInfo(Group group);
	
	int deleteGroup(int groupId);
	List<User> getGroupUsers(int groupId);
	int addGroupUsers(MakegroupRequest requestInfo);
	List<Group> getMyGroup(int userId);
	
	
	int setTodayVisitZero();
	
	
	
	//music
	
	int deleteMusic(int groupId);
	int updateMusic(Group group);

}
