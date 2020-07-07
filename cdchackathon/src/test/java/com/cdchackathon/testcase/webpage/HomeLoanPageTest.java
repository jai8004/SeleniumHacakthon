package com.cdchackathon.testcase.webpage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import com.cdchackathon.base.TestBase;
import com.cdchackathon.pages.CarLoan;
import com.cdchackathon.pages.HomeLoan;


public class HomeLoanPageTest extends TestBase {
	HomeLoan homeLoanPage;
	CarLoan carLoanPage;

	public HomeLoanPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homeLoanPage = new HomeLoan();

	}

	@Test
	public void getTitle() {
		String title = homeLoanPage.validatePageTitile();
		Assert.assertEquals(title, "EMI Calculator for Home Loan, Car Loan & Personal Loan in India");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}