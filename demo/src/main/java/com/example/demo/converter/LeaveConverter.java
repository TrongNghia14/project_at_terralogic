package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.LeaveDto;
import com.example.demo.model.Leave;

@Component
public class LeaveConverter {

	public Leave toEntity(LeaveDto dto) {
		Leave entity = new Leave();
		entity.setType(dto.getType());
		entity.setSchedule(dto.getSchedule());
		entity.setPolicy(dto.getPolicy());
		entity.setCurrentBalance(dto.getCurrentBalance());
		return entity;
	}

	// Convert for list
	public List<LeaveDto> toDto(List<Leave> leave) {
		return leave.stream().map(x -> toDto(x)).collect(Collectors.toList());
	}

	// Use for find all
	public LeaveDto toDto(Leave entity) {
		LeaveDto dto = new LeaveDto();
		if (String.valueOf(entity.getId()) != null)
			dto.setId(entity.getId());
		dto.setType(entity.getType());
		dto.setPolicy(entity.getPolicy());
		dto.setCurrentBalance(entity.getCurrentBalance());
		dto.setSchedule(entity.getSchedule());
		dto.setFullName(entity.getEmployee().getFirstName() + " " + entity.getEmployee().getLastName());
		dto.setEmployee_id(entity.getEmployee().getId());
		return dto;
	}

	// use for update employee
	public Leave toEntity(LeaveDto dto, Leave c) {
		c.setType(dto.getType());
		c.setPolicy(dto.getPolicy());
		c.setCurrentBalance(dto.getCurrentBalance());
		c.setSchedule(dto.getSchedule());
		return c;
	}
}
