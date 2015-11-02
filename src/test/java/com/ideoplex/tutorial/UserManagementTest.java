package com.ideoplex.tutorial;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/",
                 plugin   = "json:target/cucumber-report.json")
public class UserManagementTest extends AbstractTestNGCucumberTests
{
}
