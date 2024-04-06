package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	
	WebDriver driver;
	
	String userName = "demo@codefios.com";
	String password = "abc123";
	String dashboardHearderText = "Dashboard";
	String userNameAlertMsg = "Please enter your user name";
	String passwordAlertMsg = "Please enter your password";
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		
		//object //class name
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardHearderText);
		
		BrowserFactory.tearDown();
		
	}
	
	@Test
	public void validateAlertMessages() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickSigninButton();
		loginPage.validateUserAlertMsg(userNameAlertMsg);
		
		loginPage.insertUserName(userName);
		loginPage.clickSigninButton();
		loginPage.validatePasswordAlertMsg(passwordAlertMsg);
		
		BrowserFactory.tearDown();
		
	}

}
