package com.ssafy.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.user.dto.User;
import com.ssafy.user.model.service.UserSerivce;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	private final UserSerivce userService;

	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User loginInfo) throws Exception {
		String token = userService.login(loginInfo);

		if(token == null ) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디 또는 비밀번호가 잘못되었습니다.");

		return ResponseEntity.ok(token);
	}

	@PostMapping("/join")
	public ResponseEntity<?> join(@RequestBody User joinInfo) throws Exception{
		String token = userService.join(joinInfo);

		if(token == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원가입 실패");

		return ResponseEntity.ok(token);
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody User updateInfo, @RequestHeader("Authorization") String tokenHeader) throws Exception{
		
		//1. 토큰을 사용해 유저정보 조회
		User myInfo = userService.userInfo(tokenHeader.substring(7));	
		
		if(myInfo == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("정보 변경 실패");
		
		updateInfo.setId(myInfo.getId());
		int cnt = userService.update(updateInfo);

		 

		return ResponseEntity.ok(cnt);
	}
	
	@PutMapping("/pwd")
	public ResponseEntity<?> updatePwd(@RequestBody User updatePwd, @RequestHeader("Authorization") String tokenHeader) throws Exception{
		
		//1. 토큰을 사용해 유저정보 조회
		User myInfo = userService.userInfo(tokenHeader.substring(7));	
		
		if(myInfo == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("정보 변경 실패");
		
		updatePwd.setId(myInfo.getId());
		int cnt = userService.updatePwd(updatePwd);	 

		return ResponseEntity.ok(cnt);
	}
	
	@PutMapping("/msg")
	public ResponseEntity<?> updateMsg(@RequestBody User updateMsg, @RequestHeader("Authorization") String tokenHeader) throws Exception{
		
		//1. 토큰을 사용해 유저정보 조회
		User myInfo = userService.userInfo(tokenHeader.substring(7));	
		
		if(myInfo == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("정보 변경 실패");
		
		updateMsg.setId(myInfo.getId());
		int cnt = userService.updateMsg(updateMsg);	 

		return ResponseEntity.ok(cnt);
	}



	@GetMapping("/userInfo")
	public ResponseEntity<?> userInfo(@RequestHeader("Authorization") String tokenHeader) throws Exception{
		
		User myInfo = userService.userInfo(tokenHeader.substring(7));	
		if(myInfo == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("정보 조회 실패");

		return ResponseEntity.ok(myInfo);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> searchUserInfo(@RequestParam("keyword") String keyword) throws Exception{

		List<User> userList = userService.selectByKeyword(keyword);

		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<?> deleteUserInfo(@RequestParam("id") int userId) throws Exception{
		int cnt = userService.deleteUserInfo(userId);

		if(cnt == 0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("유저 삭제 실패");

		return ResponseEntity.ok(cnt);
	}
	
	@GetMapping("/checkid")
	public ResponseEntity<?> checkIdDuplication(@RequestParam("inputId") String inputId) throws Exception{

		
		if(!userService.checkIdDuplication(inputId)) return ResponseEntity.status(400).body("중복된 아이디 입니다.");
		return ResponseEntity.ok().body(null);
	}


}
