package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.UserInfo;
import com.project.repository.UserInfoRepository;

@RestController
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	UserInfoRepository userInfoRepository;

	@PostMapping
	public ResponseEntity<?> createLocation(@RequestBody UserInfo userInfo) {
		PasswordEncoder password = new BCryptPasswordEncoder();
		userInfo.setPassword(password.encode(userInfo.getPassword()));
		UserInfo saved = userInfoRepository.save(userInfo);
		if (saved.getId() != 0)
			return new ResponseEntity<>("User Data Saved", HttpStatus.CREATED);
		return new ResponseEntity<>("User Data not saved ", HttpStatus.BAD_REQUEST);
	}

	@GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> getLocations() {
		return new ResponseEntity<>(userInfoRepository.findAll(), HttpStatus.OK);
	}

}
