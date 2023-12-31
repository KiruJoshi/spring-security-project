package com.example.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecurity.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,String> {

	public Users findByUsername(String username);

}
