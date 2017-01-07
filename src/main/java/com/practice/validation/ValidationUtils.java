/*
 * 
 */
package com.practice.validation;

import com.practice.constants.MemoryConstants;

/**
 * The Class ValidationUtils.
 */
public class ValidationUtils {

	/**
	 * Validate id.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public static boolean validateId(String id) throws Exception {
		if ("".equalsIgnoreCase(id)) {
			throw new Exception("ID is empty");
		}

		try {
			Long.parseLong(id);
		} catch (Exception ex) {
			throw new Exception("ID must be number");
		}

		return true;
	}

	/**
	 * Validate name.
	 *
	 * @param name the name
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public static boolean validateName(String name) throws Exception {

		if ("".equalsIgnoreCase(name)) {
			throw new Exception("name is empty");
		}
		return true;

	}

	/**
	 * Validate designation.
	 *
	 * @param designation the designation
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public static boolean validateDesignation(String designation) throws Exception {

		if ("".equalsIgnoreCase(designation)) {
			throw new Exception("designation is empty");
		}
		return true;

	}

	/**
	 * Validate salary.
	 *
	 * @param salary the salary
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public static boolean validateSalary(String salary) throws Exception {
		if ("".equalsIgnoreCase(salary)) {
			throw new Exception("Salary is empty");
		}

		try {
			Long.parseLong(salary);
		} catch (Exception ex) {
			throw new Exception("Salary must be number");
		}
		return true;
	}

	/**
	 * Validate update field.
	 *
	 * @param field the field
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public static boolean validateUpdateField(String field) throws Exception {

		if ("".equalsIgnoreCase(field)) {
			throw new Exception("field can't be empty");
		}

		if (MemoryConstants.UPDATE_NAME_PARAM.equalsIgnoreCase(field)
				|| MemoryConstants.UPDATE_DESIG_PARAM.equalsIgnoreCase(field)
				|| MemoryConstants.UPDATE_SALARY_PARAM.equalsIgnoreCase(field))
			return true;
		else
			throw new Exception(
					"Wrong statment. update statment schema: update <employee id>‐<NAME/DESIG/SALARY>-<New Value>");
	}

	/**
	 * Validate print all field.
	 *
	 * @param field the field
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public static boolean validatePrintAllField(String field) throws Exception {

		if ("".equalsIgnoreCase(field)) {
			throw new Exception("field can't be empty");
		}

		if (MemoryConstants.PRINTALL_ASC_PARAM.equalsIgnoreCase(field)
				|| MemoryConstants.PRINTALL_DESC_PARAM.equalsIgnoreCase(field))
			return true;
		else
			throw new Exception("Wrong statment. printall statment schema: printall <ASC/DESC>");
	}

}
