/*
 * 
 */
package com.practice.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface EmployeeRepository.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	/**
	 * Find all by order by name asc.
	 *
	 * @return the list
	 */
	public List<Employee> findAllByOrderByNameAsc();

	/**
	 * Find all by order by name desc.
	 *
	 * @return the list
	 */
	public List<Employee> findAllByOrderByNameDesc();
}
