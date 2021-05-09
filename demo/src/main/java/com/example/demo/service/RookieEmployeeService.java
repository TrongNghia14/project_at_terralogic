package com.example.demo.service;

import com.example.demo.dto.RookieEmployeeDto;
import com.example.demo.dto.RookieEmployeeOutput;

public interface RookieEmployeeService {
	// find all and paging
	RookieEmployeeOutput findAll(int page, int limit);

	int totalItem();

	// find by id
	RookieEmployeeDto findById(Long id);

	// Create
	RookieEmployeeDto create(RookieEmployeeDto dto);

	// Update
	RookieEmployeeDto update(RookieEmployeeDto dto);

	// Delete one
	void deleteOne(Long id);

	// Delete many
	void deleteMany(Long[] ids);

}
