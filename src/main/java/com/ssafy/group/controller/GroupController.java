package com.ssafy.group.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import com.ssafy.group.dto.Group;
import com.ssafy.group.dto.MakegroupRequest;
import com.ssafy.group.model.service.GroupSerivce;
import com.ssafy.user.dto.Groupuser;
import com.ssafy.user.dto.User;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {
	private final GroupSerivce groupSerivce;

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
	
	
	@GetMapping("/users")
	public ResponseEntity<?> getGroupMembers(@RequestParam("groupId") int groupId) throws Exception {
        List<User> list = groupSerivce.getGroupUsers(groupId);
        if(list==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 멤버 가져오기 실패");
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }
	
	@PutMapping("/users")
	public ResponseEntity<?> addGroupMembers(@RequestBody MakegroupRequest requestMakegroup) throws Exception {
		int cnt = groupSerivce.addGroupUsers(requestMakegroup);
		System.out.println("groupId " + requestMakegroup.getGroupInfo().getGroupId());
		if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹에 멤버 수정하기 실패");
		return ResponseEntity.ok(cnt);
	}



	@GetMapping("/list")
	public ResponseEntity<?> myGroup(@RequestParam("userId") int userId) throws Exception {
		List<Group> list = groupSerivce.getMyGroup(userId);

		if(list==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 가져오기 실패");
		return new ResponseEntity<List<Group>>(list, HttpStatus.OK);
	}
	
	
	
}
