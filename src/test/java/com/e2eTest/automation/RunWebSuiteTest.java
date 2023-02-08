package com.e2eTest.automation;

import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
* The Test Runner File uses the @RunWith() Annotation from JUnit for executing tests.
*/
@RunWith(Cucumber.class)

/**
* The @CucumberOptions Annotation is used to define the location of feature files, step definitions, reporting
* integration.
*/
@CucumberOptions(
		features = {"src/specs/features"},
		plugin = {"pretty", "html:target/cucumber-report.html"},
		tags = ("@login_CasPassant"),
		monochrome = true , 
		snippets =CAMELCASE
		)

/**
* This class is used to run the test, which is a JUnit Test Runner Class containing the Step Definition location and
* the other primary metadata required to run the test.
*/
public class RunWebSuiteTest {

}
