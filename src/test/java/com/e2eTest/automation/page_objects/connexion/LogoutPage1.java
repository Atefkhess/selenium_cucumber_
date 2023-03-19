package com.e2eTest.automation.page_objects.connexion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

import com.e2eTest.automation.utils.Setup;

public class LogoutPage1 {
	
	private WebDriver driver = Setup.getDriver();

	private By logoutBtn = By.xpath("//a[contains(text(),'Logout')]");
	private By titlePage1 = By.xpath("//strong[contains(text(),'Welcome, please sign in!')]");
	/*this code will locate a web element on the web page
	 *  using thelogoutBtnLocator mechanism and return it
	 *   as a WebElement object.
	 */
	
	public WebElement getLogoutBtn() {
		return driver.findElement(logoutBtn);
	}
	public WebElement getTitlePage1() {
		return driver.findElement(titlePage1);
	}
	/*this code is creating a WrapsElement object that wraps the logoutBtn 
	 * object obtained by calling the getLogoutBtn() method,
	 * and then returning the underlying WebElement object wrapped
	 * by this WrapsElement object.
	 */
	
	public WebElement getLoginBtnWrappedElement() {
		WebElement btnLogoutElement = getLogoutBtn();
		WrapsElement wrappedBtnLogout = new WrapsElement() {
			public WebElement getWrappedElement() {
			return btnLogoutElement;
		}
	
	};
	return wrappedBtnLogout.getWrappedElement();
	}
	public WebElement getTitlePage1WrappedElement() {
		WebElement titlePage1Element = getTitlePage1();
		WrapsElement wrappedTitlePage1 = new WrapsElement() {
			public WebElement getWrappedElement() {
			return titlePage1Element;
		}
	
	};
	return wrappedTitlePage1.getWrappedElement();
	}
	/* Create method */
	
	public void clickLogoutbtn() {
		getLogoutBtn().click();
	}
}
