package com.ssafy.group.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> myGroup(@PathVariable int userId) throws Exception {
        List<Group> list = groupSerivce.getMyGroup(userId);

        if(list==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 가져오기 실패");
        return new ResponseEntity<List<Group>>(list, HttpStatus.OK);
    }
	
	
	@GetMapping("/{groupId}")
	public ResponseEntity<?> getMembers(@PathVariable int groupId) throws Exception {
        List<User> list = groupSerivce.getGroupMember(groupId);

        if(list==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 멤버 가져오기 실패");
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }
	
	
	@PostMapping
	public ResponseEntity<?> makeGroup(@RequestBody RequestMakegroup gu) throws Exception {
		int cnt = groupSerivce.makeGroup(gu);
		
		if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 만들기 실패");
		return ResponseEntity.ok(cnt); 
	}
	
	@PostMapping("/invite")
	public ResponseEntity<?> addGroupUser(@RequestBody RequestMakegroup members) throws Exception {
		int cnt = groupSerivce.addGroupUsers(members);
		
		if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 멤버 등록 실패");
		return ResponseEntity.ok(cnt); 
	}
	
//	@DeleteMapping
//	public ResponseEntity<?> deleteGroup(@RequestBody RequestMakegroup members) throws Exception {
//		int cnt = groupSerivce.addGroupUsers(members);
//		
//		if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 멤버 등록 실패");
//		return ResponseEntity.ok(cnt); 
//	}
	
	@DeleteMapping("/{groupId}")
	public ResponseEntity<?> deleteGroup(@PathVariable int groupId) throws Exception {
		
		int cnt = groupSerivce.deleteGroup(groupId);
        if(cnt==0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("그룹 삭제 실패");
        return ResponseEntity.ok(cnt);
    }
	
	
	
	
}
