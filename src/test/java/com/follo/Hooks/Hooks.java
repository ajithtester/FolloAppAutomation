package com.follo.Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.follo.baseclass.Baseclass;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks extends Baseclass {



	@AfterStep()
	public void ScreenShot(Scenario scenario) throws Throwable {

		Thread.sleep(2000);
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "Refer the Screenshot"); 

	}

}
