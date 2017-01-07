/*
 * 
 */
package com.practice.interpreter;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

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
 * The Class PrintInterpreterTest.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class PrintInterpreterTest {

	/** The employee repository. */
	@MockBean
	private EmployeeRepository employeeRepository;

	/** The print interpreter. */
	@Autowired
	private PrintInterpreter printInterpreter;

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
			List<Employee> empList = new ArrayList<Employee>();
			Employee emp1 = new Employee();

			emp1 = new Employee();
			emp1.setId(3L);
			emp1.setName("Amin");
			emp1.setDesignation("Quality");
			emp1.setMonthlySalary(5000L);
			empList.add(emp1);

			emp1 = new Employee();
			emp1.setId(2L);
			emp1.setName("Samir");
			emp1.setDesignation("Designer");
			emp1.setMonthlySalary(10000L);
			empList.add(emp1);

			emp1 = new Employee();
			emp1.setId(4L);
			emp1.setName("Bahaa");
			emp1.setDesignation("Manager");
			emp1.setMonthlySalary(23000L);
			empList.add(emp1);

			given(employeeRepository.exists(2L)).willReturn(true);
			given(employeeRepository.findOne(2L)).willReturn(empList.get(1));

			printInterpreter.interpret("2");
			assertThat(outContent.toString(), CoreMatchers.startsWith("Name:Samir"));
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
