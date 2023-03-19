package com.e2eTest.automation.step_definitions;





import com.e2eTest.automation.page_objects.connexion.LogoutPage;
import com.e2eTest.automation.utils.SeleniumUtils;
import com.e2eTest.automation.utils.Validations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStepDefinition extends SeleniumUtils {
	Validations validations = new Validations();
	public LogoutPage logoutPage ;
	public LogoutStepDefinition() {
		
		logoutPage = new LogoutPage();
	}
	
	@When("Je click sur le bouton LOGOUT")
	public void jeClickSurLeBoutonLOGOUT() {
		super.click(LogoutPage.logoutBtn);
	    
	}
	@Then("Je me redirige vers la page login {string}")
	public void jeMeRedirigeVersLaPageLogin(String title1) {
		validations.assertEquals(LogoutPage.titlePage1, title1);
	}

}
