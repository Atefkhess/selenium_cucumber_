package com.e2eTest.automation.step_definitions;




import java.time.Duration;

import com.e2eTest.automation.page_objects.vendors.VendorsInfo;
import com.e2eTest.automation.utils.ConfigFileReader;
import com.e2eTest.automation.utils.SeleniumUtils;
import com.e2eTest.automation.utils.Setup;
import com.e2eTest.automation.utils.Validations;
import com.e2eTest.automation.utils.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VendorInfoStepDefinition extends SeleniumUtils {

	public VendorsInfo vendorsInfo ;
	public Wait wait ;
	private ConfigFileReader configFileReader;
	public Validations validations ;
	
	public VendorInfoStepDefinition() {
		
		this.configFileReader = new ConfigFileReader();
		vendorsInfo = new VendorsInfo();
		wait = new Wait(Setup.getDriver());
		validations = new Validations();
		
	}
	
	
	@Given("Je clique sur le bouton Vendors")
	public void jeCliqueSurLeBoutonVendors() {
	    super.waitForElementToBeClickable(VendorsInfo.vendorBtn);
	    super.click(VendorsInfo.vendorBtn);
	    
	}

	@When("Je clique sur le bouton Add new")
	public void jeCliqueSurLeBoutonAddNew() {
		super.click(VendorsInfo.addNewBtn);
	}

	@Then("le formulaire Vendor info s affiche")
	public void leFormulaireVendorInfoSAffiche() {
	  
	}

	@When("Je remplis le formulaire Vendor info")
	public void jeRemplisLeFormulaireVendorInfo() throws InterruptedException {
	    super.writeText(VendorsInfo.name, configFileReader.getProperties("name.vendor") );
	    wait.forElementToBeDisplayed(Duration.ofSeconds(6), VendorsInfo.iframeId,configFileReader.getProperties("iframeId"));
	    super.switchToNewWindow(Setup.getDriver(),configFileReader.getProperties("iframeId") );
	    super.writeText(VendorsInfo.description, configFileReader.getProperties("description.vendor"));
	    super.SwitchToDefault();
	    super.writeText(VendorsInfo.email, configFileReader.getProperties("email.vendor") );
	}

	@When("Je clique sur le bouton Save")
	public void jeCliqueSurLeBoutonSave() {
	   super.click(VendorsInfo.saveBtn);
	}

	@Then("Un message d ajout s affiche")
	public void unMessageDAjoutSAffiche() {
	    validations.assertTrue(VendorsInfo.messageAjout, configFileReader.getProperties("messageAjout.vendor"));
	}

}
