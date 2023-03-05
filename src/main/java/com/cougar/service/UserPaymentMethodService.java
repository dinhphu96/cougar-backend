package com.cougar.service;

import java.util.List;

import com.cougar.entity.UserPaymentMethod;

public interface UserPaymentMethodService {

	List<UserPaymentMethod> getUserPaymenMethodByUserId(Integer userId);

}
