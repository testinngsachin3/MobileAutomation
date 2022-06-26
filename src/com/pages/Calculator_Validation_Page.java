package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Calculator_Validation_Page {

	AndroidDriver<AndroidElement> driver;

	public Calculator_Validation_Page(AndroidDriver<AndroidElement> driver) {
		super();
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//android.widget.TextView[@index='0']")
	WebElement result;

	@FindBy(xpath = "//android.widget.Button[@text='5']")
	WebElement Num5;

	@FindBy(xpath = "//android.widget.Button[@text='0']")
	WebElement Num0;

	@FindBy(xpath = "//android.widget.Button[@text='9']")
	WebElement Num9;

	@FindBy(xpath = "//android.widget.Button[@text='=']")
	WebElement equalTo;

	@FindBy(xpath = "//android.widget.Button[@text='AC']")
	WebElement AC;

	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.calculator:id/result_preview']")
	WebElement result_preview;

	@FindBy(xpath = "//android.widget.ImageButton[@index='6']")
	WebElement expandMenu;

	@FindBy(xpath = "//android.widget.Button[@text='÷']")
	WebElement divide;

	@FindBy(xpath = "//android.widget.Button[@text='^']")
	WebElement carat;

	public String five_by_zero() {

		result.clear();

		AC.click();

		Num5.click();

		divide.click();

		Num0.click();

		equalTo.click();

		return result_preview.getText();

	}

	public String check_9carat9999() {

		result.clear();

		AC.click();

		Num9.click();

		carat.click();

		Num9.click();
		Num9.click();
		Num9.click();
		Num9.click();

		equalTo.click();

		return result.getText();

	}

}
