package com.ssafy.user.dto;

import lombok.Data;

@Data
public class User {
	private long id;
	private String userId;
	private String userPassword;
	private String userName;
	private String userPhone;
}
