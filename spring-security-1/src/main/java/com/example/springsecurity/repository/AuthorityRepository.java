package com.example.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecurity.entity.Authorities;
import com.example.springsecurity.entity.Users;

@Repository
public interface AuthorityRepository extends JpaRepository<Authorities, String> {

	public Authorities findByUsers(Users users);
}
