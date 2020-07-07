package com.cdchackathon.testcase.casestudy;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.cdchackathon.base.TestBase;
import com.cdchackathon.pages.CarLoan;
import com.cdchackathon.pages.HomeLoan;
import com.cdchackathon.util.TestUtil;

public class CaseStudy extends TestBase {
	HomeLoan homeLoanPage;
	CarLoan carLoanPage;
	String sheetname = "CaseStudy";

	public CaseStudy() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homeLoanPage = new HomeLoan();

	}

	@Test(priority = 1)
	public void getTitle() {
		String title = homeLoanPage.validatePageTitile();
		Assert.assertEquals(title, "");

	}

	@DataProvider
	public Object[][] getCarLoanTestData() {
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;
	}

	@Test(priority = 2, dataProvider = "getCarLoanTestData")
	public void clickLoanPage(String loanAmount, String interestRate, String loanTenure, String emi) {
		carLoanPage = homeLoanPage.clickCarLoan();
		carLoanPage.getEmi(loanAmount, interestRate, loanTenure, emi);

	}

	@AfterMethod
	public void tearDown() {

		driver.close();
		driver.quit();
	}

}