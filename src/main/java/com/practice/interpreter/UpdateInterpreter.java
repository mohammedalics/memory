/*
 * 
 */
package com.practice.interpreter;

import org.springframework.stereotype.Component;

import com.practice.constants.MemoryConstants;
import com.practice.domain.Employee;
import com.practice.validation.ValidationUtils;

/**
 * The Class UpdateInterpreter.
 */
@Component
public class UpdateInterpreter extends AbstractInterpreter {

	/* (non-Javadoc)
	 * @see com.practice.interpreter.AbstractInterpreter#interpret(java.lang.String)
	 */
	@Override
	public void interpret(String params) throws Exception {
		if (validate(params)) {
			String[] splittedParams = params.split("-");
			Long id = Long.parseLong(splittedParams[0]);
			Employee emp = getEmployeeRepository().findOne(id);
			if (MemoryConstants.UPDATE_NAME_PARAM.equalsIgnoreCase(splittedParams[1])) {
				emp.setName(splittedParams[2]);
			} else if (MemoryConstants.UPDATE_SALARY_PARAM.equalsIgnoreCase(splittedParams[1])) {
				emp.setMonthlySalary(Long.parseLong(splittedParams[2]));
			} else if (MemoryConstants.UPDATE_DESIG_PARAM.equalsIgnoreCase(splittedParams[1])) {
				emp.setDesignation(splittedParams[2]);
			}
			getEmployeeRepository().save(emp);

			System.out.println("Employee '" + emp.getId() + "' updated. " + emp.toString());

		}
	}

	/* (non-Javadoc)
	 * @see com.practice.interpreter.AbstractInterpreter#validate(java.lang.String)
	 */
	@Override
	boolean validate(String args) throws Exception {
		String[] params = args.split("-");
		if (params != null && params.length < 3) {
			throw new Exception("insufficient attributes!");
		}

		// Validate id
		ValidationUtils.validateId(params[0]);

		// Validate id existence.
		if (!getEmployeeRepository().exists(Long.parseLong(params[0]))) {
			throw new Exception("Employee '" + params[0] + "' not found");
		}

		// Validate target field to be updated
		ValidationUtils.validateUpdateField(params[1]);

		// Validate value.
		if (MemoryConstants.UPDATE_NAME_PARAM.equalsIgnoreCase(params[1])) {
			ValidationUtils.validateName(params[2]);
		} else if (MemoryConstants.UPDATE_SALARY_PARAM.equalsIgnoreCase(params[1])) {
			ValidationUtils.validateSalary(params[2]);
		} else if (MemoryConstants.UPDATE_DESIG_PARAM.equalsIgnoreCase(params[1])) {
			ValidationUtils.validateDesignation(params[2]);
		}
		return true;
	}

}
