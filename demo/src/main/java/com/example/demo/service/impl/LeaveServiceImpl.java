package com.example.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.converter.LeaveConverter;
import com.example.demo.dto.LeaveDto;
import com.example.demo.dto.LeaveOutput;
import com.example.demo.model.Leave;
import com.example.demo.model.Employee;
import com.example.demo.repository.LeaveRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.LeaveService;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveRepository leaveRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private LeaveConverter convert;

	// Find all and paging
	@Override
	public LeaveOutput findAllByType(int page, int limit, String type) {
		Pageable pageable = PageRequest.of(page - 1, limit);
		Page<Leave> pageLeave = leaveRepository.findAllByType(type, pageable);
		if (type.equals("all")) {
			pageLeave = leaveRepository.findAll(pageable);
		}
		List<Leave> listLeaves = pageLeave.getContent();
		page = pageLeave.getNumber() + 1;
		LeaveOutput result = new LeaveOutput();
		result.setPage(page);
		result.setTotalPage(pageLeave.getTotalPages());
		result.setTotalItem(pageLeave.getTotalElements());
		result.setListResult(convert.toDto(listLeaves));

		return result;
	}

	// Find by id
	@Override
	public LeaveDto findById(Long id) {
		Leave leave = leaveRepository.findById(id).orElse(null);
		return convert.toDto(leave);
	}

	// Create
	@Override
	public LeaveDto create(LeaveDto dto) {
		Leave leave = convert.toEntity(dto);
		leave.setEmployee(employeeRepository.findById(dto.getEmployee_id()).orElse(null));
		leave = leaveRepository.save(leave);
		return convert.toDto(leave);
	}

	// Update
	@Override
	public LeaveDto update(LeaveDto dto) {
		Leave oldCasualLeave = leaveRepository.findById(dto.getId()).orElse(null);
		Leave newCasualLeave = convert.toEntity(dto, oldCasualLeave);
		Employee empl = employeeRepository.findById(dto.getEmployee_id()).orElse(null);
		newCasualLeave.setEmployee(empl);
		newCasualLeave = leaveRepository.save(newCasualLeave);
		return convert.toDto(newCasualLeave);
	}

	// Delete one
	@Override
	public void deleteOne(Long id) {
		leaveRepository.deleteById(id);
	}

	// Delete many
	@Override
	@Transactional
	public void deleteMany(Long[] ids) {
		Iterable<Long> iterable = Arrays.asList(ids);
		leaveRepository.deleteByIdIn(iterable);
	}

}