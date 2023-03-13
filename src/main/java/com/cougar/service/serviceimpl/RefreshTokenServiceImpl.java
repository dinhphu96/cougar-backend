package com.cougar.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cougar.entity.RefreshToken;
import com.cougar.repository.RefreshTokenDAO;
import com.cougar.service.RefreshTokenService;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService{
	@Autowired 
	RefreshTokenDAO refreshTokenDAO;

	@Override
	public RefreshToken save(RefreshToken refreshToken) {
		return refreshTokenDAO.save(refreshToken);
	}
	
	
}
