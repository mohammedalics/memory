/*
 * 
 */
package com.practice.interpreter;

import org.springframework.stereotype.Component;

/**
 * The Class QuitInterpreter.
 */
@Component
public class QuitInterpreter extends AbstractInterpreter {

	/* (non-Javadoc)
	 * @see com.practice.interpreter.AbstractInterpreter#interpret(java.lang.String)
	 */
	@Override
	public void interpret(String params) throws Exception {
		if (validate(params)) {
			System.out.println("The application will exit.");
			System.exit(0);
		}
	}

	/* (non-Javadoc)
	 * @see com.practice.interpreter.AbstractInterpreter#validate(java.lang.String)
	 */
	@Override
	boolean validate(String args) throws Exception {
		return true;
	}

}
