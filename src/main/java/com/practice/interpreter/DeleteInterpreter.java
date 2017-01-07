/*
 * 
 */
package com.practice.interpreter;

import org.springframework.stereotype.Component;

import com.practice.validation.ValidationUtils;

/**
 * The Class DeleteInterpreter.
 */
@Component
public class DeleteInterpreter extends AbstractInterpreter {

	/* (non-Javadoc)
	 * @see com.practice.interpreter.AbstractInterpreter#interpret(java.lang.String)
	 */
	@Override
	public void interpret(String params) throws NumberFormatException, Exception {
		if (validate(params)) {
			String[] splittedParams = params.split("-");
			Long id = Long.parseLong(splittedParams[0]);
			getEmployeeRepository().delete(id);
			System.out.println("Employee '" + splittedParams[0] + "' deleted successfully");
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
