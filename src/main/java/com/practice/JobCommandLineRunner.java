/*
 * 
 */
package com.practice;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.practice.interpreter.Interpreter;
import com.practice.interpreter.InterpreterFactory;

/**
 * The Class JobCommandLineRunner.
 */
@Component
@Profile("production")
public class JobCommandLineRunner implements CommandLineRunner {

	/** The ctx. */
	@Autowired
	ApplicationContext ctx;

	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... arg0) throws Exception {
		Scanner scanIn = null;
		try {
			InterpreterFactory interperterFactory = (InterpreterFactory) ctx.getBean("interpreterFactory");
			scanIn = new Scanner(System.in);
			String command = "";
			System.out.println("Welcome to employee DB");
			System.out.println("======================");
			while (true) {
				command = scanIn.nextLine();
				Interpreter interpreter = interperterFactory.getInterpreter(command);
				if (interpreter == null) {
					System.out.println("Unknown command!");
					continue;
				}
				try {
					String[] splittedCommand = command.split(" ");
					interpreter.interpret(splittedCommand.length > 1 ? splittedCommand[1] : null);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (scanIn != null) {
				scanIn.close();
			}
		}
	};
}
