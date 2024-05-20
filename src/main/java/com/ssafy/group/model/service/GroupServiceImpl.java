package com.ssafy.group.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.group.dto.Group;
import com.ssafy.group.dto.MakegroupRequest;
import com.ssafy.group.model.mapper.GroupMapper;
import com.ssafy.group.model.mapper.GroupUserMapper;
import com.ssafy.user.dto.Groupuser;
import com.ssafy.user.dto.User;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupSerivce {
	private final GroupMapper groupMapper;
	private final GroupUserMapper groupUserMapper;

	@Override
	public Group getGroupInfo(int groupId) {
		Group group =  groupMapper.getGroupInfo(groupId);
		group.setTodayCnt(group.getTodayCnt()+1);
		group.setTotalCnt(group.getTotalCnt()+1);
		
		groupMapper.updateGroup(group);
		return group;
	}

	@Override
	public int makeGroup(MakegroupRequest requestInfo) {
		Group groupInfo = requestInfo.getGroupInfo();
		if(groupMapper.makeGroup(groupInfo) !=1) {
			System.out.println("그룹 만들기 실패");
//			return 0;
		}
		
		List<Integer> userList = requestInfo.getUserList();
		List<Groupuser> groupuserList = new ArrayList<>();
		System.out.println(groupInfo.getGroupId());
		for(Integer userId : userList) {
			Groupuser temp = new Groupuser();
			temp.setGroupId(groupInfo.getGroupId());
			temp.setUserId(userId);
			groupuserList.add(temp);
		}
		if(groupUserMapper.insertGroupUserList(groupuserList) !=1 ) {
			System.out.println("그룹-유저 등록 실패");
//			return 0;
		}
		
		return 1;
	}


	@Override
	public int updateGroupInfo(Group group) {
		
		return groupMapper.updateGroup(group);
	}

	@Override
	public int deleteGroup(int groupId) {
		return groupMapper.deleteGroup(groupId);
	}
	@Override
	public List<User> getGroupUsers(int groupId) {
		return groupUserMapper.getGroupUsers(groupId);
	}
	@Override
	public int addGroupUsers(MakegroupRequest groupuser) {
		int groupId = groupuser.getGroupInfo().getGroupId();
		List<Integer> userList = groupuser.getUserList();
		List<Groupuser> groupuserList = new ArrayList<>();
		for(Integer userId : userList) {
			Groupuser temp = new Groupuser();
			temp.setGroupId(groupId);
			temp.setUserId(userId);
			groupuserList.add(temp);
		}

		return groupUserMapper.insertGroupUserList(groupuserList);
	}

	@Override
	public int deleteGroupUsers(int groupId, int userId) {
		Groupuser groupuser = new Groupuser();
		groupuser.setGroupId(groupId);
		groupuser.setUserId(userId);
		return groupUserMapper.deleteGroupUsers(groupuser);
	}


	@Override
	public List<Group> getMyGroup(int userId) {
		return groupMapper.getMyGroup(userId);
	}
	
}
