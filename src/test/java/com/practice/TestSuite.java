/*
 * 
 */
package com.practice;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.practice.domain.EmployeeRepositoryTest;
import com.practice.interpreter.AddInterpreterTest;
import com.practice.interpreter.DeleteInterpreterTest;
import com.practice.interpreter.PrintAllInterpreterTest;
import com.practice.interpreter.PrintInterpreterTest;
import com.practice.interpreter.UpdateInterpreterTest;
import com.practice.validation.ValidationUtilsTest;

/**
 * The Class TestSuite.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( {
    
    EmployeeRepositoryTest.class,
    AddInterpreterTest.class,
    DeleteInterpreterTest.class,
    PrintAllInterpreterTest.class,
    PrintInterpreterTest.class,
    UpdateInterpreterTest.class,
    ValidationUtilsTest.class,

})
public class TestSuite {

}
