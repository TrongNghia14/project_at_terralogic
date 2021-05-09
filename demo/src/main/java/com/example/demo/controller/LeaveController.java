package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LeaveDto;
import com.example.demo.dto.LeaveOutput;
import com.example.demo.service.LeaveService;

@CrossOrigin(origins = "http://localhost:3000") // Thêm dòng này để connect với UI dc tạo bên react
@RestController
@RequestMapping("/api/balance")
public class LeaveController {

	@Autowired
	private LeaveService leaveService;

	// Find all and paging
	@GetMapping(value = "/leave") // demo on postman:
									// "http://localhost:8080/api/balance/leave?page=1&limit=2&type=sick"
	public LeaveOutput show(@RequestParam("page") int page, @RequestParam("limit") int limit,
			@RequestParam("type") String type) {

		return leaveService.findAllByType(page, limit, type);
	}

	// Find casual by ID
	@GetMapping("/leave/{id}") // demo on postman: "http://localhost:8080/api/balance/leave/1"
	public LeaveDto findById(@PathVariable Long id) {
		return leaveService.findById(id);
	}

	// Add new casual
	@PostMapping("/leave") // demo on postman: "http://localhost:8080/api/balance/leave"
	public LeaveDto create(@RequestBody LeaveDto dto) {
		return leaveService.create(dto);
	}

	// Update casual
	@PutMapping("/leave") // demo on postman: "http://localhost:8080/api/balance/leave"
	public LeaveDto update(@RequestBody LeaveDto dto) {
		return leaveService.update(dto);
	}

	// Delete one
	@DeleteMapping("/leave/{id}") // demon on postman: "http://localhost:8080/api/balance/leave/4"
	public void deleteOne(@PathVariable Long id) {
		leaveService.deleteOne(id);
	}

	// Delete many
	@DeleteMapping("/leave")
	public void delete(@RequestBody Long[] ids) {
		leaveService.deleteMany(ids);
	}

}
