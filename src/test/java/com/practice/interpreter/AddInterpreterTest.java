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
 * The Class AddInterpreterTest.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")

@SpringBootTest
public class AddInterpreterTest {

	/** The employee repository. */
	@MockBean
	private EmployeeRepository employeeRepository;

	/** The add interpreter. */
	@Autowired
	private AddInterpreter addInterpreter;

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
			Employee emp = new Employee();
			emp.setId(1L);
			emp.setName("Mohammed");
			emp.setDesignation("Developer");
			emp.setMonthlySalary(2000L);
			given(employeeRepository.exists(1L)).willReturn(false);
			given(employeeRepository.save(any(Employee.class))).willReturn(emp);
			addInterpreter.interpret("1-Mohammed-Developer-2000");
			assertThat(outContent.toString(), CoreMatchers.startsWith("Employee '1' added successfully."));
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
