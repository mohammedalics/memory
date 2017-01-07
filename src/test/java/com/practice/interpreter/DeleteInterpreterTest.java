/*
 * 
 */
package com.practice.interpreter;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

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

import com.practice.domain.EmployeeRepository;

/**
 * The Class DeleteInterpreterTest.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class DeleteInterpreterTest {

	/** The employee repository. */
	@MockBean
	private EmployeeRepository employeeRepository;

	/** The delete interpreter. */
	@Autowired
	private DeleteInterpreter deleteInterpreter;

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
			given(employeeRepository.exists(1L)).willReturn(true);
			doNothing().when(employeeRepository).delete(1L);
			deleteInterpreter.interpret("1");
			assertThat(outContent.toString(), CoreMatchers.startsWith("Employee '1' deleted successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);

		}
	}

	/**
	 * Clean.
	 */
	@After
	public void clean() {
		System.setOut(null);
		System.setErr(null);
	}

}
