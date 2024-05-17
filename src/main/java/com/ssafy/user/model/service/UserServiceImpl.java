package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.util.JWTUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.user.dto.User;
import com.ssafy.user.model.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserSerivce {
	private final UserMapper userMapper;
	private final JWTUtil jwtUtil;
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public String login(User loginInfo) throws Exception {
		String id = loginInfo.getUserId();
		String password = loginInfo.getUserPwd();	//사용자가 입력한 정보

		User member = userMapper.findById(id);	//DB로부터 조회한 정보
		if(member==null || !passwordEncoder.matches(password, member.getUserPwd()) ) return null;

		//토큰 만들어서 반환
		return jwtUtil.generateToken(member);
	}

	@Override
	public List<User> selectByKeyword(String keyword) throws Exception {
		
		return userMapper.selectByKeyword(keyword);
	}

	@Override
	public String join(User joinInfo) throws Exception {
		//비밀번호 암호화
		String encodedPassword = passwordEncoder.encode(joinInfo.getUserPwd());
		joinInfo.setUserPwd(encodedPassword);

		//DB에 저장
		userMapper.join(joinInfo);

		//토큰 만들어서 반환
		return jwtUtil.generateToken(joinInfo);
	}

	@Override
	public int update(User userInfo) throws Exception {
		
		return userMapper.update(userInfo);
	}
	
	@Override
	public User userInfo(String token) throws Exception {
		
		String userId = jwtUtil.getIdFromToken(token);
		return userMapper.findById(userId);

	}
	
	




}
