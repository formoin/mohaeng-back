package com.ssafy.user.dto;

import lombok.Data;

@Data
public class User {
	private long id;
	private String userId;
	private String userPwd;
	private String userName;
	private String userPhone;
	private String birthday;
	private String message;
	private String img;
}
