package com.ssafy.group.model.service;

import java.util.List;

import com.ssafy.group.dto.Group;
import com.ssafy.group.dto.RequestMakegroup;

public interface GroupSerivce {
	int makeGroup(RequestMakegroup requestInfo);
	int updateGroup(RequestMakegroup updateInfo);
	int deleteGroup(int group);
	List<Group> getMyGroup(String userId);
}
