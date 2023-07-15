/*package com.example.springsecurity.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.entity.Users;
import com.example.springsecurity.service.UserService;

import ch.qos.logback.core.model.Model;

@RestController
public class MyOtpController {
	
	  private static final int OTP_LENGTH = 6;

	    @Autowired
	    private UserService userService;

	    @GetMapping("/")
	    public String showLoginPage(@RequestParam Users user) {
	        //model.addAttribute("users", new Users());
	        return "login";
	    }

	    @PostMapping("/login")
	    public String login(@RequestBody Users user) {
	        // Check if the user exists in the database
	       if(userService.isValidUser(user.getUsername(),user.getPassword())){
	    	   String generateOTP = generateOTP(OTP_LENGTH);
	    	    userService.saveOTP(user.getUsername(),generateOTP);
		      
	            return "Successfully otp generated ,,you can check on your mysql!!";
	        }
	       else {

	        return "failed to Login...you have problm in your database username and password";
	    }
	    }
	    @PostMapping("/verifyOTP")
	    public String verifyOTP(@RequestParam("otp") String otp) {
	        // Verify OTP
	        if (userService.isValidOTP(otp)) {
	            // OTP is correct, grant access to the API
	            return "success";
	        } else {
	            return "login";
	        }
	    }

	    // Helper method to generate OTP
	    private String generateOTP(int length) {
	        String numbers = "0123456789";
	        Random random = new Random();
	        StringBuilder sb = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(numbers.length());
	            sb.append(numbers.charAt(index));
	        }
	        return sb.toString();
	    }

}
*/