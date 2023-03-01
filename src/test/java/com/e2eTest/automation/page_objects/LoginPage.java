package com.e2eTest.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2eTest.automation.utils.Setup;

/* Retrieve Element */
/* Cachelookup will ask to Selenium to save the cache of this Webelement
 *  instead of looking for it in the webpage */
//@CacheLookup 

//public static WebElement email;

public class LoginPage {
	
	@CacheLookup
	@FindBy(how = How.ID, using = "Email")
	public static WebElement email;
	

	@CacheLookup
	@FindBy(how = How.ID, using = "Password")
	public static WebElement password;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public static WebElement btnLogin;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Dashboard')]")
	public static WebElement titlePage;
	/*
	 * Initialize the elements(of a given page) with Pagefactory(design
	 * pattern)
	 */  
	public LoginPage() {
	        PageFactory.initElements(Setup.getDriver(),this);	
	}
	/* Create method */

	public void goToURL() {
		Setup.getDriver().get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	}

	public void fillEmail(String mail) {
		email.clear();
		email.sendKeys(mail);
	}

	public void fillPassword(String watchword) {
		password.clear();
		password.sendKeys(watchword);
	}

	public void clickLoginbtn() {
		btnLogin.click();
	}

}
