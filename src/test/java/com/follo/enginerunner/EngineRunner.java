package com.follo.enginerunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, features = { "Features_SP1" }, 
glue = { "com\\folloit\\stepdefinition" }, //tags = "@Register", 
tags = "@Login",
//tags = "@Regression", 
dryRun= false)

public class EngineRunner {



}


