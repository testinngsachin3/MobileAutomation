package com.calc.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	public AndroidDriver<AndroidElement> driver = null;

	private Properties properties;

	private final String propertyFilePath = "src\\resources\\application.properties";

	public ExtentHtmlReporter reporter;

	public ExtentReports extent;

	@BeforeMethod
	public void capabilities() throws MalformedURLException {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("application.properties not found at " + propertyFilePath);
		}

		File appDir = new File(properties.getProperty("fileDir"));

		File apkFile = new File(appDir, properties.getProperty("applicationName"));

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("emulatorName"));

		cap.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		driver = new AndroidDriver<AndroidElement>(new URL(properties.getProperty("url")), cap);

		reporter = new ExtentHtmlReporter("target/AutomationExecution.html");

		extent = new ExtentReports();

		extent.attachReporter(reporter);		

	}

	@AfterMethod
	public void tearDown() {

		driver.closeApp();
	}

}
