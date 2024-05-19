package com.ssafy.group.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.group.dto.Group;
import com.ssafy.group.dto.RequestMakegroup;
import com.ssafy.group.model.service.GroupSerivce;
import com.ssafy.user.dto.Groupuser;
import com.ssafy.user.dto.User;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
@CrossOrigin("*")
public class GroupController {
	private final GroupSerivce groupSerivce;

	@GetMapping("/{groupId}")
	public ResponseEntity<?> getGroupInfo(@PathVariable int groupId) throws Exception {
		System.out.println(groupId);
		Group group = groupSerivce.getGroupInfo(groupId);
		if(group == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 정보 가져오기 실패");
		return ResponseEntity.ok(group);
	}
	@PostMapping
	public ResponseEntity<?> makeGroup(@RequestBody RequestMakegroup groupUser) throws Exception {
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
	public ResponseEntity<?> addGroupMembers(@RequestBody RequestMakegroup requestMakegroup) throws Exception {
		int cnt = groupSerivce.addGroupUsers(requestMakegroup);
		if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹에 멤버 추가하기 실패");
		return ResponseEntity.ok(cnt);
	}

	@DeleteMapping("/users")
	public ResponseEntity<?> deleteGroupMembers(@RequestParam("groupId") int groupId, @RequestParam("userId") int userId) throws Exception {
		int cnt = groupSerivce.deleteGroupUsers(groupId, userId);

		if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 멤버 등록 실패");
		return ResponseEntity.ok(cnt);
	}


	@GetMapping("/users/list")
	public ResponseEntity<?> myGroup(@RequestParam("userId") int userId) throws Exception {
		List<Group> list = groupSerivce.getMyGroup(userId);

		if(list==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 가져오기 실패");
		return new ResponseEntity<List<Group>>(list, HttpStatus.OK);
	}

	
	
}
