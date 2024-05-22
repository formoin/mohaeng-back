package com.ssafy.group.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import com.ssafy.group.dto.Group;
import com.ssafy.group.dto.MakegroupRequest;
import com.ssafy.group.model.service.GroupSerivce;
import com.ssafy.memory.dto.Memory;
import com.ssafy.user.dto.Groupuser;
import com.ssafy.user.dto.User;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {
	private final GroupSerivce groupSerivce;

	// group-info 
	@GetMapping
	public ResponseEntity<?> getGroupInfo(@RequestParam("groupId") int groupId) throws Exception {
		System.out.println(groupId);
		Group group = groupSerivce.getGroupInfo(groupId);
		if(group == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 정보 가져오기 실패");
		return ResponseEntity.ok(group);
	}
	@PostMapping
	public ResponseEntity<?> makeGroup(@RequestBody MakegroupRequest groupUser) throws Exception {
		int cnt = groupSerivce.makeGroup(groupUser);

		if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 만들기 실패");
		return ResponseEntity.ok(cnt);
	}

	@PutMapping
	public ResponseEntity<?> updateGroupInfo(@RequestBody Group updateInfo) throws Exception {
		int cnt = groupSerivce.updateGroupInfo(updateInfo);

		if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 정보 수정 실패");
		return ResponseEntity.ok(cnt);
	}
	@DeleteMapping
	public ResponseEntity<?> deleteGroup(@RequestParam("groupId") int groupId) throws Exception {

		int cnt=groupSerivce.deleteGroup(groupId);
		if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 삭제 실패");
		return ResponseEntity.ok(cnt);
	}
	
	// 그룹에 속한 유저 리스트 가져오기
	@GetMapping("/users")
	public ResponseEntity<?> getGroupMembers(@RequestParam("groupId") int groupId) throws Exception {
        List<User> list = groupSerivce.getGroupUsers(groupId);
        if(list==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 멤버 가져오기 실패");
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }
	
	// 그룹에 해당 멤버 추가
	@PutMapping("/users")
	public ResponseEntity<?> addGroupMembers(@RequestBody MakegroupRequest requestMakegroup) throws Exception {
		int cnt = groupSerivce.addGroupUsers(requestMakegroup);
		System.out.println("groupId " + requestMakegroup.getGroupInfo().getGroupId());
		if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹에 멤버 수정하기 실패");
		return ResponseEntity.ok(cnt);
	}
	
	// 그룹에서 해당 멤버 삭제
	@DeleteMapping("/users")
	public ResponseEntity<?> deleteGroupMember(@RequestParam("userId") int userId, @RequestParam("groupId") int groupId) throws Exception {
		Groupuser groupuser = new Groupuser();
		
		groupuser.setGroupId(groupId);
		groupuser.setUserId(userId);
		
		int cnt = groupSerivce.deleteGroupUser(groupuser);
		System.out.println("groupId " + groupuser.getGroupId());
		if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹에 멤버 삭제하기 실패");
		return ResponseEntity.ok(cnt);
	}


	// 유저가 해당하는 그룹 리스트 가져오기
	@GetMapping("/list")
	public ResponseEntity<?> myGroup(@RequestParam("userId") int userId) throws Exception {
		List<Group> list = groupSerivce.getMyGroups(userId);

		if(list==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 가져오기 실패");
		return new ResponseEntity<List<Group>>(list, HttpStatus.OK);
	}
	
	
	//	music
    @DeleteMapping("/music")
    public ResponseEntity<?> deleteMusic(@RequestParam int groupId) throws Exception {
        int cnt = groupSerivce.deleteMusic(groupId);
        if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("음악 삭제 실패");
        return ResponseEntity.ok(cnt);
    }

    @PutMapping("/music")
    public ResponseEntity<?> updateMusic(@RequestBody Group group) throws Exception {
        int cnt = groupSerivce.updateMusic(group);
        if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("음악 등록 실패");
        return ResponseEntity.ok(cnt);
    }
	
    
    // alarm check
    @GetMapping("/alarm")
    public ResponseEntity<?> updateAlarmCheck(@RequestParam("userId") int userId) throws Exception {
        List<Group> list = groupSerivce.updateAlarmCheck(userId);
        if(list==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 가져오기 실패");
		return new ResponseEntity<List<Group>>(list, HttpStatus.OK);
    }
	
    @DeleteMapping("/alarm")
    public ResponseEntity<?> deleteAlarmCheck(@RequestParam("userId") int userId) throws Exception {
        int cnt = groupSerivce.deleteAlarmCheck(userId);
        if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ㅇ안읽은 그룹 삭 실패");
		return ResponseEntity.ok(cnt);
    }
}
