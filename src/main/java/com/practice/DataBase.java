
package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class DataBase.
 */
@SpringBootApplication
public class DataBase {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DataBase.class);
		app.setAdditionalProfiles("production");
		app.run(args);
	}

}
