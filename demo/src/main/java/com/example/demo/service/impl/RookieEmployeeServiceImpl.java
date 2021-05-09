package com.example.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.converter.RookieEmployeeConverter;
import com.example.demo.dto.RookieEmployeeDto;
import com.example.demo.dto.RookieEmployeeOutput;
import com.example.demo.model.RookieEmployee;
import com.example.demo.repository.RookieEmployeeRepository;
import com.example.demo.service.RookieEmployeeService;

@Service
public class RookieEmployeeServiceImpl implements RookieEmployeeService {

	@Autowired
	private RookieEmployeeRepository rookieEmployeeRepository;

	@Autowired
	private RookieEmployeeConverter convert;

	// Find all
	@Override
	public RookieEmployeeOutput findAll(int page, int limit) {
		Pageable pageable = PageRequest.of(page - 1, limit);
		List<RookieEmployee> entities = rookieEmployeeRepository.findAll(pageable).getContent();
		RookieEmployeeOutput result = new RookieEmployeeOutput();
		result.setPage(page);
		result.setListResult(convert.toDto(entities));
		result.setTotalPage((int) Math.ceil((double) (totalItem()) / limit));
		return result;
	}

	@Override
	public int totalItem() {
		return (int) rookieEmployeeRepository.count();
	}

	// Find by id
	@Override
	public RookieEmployeeDto findById(Long id) {
		RookieEmployee find = rookieEmployeeRepository.findById(id).orElse(null);
		return convert.toDto(find);
	}

	// Add
	@Override
	public RookieEmployeeDto create(RookieEmployeeDto dto) {
		RookieEmployee rookieEmployee = convert.toEntity(dto);
		rookieEmployee = rookieEmployeeRepository.save(rookieEmployee);
		return convert.toDto(rookieEmployee);
	}

	// Update
	@Override
	public RookieEmployeeDto update(RookieEmployeeDto dto) {
		RookieEmployee newRookieEmployee = new RookieEmployee();
		RookieEmployee oldRookieEmployee = rookieEmployeeRepository.findById(dto.getId()).orElse(null);
		newRookieEmployee = convert.toEntity(dto, oldRookieEmployee);
		newRookieEmployee = rookieEmployeeRepository.save(newRookieEmployee);
		return convert.toDto(newRookieEmployee);
	}

	// Delete many
	@Override
	@Transactional
	public void deleteMany(Long[] ids) {
		Iterable<Long> iterable = Arrays.asList(ids);
		rookieEmployeeRepository.deleteByIdIn(iterable);
	}

	// Delete one
	@Override
	public void deleteOne(Long id) {
		rookieEmployeeRepository.deleteById(id);
	}

}
