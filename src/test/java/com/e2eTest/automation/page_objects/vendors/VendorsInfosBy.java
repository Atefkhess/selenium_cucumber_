package com.e2eTest.automation.page_objects.vendors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

import com.e2eTest.automation.utils.Setup;

public class VendorsInfosBy {

	
	
	private WebDriver driver = Setup.getDriver();
	private By vendorBtn = By.xpath("//a[@href='/Admin/Vendor/List']");
	private By addNewBtn = By.xpath("//a[@class='btn btn-primary']");
	private By name = By.id("Name");
	private By iframeId = By.id("Description_ifr");
	private By description = By.xpath("//*[@id=\"tinymce\"]/p");
	private By email = By.xpath("//input[@id='Email']");
	private By saveBtn = By.xpath("//button[@name='save']");
	private By messageAjout = By.xpath("//div[@class='alert alert-danger alert-dismissable']");
	
	public WebElement getVendorBtn() {
		return driver.findElement(vendorBtn);
	}

	public WebElement getAddNewBtn() {
		return driver.findElement(addNewBtn);
	}
	public WebElement getName() {
		return driver.findElement(name);
	}

	public WebElement getIframeId() {
		return driver.findElement(iframeId);
	}

	public WebElement getDescription() {
		return driver.findElement(description);
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getSaveBtn() {
		return driver.findElement(saveBtn);
	}
	public WebElement getMessageAjout() {
		return driver.findElement(messageAjout);
	}
	
	public WebElement getVendorsWrappedElement(WebElement webelement ) {
		//WebElement customerIconElement = getCustomerIcon();
		WrapsElement wrappedVendorwebelement = new WrapsElement() {
			public WebElement getWrappedElement() {
				return webelement;
			}
		};
		return wrappedVendorwebelement.getWrappedElement();

}
}
