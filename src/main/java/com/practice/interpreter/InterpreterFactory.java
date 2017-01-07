/*
 * 
 */
package com.practice.interpreter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A factory for creating Interpreter objects.
 */
@Component
public class InterpreterFactory {

	/** The Constant ADD_COMMAND. */
	public static final String ADD_COMMAND = "add";
	
	/** The Constant DELETE_COMMAND. */
	public static final String DELETE_COMMAND = "del";
	
	/** The Constant UPDATE_COMMAND. */
	public static final String UPDATE_COMMAND = "update";
	
	/** The Constant PRINTALL_COMMAND. */
	public static final String PRINTALL_COMMAND = "printall";
	
	/** The Constant PRINT_COMMAND. */
	public static final String PRINT_COMMAND = "print";
	
	/** The Constant QUIT_COMMAND. */
	public static final String QUIT_COMMAND = "quit";

	/** The add interpreter. */
	@Autowired
	private AddInterpreter addInterpreter;

	/** The delete interpreter. */
	@Autowired
	private DeleteInterpreter deleteInterpreter;

	/** The update interpreter. */
	@Autowired
	private UpdateInterpreter updateInterpreter;

	/** The print interpreter. */
	@Autowired
	private PrintInterpreter printInterpreter;

	/** The print all interpreter. */
	@Autowired
	private PrintAllInterpreter printAllInterpreter;

	/** The quit interpreter. */
	@Autowired
	private QuitInterpreter quitInterpreter;

	/**
	 * Gets the interpreter.
	 *
	 * @param command the command
	 * @return the interpreter
	 */
	public Interpreter getInterpreter(String command) {
		if ("".equalsIgnoreCase(command)) {
			return null;
		}

		String[] splittedCommand = command.split(" ");
		if (ADD_COMMAND.equalsIgnoreCase(splittedCommand[0])) {
			return addInterpreter;

		} else if (DELETE_COMMAND.equalsIgnoreCase(splittedCommand[0])) {
			return deleteInterpreter;

		} else if (UPDATE_COMMAND.equalsIgnoreCase(splittedCommand[0])) {
			return updateInterpreter;

		} else if (PRINT_COMMAND.equalsIgnoreCase(splittedCommand[0])) {
			return printInterpreter;

		} else if (PRINTALL_COMMAND.equalsIgnoreCase(splittedCommand[0])) {
			return printAllInterpreter;

		} else if (QUIT_COMMAND.equalsIgnoreCase(splittedCommand[0])) {
			return quitInterpreter;

		}

		return null;
	}
}