package com.e2eTest.automation.step_definitions;

import java.time.Duration;

import org.json.simple.JSONObject;


import com.e2eTest.automation.page_objects.vendors.VendorsInfosBy;
import com.e2eTest.automation.utils.ConfigFileReader;
import com.e2eTest.automation.utils.SeleniumUtils;
import com.e2eTest.automation.utils.Setup;
import com.e2eTest.automation.utils.Validations;
import com.e2eTest.automation.utils.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VendorInfoStepDefinition  {

	public VendorsInfosBy vendorsInfoBy;
	public Wait wait;
	private ConfigFileReader configFileReader;
	public Validations validations;
	private static SeleniumUtils seleniumUtils = new SeleniumUtils();
	static JSONObject object = seleniumUtils.JsonData(0);
	private static long mediumWait = Long.valueOf((String) object.get("MediumWait"));

	public VendorInfoStepDefinition() {

		this.configFileReader = new ConfigFileReader();
		vendorsInfoBy = new VendorsInfosBy();
		wait = new Wait(Setup.getDriver());
		validations = new Validations();
		

	}

	@Given("Je clique sur le bouton Vendors")
	public void jeCliqueSurLeBoutonVendors() {
		seleniumUtils.waitForElementToBeClickable(vendorsInfoBy.getVendorsWrappedElement(vendorsInfoBy.getVendorBtn()));
		seleniumUtils.click(vendorsInfoBy.getVendorsWrappedElement(vendorsInfoBy.getVendorBtn()));

	}

	@When("Je clique sur le bouton Add new")
	public void jeCliqueSurLeBoutonAddNew() {
		seleniumUtils.click(vendorsInfoBy.getVendorsWrappedElement(vendorsInfoBy.getAddNewBtn()));
	}

	@Then("le formulaire Vendor info s affiche")
	public void leFormulaireVendorInfoSAffiche() {

	}

	@When("Je remplis le formulaire Vendor info")
	public void jeRemplisLeFormulaireVendorInfo() throws InterruptedException {
		seleniumUtils.writeText(vendorsInfoBy.getName(), configFileReader.getProperties("name.vendor"));
		Thread.sleep(mediumWait);
		wait.forElementToBeDisplayed(Duration.ofSeconds(10),vendorsInfoBy.getVendorsWrappedElement(vendorsInfoBy.getIframeId()),configFileReader.getProperties("iframeId"));

		seleniumUtils.switchToNewWindow(Setup.getDriver(), configFileReader.getProperties("iframeId"));

		seleniumUtils.writeText(vendorsInfoBy.getVendorsWrappedElement(vendorsInfoBy.getDescription()),configFileReader.getProperties("description.vendor"));
		seleniumUtils.SwitchToDefault();
		seleniumUtils.writeText(vendorsInfoBy.getEmail(), configFileReader.getProperties("email.vendor"));
	}

	@When("Je clique sur le bouton Save")
	public void jeCliqueSurLeBoutonSave() {
		seleniumUtils.click(vendorsInfoBy.getSaveBtn());
	}

	@Then("Un message d ajout s affiche")
	public void unMessageDAjoutSAffiche() {
		validations.assertTrue(vendorsInfoBy.getVendorsWrappedElement(vendorsInfoBy.getMessageAjout()), configFileReader.getProperties("messageAjout.vendor"));
	}

}
