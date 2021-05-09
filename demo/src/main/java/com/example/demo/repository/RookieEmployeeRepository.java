package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RookieEmployee;

@Repository
public interface RookieEmployeeRepository extends JpaRepository<RookieEmployee, Long> {
	void deleteByIdIn(Iterable<Long> ids);
}
