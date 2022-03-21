

package com.follo.enginerunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

tags = "@Regression", 
//tags = "@Register",
//tags = "@Login",
//tags = "@ForgotPassword",
features = "Features_SP1", 
glue = {"com\\folloit\\stepdefinition", "\\com\\follo\\Hooks"  }, 
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









