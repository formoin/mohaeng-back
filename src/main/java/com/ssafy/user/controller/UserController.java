package com.ssafy.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.user.dto.User;
import com.ssafy.user.model.service.UserSerivce;
import com.ssafy.util.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
	private final UserSerivce userService;

	@GetMapping("/search")
	public ResponseEntity<?> userList() throws Exception {
		List<User> list = userService.selectAll();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User loginInfo) throws Exception {
		String token = userService.login(loginInfo);

		if(token == null ) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디 또는 비밀번호가 잘못되었습니다.");

		return ResponseEntity.ok(token);
	}

	@PostMapping("/join")
	public ResponseEntity<?> join(@RequestBody User joinInfo){
		String token = userService.join(joinInfo);

		if(token == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원가입 실패");

		return ResponseEntity.ok(token);
	}




}
