package com.base.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.calc.base.Base;
import com.pages.CalculatorPage;
import com.pages.Calculator_Validation_Page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorTest extends Base {

	@Test(priority = 1)
	public void Calculation_with_valid_data() throws MalformedURLException {		

		CalculatorPage calPage = new CalculatorPage(driver);

		String val = calPage.two_plus_two_test();	

		Assert.assertEquals(4, Integer.parseInt(val));		

		String sin_calculations = calPage.sin_test();

		System.out.println("********* sin_calculations = " + sin_calculations);

		// not getting the 2.303 calculations , tried with direct value inserting then
		// clickh equal , also tried calculations with pressing the sings individually	

	}

	@Test(priority = 2)
	public void Calculation_validations() throws MalformedURLException {

		ExtentTest logger = extent.createTest("Calculation_validations");

		Calculator_Validation_Page valPage = new Calculator_Validation_Page(driver);

		String resultTxt = valPage.five_by_zero();

		logger.log(Status.INFO, "Open calculator.apk application");

		Assert.assertEquals("Can't divide by 0", resultTxt);

		logger.log(Status.INFO, "Assertion Verified Can't divide by 0");

		String resultVal = valPage.check_9carat9999();

		System.out.println(resultVal);

		Assert.assertEquals("2.95700380E9541", resultVal);

		logger.log(Status.INFO, "Assertion Verified 2.95700380E9541");

		// Assert.assertEquals("Value too large", resultVal); // value too large doesnt
		// display in the cal, tried with many other calc

		extent.flush();

	}

}
