package com.e2eTest.automation.step_definitions;




import com.e2eTest.automation.page_objects.customers.CustomerFormPage;
import com.e2eTest.automation.utils.ConfigFileReader;
import com.e2eTest.automation.utils.DateUtil;
import com.e2eTest.automation.utils.RandomValue;
import com.e2eTest.automation.utils.SelectFromListUtils;
import com.e2eTest.automation.utils.SeleniumUtils;
import com.e2eTest.automation.utils.Validations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomersFormStepDefinition {
	public SeleniumUtils utils;
	public CustomerFormPage customersFormPage ;	
	public Validations validations;
	public SelectFromListUtils selectFromListUtils;
	public DateUtil dateUtil;
	private ConfigFileReader configFileReader;
	public CustomersFormStepDefinition() {
		customersFormPage = new CustomerFormPage();
		validations = new Validations();
		utils = new SeleniumUtils();
		dateUtil = new DateUtil();
		selectFromListUtils = new SelectFromListUtils();
		this.configFileReader = new ConfigFileReader();
		}
	
	
	@When("je clique sur l icone Custmors")
	public void jeCliqueSurLIconeCustmors() {
		utils.click(customersFormPage.getCustomerWrappedElement(customersFormPage.getCustomerIcon()));

	}
	
	@Then("la sous liste Custmors s affiche")
	public void laSousListeCustmorsSAffiche() {
		validations.isElementDisplayed(customersFormPage.getCustomerWrappedElement(customersFormPage.getCustomerBtn()));
	}
	@When("Je clique sur le bouton customers")
	public void jeCliqueSurLeBoutonCustomers() {
		utils.click(customersFormPage.getCustomerWrappedElement(customersFormPage.getCustomerBtn()));
	}
	
	
	@And("je clique sur le boutton Add New")
	public void jeCliqueSurLeBouttonAddNew() {
		utils.click(customersFormPage.getCustomerWrappedElement(customersFormPage.getAddNewBtn()));
	}
	@Then("un formulaire pour ajouter un client s affiche")
	public void unFormulairePourAjouterUnClientSAffiche() {
		validations.isElementDisplayed(customersFormPage.getCustomerWrappedElement(customersFormPage.getEmail()));
	}
	@When("je remplis le formulaire")
	public void jeRemplisLeFormulaire() throws InterruptedException {
		utils.writeText(customersFormPage.getCustomerWrappedElement(customersFormPage.getEmail()),RandomValue.getSaltString()+"@gmail.com" );
		utils.writeText(customersFormPage.getCustomerWrappedElement(customersFormPage.getPassword()),configFileReader.getProperties("password.customer") );
		utils.writeText(customersFormPage.getCustomerWrappedElement(customersFormPage.getFirstName()),configFileReader.getProperties("firstName.cutomer") );
		utils.writeText(customersFormPage.getCustomerWrappedElement(customersFormPage.getLastName()),configFileReader.getProperties("lastName.cutomer") );
		utils.click(customersFormPage.getCustomerWrappedElement(customersFormPage.getGenderMale()));
		utils.writeText(customersFormPage.getCustomerWrappedElement(customersFormPage.getDateOfBirth()),configFileReader.getProperties("dateOfBirth.customer"));
		utils.writeText(customersFormPage.getCustomerWrappedElement(customersFormPage.getCompany()),configFileReader.getProperties("companyName.customer") );
//	    utils.writeText(customersFormPage.getCustomerWrappedElement(customersFormPage.getAge()),configFileReader.getProperties("age.customer") );
		utils.click(customersFormPage.getCustomerWrappedElement(customersFormPage.getIsTaxExempt()));
		utils.autoSuggest(customersFormPage.getCustomerWrappedElement(customersFormPage.getNewsLetter()), configFileReader.getProperties("newsletterSuggest.customer"), configFileReader.getProperties("newsletter.customer"));
		utils.autoSuggest(customersFormPage.getCustomerWrappedElement(customersFormPage.getCustomerRoles()), configFileReader.getProperties("cutomerRoles.customer"), configFileReader.getProperties("cutomerRoles.customer"));
	    selectFromListUtils.selectDropDownListByVisibleText(customersFormPage.getCustomerWrappedElement(customersFormPage.getManagerOfVender()), configFileReader.getProperties("manageOfVendor.customer"));

	    utils.writeText(customersFormPage.getCustomerWrappedElement(customersFormPage.getAdminComment()),configFileReader.getProperties("adminComment.customer"));	
	}
	@When("je clique sur save")
	public void jeCliqueSurSave() {
		utils.click(customersFormPage.getCustomerWrappedElement(customersFormPage.getSaveBtn()));
	}
	@Then("un nouveau client s ajoute {string}")
	public void unNouveauClientSAjoute(String title) {
		validations.assertTrue(customersFormPage.getCustomerWrappedElement(customersFormPage.getnewCustomer()),title);
	  
	}


}
