package com.ssafy.group.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
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
	public int deleteGroupUser(Groupuser groupuser) {
		return groupUserMapper.deleteGroupUser(groupuser);
	}
	

	@Override
	public List<Group> getMyGroups(int userId) {
		return groupMapper.getMyGroup(userId);
	}

	@Override
	@Scheduled(cron = "0 0 0 * * *")
	public int setTodayVisitZero() {
		return groupMapper.setTodayVisitZero();
	}

	@Override
	public int deleteMusic(int groupId) {
		return groupMapper.deleteMusic(groupId);
	}

	@Override
	public int updateMusic(Group group) {
		return groupMapper.updateMusic(group);
	}

	@Override
	public List<Group> updateAlarmCheck(int userId) {

		List<Group> groupInfo = groupUserMapper.getGroupInfo(userId);
		groupUserMapper.setCheckTrue(userId);
		
		return groupInfo;
	}





	
}
