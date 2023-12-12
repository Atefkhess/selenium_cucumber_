package com.e2eTest.automation.page_objects.connexion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

import com.e2eTest.automation.utils.Setup;

public class LoginPage1 {
	
	
	private WebDriver driver = Setup.getDriver();
	/*this variable emailLocator represents a locator 
	 * strategy for locating a web element with an id 
	 * attribute value of "Email".
	 */
	private By emailLocator = By.id("Email");
	private By passwordLocator = By.id("Password");
	private By btnLogin = By.xpath("//button[@type='submit']");

	
/*Getter :this code will locate a web element on the web page
 *  using the emailLocator mechanism and return it
 *   as a WebElement object.
 */
	
	public WebElement getEmailElement() {
		return driver.findElement(emailLocator);
	}
	public WebElement getPassword() {
		return driver.findElement(passwordLocator);
	}
	public WebElement getLoginBtn() {
		return driver.findElement(btnLogin);
	}

/*this code is creating a WrapsElement object that wraps the emailElement 
 * object obtained by calling the getEmailElement() method,
 * and then returning the underlying WebElement object wrapped
 * by this WrapsElement object.
 */
	public WebElement getEmailWrappedElement() {
		WebElement emailElement = getEmailElement();
		WrapsElement wrappedEmail = new WrapsElement() {
			public WebElement getWrappedElement() {
				return emailElement;
			}
		};
		return wrappedEmail.getWrappedElement();
	}
	public WebElement getPasswordWrappedElement() {
		WebElement passwordElement = getPassword();
		WrapsElement wrappedPassword = new WrapsElement() {
			public WebElement getWrappedElement() {
			return passwordElement;
		}
	
	};
	return wrappedPassword.getWrappedElement();
	}
	public WebElement getLoginBtnWrappedElement() {
		WebElement btnLoginElement = getLoginBtn();
		WrapsElement wrappedBtnLogin = new WrapsElement() {
			public WebElement getWrappedElement() {
			return btnLoginElement;
		}
	
	};
	return wrappedBtnLogin.getWrappedElement();
	}
	/* Create method */

	public void goToURL() {
		Setup.getDriver().get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	}

	public void fillEmail(String mail) {
		getEmailElement().clear();
		getEmailElement().sendKeys(mail);
	}

	public void fillPassword(String watchword) {
		getPassword().clear();
		getPassword().sendKeys(watchword);
	}

	public void clickLoginbtn() {
		getLoginBtn().click();
	}

}

