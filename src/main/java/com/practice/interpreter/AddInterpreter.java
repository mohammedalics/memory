/*
 * 
 */
package com.practice.interpreter;

import org.springframework.stereotype.Component;

import com.practice.domain.Employee;
import com.practice.validation.ValidationUtils;

/**
 * The Class AddInterpreter.
 */
@Component
public class AddInterpreter extends AbstractInterpreter {

	/* (non-Javadoc)
	 * @see com.practice.interpreter.AbstractInterpreter#interpret(java.lang.String)
	 */
	@Override
	public void interpret(String params) throws Exception {

		if (validate(params)) {
			String[] splittedParams = params.split("-");
			Employee emp = new Employee(Long.parseLong(splittedParams[0]), splittedParams[1], splittedParams[2],
					Long.parseLong(splittedParams[3]));
			getEmployeeRepository().save(emp);
			System.out.println("Employee '" + splittedParams[0] + "' added successfully. Total no of employees = "
					+ getEmployeeRepository().count());
		}
	}

	/* (non-Javadoc)
	 * @see com.practice.interpreter.AbstractInterpreter#validate(java.lang.String)
	 */
	@Override
	boolean validate(String args) throws Exception {
		String[] params = args.split("-");
		if (params != null && params.length < 4) {
			throw new Exception("insufficient attributes!");
		}

		// Validate id
		ValidationUtils.validateId(params[0]);

		// Validate id existence.
		if (getEmployeeRepository().exists(Long.parseLong(params[0]))) {
			throw new Exception("Employee id '" + params[0] + "' is exists");
		}

		// Validate name
		ValidationUtils.validateName(params[1]);

		// Validate designation
		ValidationUtils.validateDesignation(params[2]);

		// Validate salary
		ValidationUtils.validateSalary(params[3]);

		return true;
	}
}
