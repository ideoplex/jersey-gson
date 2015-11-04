package com.ideoplex.tutorial;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = {"json:target/cucumber-report.json",
                           "html:target/cucumber-report"})
public class CucumberTest extends AbstractTestNGCucumberTests
{
}
