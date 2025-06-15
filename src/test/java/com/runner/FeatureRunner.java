package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "D:/TSLarkspur24/Larkspur24AFramework/src/test/java/com/features",
glue="stepDefinitions", dryRun = true,
plugin = {
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
}
		) //(features = "Feature File Path", glue="step definitions class path") //this is used to execute all our feature files and it is apply on class
public class FeatureRunner extends AbstractTestNGCucumberTests {

}
