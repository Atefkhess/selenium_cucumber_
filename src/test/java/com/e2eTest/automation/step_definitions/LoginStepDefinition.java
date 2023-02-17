package com.e2eTest.automation.step_definitions;

import com.e2eTest.automation.page_objects.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	
	public LoginPage loginPage ;
	public LoginStepDefinition() {
		
		loginPage = new LoginPage();
	}
	
	@Given("Je me connecte sur l application nopcommerce")
	public void jeMeConnecteSurLApplicationNopcommerce() {
		loginPage.goToURL();
		
	}

	@When("Je saisis le email {string}")
	public void jeSaisisLeEmail(String email) {
		loginPage.fillEmail(email);
	}

	@And("Je saisis le password {string}")
	public void jeSaisisLePassword(String password) {
		loginPage.fillPassword(password);
	}

	@And("Je clique sur le bouton LOGIN")
	public void jCliqueSurLeBoutonLOGIN() {
		loginPage.clickLoginbtn();
	}

	@Then("Je me redirige vers la page home {string}")
	public void jeMeRedirigeVersLaPageHome(String string) {
		
	}

}
