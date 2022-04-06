package com.follo.enginerunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

//tags = "@Regression", 
//tags = "@dummy",
tags = "@dummy3",

//tags = "@Login",
//tags = "@ForgotPassword",
//tags = "@DFOW" ,


features = {"Features_SP1" , "Features_SP2", "Features_SP3"}, 
glue = {"com\\follo\\stepdefinition\\sp1", "com\\follo\\stepdefinition\\sp2", "com\\follo\\stepdefinition\\sp3", "\\com\\follo\\Hooks"}, 

dryRun= false)
public class EngineRunner extends AbstractTestNGCucumberTests {

}














//JUNIT

//@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, features = { "Features_SP1" }, 
//glue = { "com\\folloit\\stepdefinition", "\\com\\follo\\Hooks"  }, //tags = "@Register", 
//tags = "@Login",
////tags = "@Regression", 
//dryRun= false)

//public class EngineRunner {
//
//
//
//}











