package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Leave;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {
	Page<Leave> findAllByType(String type, Pageable pageable);

	void deleteByIdIn(Iterable<Long> ids);
}
