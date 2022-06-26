package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CalculatorPage {

	AndroidDriver<AndroidElement> driver;

	public CalculatorPage(AndroidDriver<AndroidElement> driver) {
		super();
		this.driver = driver;

		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//android.widget.TextView[@index='0']")
	WebElement result;

	@FindBy(xpath = "//android.widget.Button[@text='2']")
	WebElement Num2;

	@FindBy(xpath = "//android.widget.Button[@text='+']")
	WebElement plus;

	@FindBy(xpath = "//android.widget.Button[@text='=']")
	WebElement equalTo;

	@FindBy(xpath = "//android.widget.Button[@text='AC']")
	WebElement AC;

	@FindBy(xpath = "//android.widget.ImageButton[@index='6']")
	WebElement expandMenu;

	@FindBy(xpath = "//android.widget.Button[@text='sin']")
	WebElement sin;

	@FindBy(xpath = "//android.widget.Button[@text='π']")
	WebElement pi;

	@FindBy(xpath = "//android.widget.Button[@text='÷']")
	WebElement divide;

	@FindBy(xpath = "//android.widget.Button[@text='6']")
	WebElement num6;

	@FindBy(xpath = "//android.widget.Button[@text='( )']")
	WebElement bracket;

	@FindBy(xpath = "//android.widget.Button[@text='log']")
	WebElement log;

	@FindBy(xpath = "//android.widget.Button[@text='√']")
	WebElement sqrt;

	@FindBy(xpath = "//android.widget.Button[@text='e']")
	WebElement element_e;

	public String two_plus_two_test() {

		result.clear();

		AC.click();

		Num2.click();

		plus.click();

		Num2.click();

		equalTo.click();

		return result.getText();

	}

	public String sin_test() {

		result.clear();

		AC.click();
		
		result.sendKeys("sin(pi/6)/log(sqrt(e))");
		
		equalTo.click();
		
		System.out.println("sin(pi/6)/log(sqrt(e)) = " + result.getText()); // not getting the desired calculation
		
		result.clear();

		AC.click();

		expandMenu.click();

		sin.click();

		pi.click();

		divide.click();

		num6.click();

		bracket.click();

		divide.click();

		log.click();

		sqrt.click();

		element_e.click();

		bracket.click();

		equalTo.click();

		return result.getText();

	}

}
