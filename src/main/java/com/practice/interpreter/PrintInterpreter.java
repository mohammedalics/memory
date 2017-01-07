/*
 * 
 */
package com.practice.interpreter;

import org.springframework.stereotype.Component;

import com.practice.domain.Employee;
import com.practice.validation.ValidationUtils;

/**
 * The Class PrintInterpreter.
 */
@Component
public class PrintInterpreter extends AbstractInterpreter {

	/* (non-Javadoc)
	 * @see com.practice.interpreter.AbstractInterpreter#interpret(java.lang.String)
	 */
	@Override
	public void interpret(String params) throws Exception {
		if (validate(params)) {
			String[] splittedParams = params.split("-");
			Long id = Long.parseLong(splittedParams[0]);
			Employee emp = getEmployeeRepository().findOne(id);
			System.out.println(emp.toString());
		}
	}

	/* (non-Javadoc)
	 * @see com.practice.interpreter.AbstractInterpreter#validate(java.lang.String)
	 */
	@Override
	boolean validate(String args) throws Exception {
		String[] params = args.split("-");
		if (params != null && params.length < 1) {
			throw new Exception("insufficient attributes!");
		}

		// Validate id
		ValidationUtils.validateId(params[0]);

		// Validate id existence.
		if (!getEmployeeRepository().exists(Long.parseLong(params[0]))) {
			throw new Exception("Employee '" + params[0] + "' not found");
		}

		return true;
	}

}
