package com.e2eTest.automation.page_objects.connexion;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.e2eTest.automation.utils.BasePage;
import com.e2eTest.automation.utils.Setup;

public class LogoutPage extends BasePage {

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]")
	public static WebElement logoutBtn;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Welcome, please sign in!')]")
	public static WebElement titlePage1;
	
	public LogoutPage() {
		super(Setup.getDriver());
		/*We don't use Pagefactory directly  here anymore 
		 * instead we call it from base page whenever U need it */
		//PageFactory.initElements(Setup.getDriver(), this);
		;
	}
	
	/* Create method */
	
	public void clickLogoutbtn() {
		logoutBtn.click();
	}
}
