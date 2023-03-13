package com.cougar.security;

public class SecurityConstants {
	public static final long JWT_EXPIRATION = 10*60*1000;
	public static final long JWT_REFRESH_TOKEN_EXPIRATION = 100*60*1000;
	public static final String JWT_SECRET = "secret";
}
