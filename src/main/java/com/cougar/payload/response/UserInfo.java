package com.cougar.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
	private Integer id;
	private String fullname;
	private String email;
	private String phone;
	private String avatar;
	private Object roles;
}
