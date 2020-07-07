package com.cdchackathon.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.cdchackathon.base.TestBase;

public class CarLoan extends TestBase {

	public CarLoan() {
		PageFactory.initElements(driver, this);

	}

	// defining xpaths
	@FindBy(xpath = "//*[@id=\'loanamount\']")
	WebElement loanAmount;

	@FindBy(xpath = "//*[@id=\'loaninterest\']")
	WebElement interestRate;

	@FindBy(xpath = "//*[@id=\'loanterm\']")
	WebElement loanTenure;

	@FindBy(xpath = "//*[@id='emiamount']/p/span")
	WebElement emi;

	public void getEmi(String lAmount, String intRate, String ltenure, String loanemi) {

	
		loanAmount.clear();
		loanAmount.sendKeys(Keys.BACK_SPACE);
		loanAmount.sendKeys(lAmount);

	

		interestRate.clear();
	
		interestRate.sendKeys(Keys.BACK_SPACE);
		interestRate.sendKeys(intRate);
	

		loanTenure.clear();
	
		loanTenure.sendKeys(Keys.BACK_SPACE);
		loanTenure.sendKeys(ltenure);

	
		String testemi = emi.getText();
		testemi = testemi.replaceAll(",", "");
		Assert.assertEquals(testemi, loanemi);

	}

}
