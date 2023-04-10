package com.e2eTest.automation.page_objects.customers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

import com.e2eTest.automation.utils.Setup;

public class CustomerFormPage {

	private WebDriver driver = Setup.getDriver();
	private By customersIcon = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	private By customersBtn = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	private By addNewBtn = By.xpath("//a[normalize-space()='Add new']");
	private By email = By.id("Email");
	private By password = By.id("Password");
	private By firstName = By.id("FirstName");
	private By lastName = By.id("LastName");
	private By genderMale = By.id("Gender_Male");
	private By genderFemale = By.id("Gender_Female");
	private By dateOfBirth = By.id("DateOfBirth");
	private By companyName = By.id("Company");
	private By age = By.id("customer_attribute_1");
	private By isTaxExempt = By.id("IsTaxExempt");
	private By newsLetter = By.xpath("//div[@class='input-group-append']//input[@role='listbox']");
	private By customerRoles = By.xpath("//div[@class='input-group-append input-group-required']//input[@role='listbox']");
	//private By deleteBtnRole = By.xpath("//span[@class='k-icon k-i-close']");
	private By managerOfVender = By.id("VendorId");
	private By adminComment = By.id("AdminComment");
	private By saveBtn = By.xpath("//button[@name='save']");
    private By newCustomer = By.xpath("//div[@class='alert alert-success alert-dismissable']");
	/*
	 * this code will locate a web element on the web page using the emailLocator
	 * mechanism and return it as a WebElement object.
	 */
	public WebElement getCustomerIcon() {
		return driver.findElement(customersIcon);
	}

	public WebElement getCustomerBtn() {
		return driver.findElement(customersBtn);
	}

	public WebElement getAddNewBtn() {
		return driver.findElement(addNewBtn);
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}

	public WebElement getLastName() {
		return driver.findElement(lastName);
	}

	public WebElement getGenderMale() {
		return driver.findElement(genderMale);
	}

    public WebElement getGenderFemale() {
	return driver.findElement(genderFemale);
    }
	
	public WebElement getDateOfBirth() {
		return driver.findElement(dateOfBirth);
	}
	public WebElement getCompany() {
		return driver.findElement(companyName);
	}
	public WebElement getAge() {
		return driver.findElement(age);
	}
	
	public WebElement getIsTaxExempt() {
		return driver.findElement(isTaxExempt);
	}
	public WebElement getNewsLetter() {
		return driver.findElement(newsLetter);
	}
	
	public WebElement getCustomerRoles() {
		return driver.findElement(customerRoles);
	}
//
//	public WebElement getDeleteBtnRole() {
//		return driver.findElement(deleteBtnRole);
//	}

	public WebElement getManagerOfVender() {
		return driver.findElement(managerOfVender);
	}
	public WebElement getAdminComment() {
		return driver.findElement(adminComment);
	}
	public WebElement getSaveBtn() {
		return driver.findElement(saveBtn);
	}
	public WebElement getnewCustomer() {
		return driver.findElement(newCustomer);
	}

	public WebElement getCustomerWrappedElement(WebElement webelement ) {
		//WebElement customerIconElement = getCustomerIcon();
		WrapsElement wrappedCustomerwebelement = new WrapsElement() {
			public WebElement getWrappedElement() {
				return webelement;
			}
		};
		return wrappedCustomerwebelement.getWrappedElement();

}
}
