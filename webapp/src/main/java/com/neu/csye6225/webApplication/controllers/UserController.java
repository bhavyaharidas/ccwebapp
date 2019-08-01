package com.neu.csye6225.webApplication.controllers;

import java.sql.Timestamp;
import java.util.Date;

import com.timgroup.statsd.StatsDClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.neu.csye6225.webApplication.entity.User;
import com.neu.csye6225.webApplication.service.UserService;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserController {

	private final static Logger logger = LoggerFactory.getLogger(BooksController.class);

	@Autowired
	private StatsDClient statsDClient;

	@Autowired
	private UserService userService;

	Date date= new Date();
	long time = date.getTime();

	@GetMapping("/")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Timestamp login() {
		logger.info("User login : start");
		statsDClient.incrementCounter("endpoint.user.http.get");
		Timestamp ts = new Timestamp(time);
		logger.info("User login : Success!");
		return ts;
	}
	
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody User user) {
		logger.info("User register : start");
		statsDClient.incrementCounter("endpoint.user.http.post");
		String message = userService.create(user);
		if(message == "User already exists" || message == "Password length should be greater than 1" ) {
			logger.error(message);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
			//logger.info("User register : User exists!");
		}
		logger.info("User register : Succcess!");
		return message;
	}
}
