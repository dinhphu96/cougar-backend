package com.cougar.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponseDto {
	String accessToken;
	Integer id;
	String fullname;
	String Email;
	String phone;
	String avatar;
}
