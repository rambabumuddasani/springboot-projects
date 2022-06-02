package com.sample.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping(value = "/api/v1/users")
@CrossOrigin("*")
public class UserController {

	@Operation(summary = "get users by city", description = "get users by city", parameters = {
			@Parameter(name = "city", in = ParameterIn.PATH, description = "city ex: Bangalore", schema = @Schema(type = "string", allowableValues = {
					"Bangalore", "Chennai", "Hyderabad" })) })
	@GetMapping("/by-city/{city}")
	public ResponseEntity<Map<String, Object>> infoByCity(@PathVariable(name = "city") String city) {

		Map<String, Object> result = new HashMap<>();

		return ResponseEntity.ok(result);

	}

	@Hidden
	@Operation(summary = "about me", description = "Details about myself")
	@GetMapping("/myself")
	public ResponseEntity<Map<String, Object>> aboutMe() {

		Map<String, Object> result = new HashMap<>();

		return ResponseEntity.ok(result);

	}

}