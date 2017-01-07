/*
 * 
 */
package com.practice.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The Class EmployeeRepositoryTest.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
public class EmployeeRepositoryTest {

	/** The entity manager. */
	@Autowired
	private TestEntityManager entityManager;

	/** The employee repository. */
	@Autowired
	private EmployeeRepository employeeRepository;

	/** The emp. */
	private Employee emp = null;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		emp = new Employee();
		emp.setId(1L);
		emp.setName("Mohammed");
		emp.setDesignation("developer");
		emp.setMonthlySalary(20000L);
		entityManager.persist(emp);

		Employee emp1 = new Employee();
		emp1.setId(2L);
		emp1.setName("Samir");
		emp1.setDesignation("Designer");
		emp1.setMonthlySalary(10000L);
		entityManager.persist(emp1);

		emp1 = new Employee();
		emp1.setId(3L);
		emp1.setName("Amin");
		emp1.setDesignation("Quality");
		emp1.setMonthlySalary(5000L);
		entityManager.persist(emp1);

		emp1 = new Employee();
		emp1.setId(4L);
		emp1.setName("Bahaa");
		emp1.setDesignation("Manager");
		emp1.setMonthlySalary(23000L);
		entityManager.persist(emp1);

	}

	/**
	 * Save employee test.
	 */
	@Test
	public void saveEmployeeTest() {
		emp = entityManager.find(Employee.class, 1L);
		assertNotNull(emp);
	}

	/**
	 * Update employee test.
	 */
	@Test
	public void updateEmployeeTest() {
		emp.setName("Sara");
		employeeRepository.save(emp);
		emp = entityManager.find(Employee.class, 1L);
		assertSame("Sara", emp.getName());
	}

	/**
	 * Delete employee test.
	 */
	@Test
	public void deleteEmployeeTest() {
		employeeRepository.delete(emp);
		emp = entityManager.find(Employee.class, 1L);
		assertNull(emp);
	}

	/**
	 * Find employee test.
	 */
	@Test
	public void findEmployeeTest() {
		entityManager.persist(emp);
		employeeRepository.findOne(emp.getId());
		assertNotNull(emp);
	}

	/**
	 * Find all by order by name asc test.
	 */
	@Test
	public void findAllByOrderByNameAscTest() {
		List<Employee> empList = employeeRepository.findAllByOrderByNameAsc();
		assertSame("Amin", empList.get(0).getName());
	}

	/**
	 * Find all by order by name desc.
	 */
	@Test
	public void findAllByOrderByNameDesc() {
		List<Employee> empList = employeeRepository.findAllByOrderByNameDesc();
		assertSame("Samir", empList.get(0).getName());
	}

}