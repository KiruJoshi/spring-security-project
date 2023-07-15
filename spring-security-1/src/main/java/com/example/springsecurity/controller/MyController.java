package com.example.springsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/")
	public ResponseEntity<String> foreveyone() {

		return ResponseEntity.ok("Open for eveyone. enjoy");
	}

	@GetMapping("/normal")
	public ResponseEntity<String> getNormalUser() {

		return ResponseEntity.ok("Yes...I am normal user");
	}

	@GetMapping("/public")
	public ResponseEntity<String> getPublicUser() {

		return ResponseEntity.ok("Yes...I am public user");
	}

	@GetMapping("/admin")
	public ResponseEntity<String> getAdminUser() {

		return ResponseEntity.ok("Yes...I am admin user");
	}

	// @PreAuthorize("hasRole('Admin')")
	@GetMapping("/secretpoint")
	public ResponseEntity<String> getSecretUser() {

		return ResponseEntity.ok("Yes...I am secret user");
	}

}