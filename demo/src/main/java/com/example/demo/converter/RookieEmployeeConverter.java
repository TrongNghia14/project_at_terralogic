package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.RookieEmployeeDto;
import com.example.demo.model.RookieEmployee;

@Component
public class RookieEmployeeConverter {

	public RookieEmployeeDto toDto(RookieEmployee empl) {
		RookieEmployeeDto dto = new RookieEmployeeDto();
		dto.setId(empl.getId());
		dto.setDateJoin(empl.getDateJoin());
		dto.setLocation(empl.getLocation());
		dto.setPosition(empl.getPosition());
		dto.setRookieName(empl.getRookieName());
		return dto;
	}

	public List<RookieEmployeeDto> toDto(List<RookieEmployee> empl) {
		return empl.stream().map(x -> toDto(x)).collect(Collectors.toList());
	}

	public RookieEmployee toEntity(RookieEmployeeDto dto) {
		RookieEmployee empl = new RookieEmployee();
		empl.setId(dto.getId());
		empl.setRookieName(dto.getRookieName());
		empl.setDateJoin(dto.getDateJoin());
		empl.setPosition(dto.getPosition());
		empl.setLocation(dto.getLocation());
		return empl;
	}

//	public List<RookieEmployee> dtoToEntity(List<RookieEmployeeDto> dto) {
//		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
//	}

	// use for update employee
	public RookieEmployee toEntity(RookieEmployeeDto dto, RookieEmployee empl) {
		empl.setRookieName(dto.getRookieName());
		empl.setPosition(dto.getPosition());
		empl.setLocation(dto.getLocation());
		empl.setDateJoin(dto.getDateJoin());
		return empl;
	}
}
