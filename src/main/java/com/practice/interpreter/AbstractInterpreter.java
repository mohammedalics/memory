/*
 * 
 */
package com.practice.interpreter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.domain.EmployeeRepository;

/**
 * The Class AbstractInterpreter.
 */
@Component
abstract public class AbstractInterpreter implements Interpreter {

	/** The employee repository. */
	@Autowired
	private EmployeeRepository employeeRepository;

	/* (non-Javadoc)
	 * @see com.practice.interpreter.Interpreter#interpret(java.lang.String)
	 */
	@Override
	abstract public void interpret(String params) throws Exception;

	/**
	 * Validate.
	 *
	 * @param args the args
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	abstract boolean validate(String args) throws Exception;

	/**
	 * Gets the employee repository.
	 *
	 * @return the employee repository
	 */
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	/**
	 * Sets the employee repository.
	 *
	 * @param employeeRepository the new employee repository
	 */
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

}
