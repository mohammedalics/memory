/*
 * 
 */
package com.practice.interpreter;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.practice.domain.Employee;
import com.practice.domain.EmployeeRepository;

/**
 * The Class UpdateInterpreterTest.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class UpdateInterpreterTest {

	/** The employee repository. */
	@MockBean
	private EmployeeRepository employeeRepository;

	/** The update interpreter. */
	@Autowired
	private UpdateInterpreter updateInterpreter;

	/** The out content. */
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	/** The err content. */
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	/**
	 * Interpret test.
	 */
	@Test
	public void interpretTest() {
		try {
			Employee emp1 = new Employee();

			emp1 = new Employee();
			emp1.setId(3L);
			emp1.setName("Amin");
			emp1.setDesignation("Quality");
			emp1.setMonthlySalary(5000L);

			given(employeeRepository.exists(3L)).willReturn(true);
			given(employeeRepository.findOne(3L)).willReturn(emp1);
			given(employeeRepository.save(any(Employee.class))).willReturn(emp1);
			updateInterpreter.interpret("3-Name-Samir");
			assertThat(outContent.toString(), CoreMatchers.startsWith("Employee '3' updated."));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * Clean up.
	 */
	@After
	public void cleanUp() {
		System.setOut(null);
		System.setErr(null);
	}

}
