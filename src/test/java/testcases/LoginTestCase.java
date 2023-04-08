package testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginTestCase extends BaseClass  {
	
	public LoginPage loginPage;

	public LoginTestCase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeTest
	public void launchChrome() throws IOException {
		initialiazation();
		loginPage = new LoginPage();
	}
	
	@Test
	public void validateLoginFunctionality() {
		loginPage.enterCredentials();
	}
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}
