package com.e2eTest.automation.page_objects.vendors;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2eTest.automation.utils.Setup;
public class VendorsInfo {
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[@href='/Admin/Vendor/List']")
	public static WebElement vendorBtn ;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary']")
	public static WebElement addNewBtn ;
	
	@CacheLookup
	@FindBy(how = How.ID, using = "Name")
	public static WebElement name ;
	
	@CacheLookup
	@FindBy(how=How.ID, using = "Description_ifr")
	public static WebElement iframeId ;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='tinymce']/p")
	public static WebElement description  ;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@id='Email']")
	public static WebElement email  ;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@name='save']")
	public static WebElement saveBtn  ;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger alert-dismissable']")
	public static WebElement messageAjout  ;
	
	/*
	 * Initialize the elements(of a given page) with Pagefactory(design
	 * pattern)
	 */  
	public VendorsInfo() {
		PageFactory.initElements(Setup.getDriver(), this);
	}

}
