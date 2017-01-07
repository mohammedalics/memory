/*
 * 
 */
package com.practice.interpreter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.practice.constants.MemoryConstants;
import com.practice.domain.Employee;
import com.practice.validation.ValidationUtils;

/**
 * The Class PrintAllInterpreter.
 */
@Component
public class PrintAllInterpreter extends AbstractInterpreter {

	/* (non-Javadoc)
	 * @see com.practice.interpreter.AbstractInterpreter#interpret(java.lang.String)
	 */
	@Override
	public void interpret(String params) throws Exception {
		if (validate(params)) {
			String[] splittedParams = params.split("-");
			String order = splittedParams[0];
			List<Employee> employeeList = new ArrayList<Employee>();
			if (MemoryConstants.PRINTALL_ASC_PARAM.equalsIgnoreCase(order)) {
				employeeList = getEmployeeRepository().findAllByOrderByNameAsc();
			} else if (MemoryConstants.PRINTALL_DESC_PARAM.equalsIgnoreCase(order)) {
				employeeList = getEmployeeRepository().findAllByOrderByNameDesc();
			}

			employeeList.forEach(System.out::println);
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

		// Validate target field to be updated
		ValidationUtils.validatePrintAllField(params[0]);

		return true;
	}

}
