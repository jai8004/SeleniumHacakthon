package com.cdchackathon.testcase.formfields;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.cdchackathon.base.TestBase;
import com.cdchackathon.pages.CarLoan;
import com.cdchackathon.pages.HomeLoan;
import com.cdchackathon.util.TestUtil;

public class FormFieldTest extends TestBase {
	HomeLoan homeLoanPage;
	CarLoan carLoanPage;
	String sheetname = "FormFields";

	public FormFieldTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		homeLoanPage = new HomeLoan();

	}

	@DataProvider
	public Object[][] getCarLoanTestData() {
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;
	}

	@Test(dataProvider = "getCarLoanTestData")
	public void clickLoanPage(String loanAmount, String interestRate, String loanTenure, String emi) {
		carLoanPage = homeLoanPage.clickCarLoan();
		// carLoanPage.setValues( "1500000","9.5","1");
		carLoanPage.getEmi(loanAmount, interestRate, loanTenure, emi);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}