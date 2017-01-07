/*
 * 
 */
package com.practice.validation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * The Class ValidationUtilsTest.
 */
public class ValidationUtilsTest {
	
	
	/**
	 * Validate id test.
	 */
	@Test
	public void validateIdTest() {
		try {
			assertTrue(ValidationUtils.validateId("1"));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * Validate name test.
	 */
	@Test
	public void validateNameTest() {
		try {
			assertTrue(ValidationUtils.validateName("Mohammed"));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * Validate designation test.
	 */
	@Test
	public void validateDesignationTest() {
		try {
			assertTrue(ValidationUtils.validateDesignation("Developer"));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * Validate salary test.
	 */
	@Test
	public void validateSalaryTest() {
		try {
			assertTrue(ValidationUtils.validateSalary("1000"));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * Validate update field test.
	 */
	@Test
	public void validateUpdateFieldTest() {
		try {
			assertTrue(ValidationUtils.validateUpdateField("NAME"));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}

	/**
	 * Validate print all field test.
	 */
	@Test
	public void validatePrintAllFieldTest() {
		try {
			assertTrue(ValidationUtils.validatePrintAllField("ASC"));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}

}
