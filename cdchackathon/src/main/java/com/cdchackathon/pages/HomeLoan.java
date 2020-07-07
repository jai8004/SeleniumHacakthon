package com.cdchackathon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cdchackathon.base.TestBase;

public class HomeLoan extends TestBase {

	// Initialising the Page Object
	public HomeLoan() {
		PageFactory.initElements(driver, this);
	}

	// Defining the page web elements

	@FindBy(xpath = "//*[@id='car-loan']/a")
	WebElement carLoan;

	// Actions
	public String validatePageTitile() {
		return driver.getTitle();

	}

	public CarLoan clickCarLoan() {
		carLoan.click();

		return new CarLoan();
	}

}
