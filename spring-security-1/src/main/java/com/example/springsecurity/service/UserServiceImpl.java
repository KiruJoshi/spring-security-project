/*package com.example.springsecurity.service;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springsecurity.entity.Users;
import com.example.springsecurity.repository.OTPRepository;
import com.example.springsecurity.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private OTPRepository otpRepository;

	@Override
	public boolean isValidUser(String username, String password) {
		Users users = otpRepository.findByUsername(username);
		return users != null && users.getPassword().equals(password);
	}

	@Override
	public void saveOTP(String username, String otp) {
		Users user = otpRepository.findByUsername(username);
		if (user != null) {
			user.setOtp(otp);
			otpRepository.save(user);
		}

	}

	@Override
	public boolean isValidOTP(String otp) {
		Users user = otpRepository.findByOtp(otp);
		return user != null;
	}

}
*/