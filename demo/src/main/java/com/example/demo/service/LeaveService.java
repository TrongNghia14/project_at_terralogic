package com.example.demo.service;

import com.example.demo.dto.LeaveDto;
import com.example.demo.dto.LeaveOutput;

public interface LeaveService {
	// find all and paging
	LeaveOutput findAllByType(int page, int limit, String type);

	// find by id
	LeaveDto findById(Long id);

	// Create
	LeaveDto create(LeaveDto dto);

	// Update
	LeaveDto update(LeaveDto dto);

	// Delete one
	void deleteOne(Long id);

	// Delete many
	void deleteMany(Long[] ids);
}
