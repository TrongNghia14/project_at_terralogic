package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RookieEmployeeDto;
import com.example.demo.dto.RookieEmployeeOutput;
import com.example.demo.service.RookieEmployeeService;

@RestController
@RequestMapping("/api/onboarding")
public class RookieEmployeeController {
	@Autowired
	private RookieEmployeeService rookieEmployeeService;

	// Find all and paging
	@GetMapping(value = "/rookie") // demo on postman: "http://localhost:8080/api/onboarding/rookie?page=1&limit=2"
	public RookieEmployeeOutput show(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		return rookieEmployeeService.findAll(page, limit);
	}

	// Find casual by ID
	@GetMapping("/rookie/{id}") // demo on postman: "http://localhost:8080/api/onboarding/rookie/1"
	public RookieEmployeeDto findById(@PathVariable Long id) {
		return rookieEmployeeService.findById(id);
	}

	// Add new casual
	@PostMapping("/rookie") // demo on postman: "http://localhost:8080/api/onboarding/rookie"
	public RookieEmployeeDto create(@RequestBody RookieEmployeeDto dto) {
		return rookieEmployeeService.create(dto);
	}

	// Update casual
	@PutMapping("/rookie/{id}") // demo on postman: "http://localhost:8080/api/onboarding/rookie/1"
	public RookieEmployeeDto update(@PathVariable Long id, @RequestBody RookieEmployeeDto dto) {
		dto.setId(id);
		return rookieEmployeeService.update(dto);
	}

	// Delete one
	@DeleteMapping("/rookie/{id}") // demo on postman: "http://localhost:8080/api/onboarding/rookie/4"
	public void deleteOne(@PathVariable Long id) {
		rookieEmployeeService.deleteOne(id);
	}

	// Delete many
	@DeleteMapping("/rookie")
	public void deleteMany(@RequestBody Long[] ids) {
		rookieEmployeeService.deleteMany(ids);
	}
}
