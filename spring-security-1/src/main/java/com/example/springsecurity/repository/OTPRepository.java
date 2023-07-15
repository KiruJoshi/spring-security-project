package com.example.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecurity.entity.OTPEntity;
import com.example.springsecurity.entity.Users;

@Repository
public interface OTPRepository extends JpaRepository<OTPEntity, Long> {

	OTPEntity findByUsername(String username);

	OTPEntity findByOtp(String otp);
}
