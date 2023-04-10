package com.e2eTest.automation.step_definitions;

import com.e2eTest.automation.page_objects.connexion.LoginPage;
import com.e2eTest.automation.utils.ConfigFileReader;
import com.e2eTest.automation.utils.SeleniumUtils;
import com.e2eTest.automation.utils.Validations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends SeleniumUtils {

	Validations validations = new Validations();

	public LoginPage loginPage;

	private ConfigFileReader configFileReader;

	public LoginStepDefinition() {

		loginPage = new LoginPage();

		this.configFileReader = new ConfigFileReader();
	}

	@Given("Je me connecte sur l application nopcommerce")
	public void jeMeConnecteSurLApplicationNopcommerce() {
		super.get(configFileReader.getProperties("home.url"));

	}

	@When("Je saisis le email {string}")
	public void jeSaisisLeEmail(String mail)  {
		super.writeText(LoginPage.email, mail);
	}

	@And("Je saisis le password {string}")
	public void jeSaisisLePassword(String password) {
		super.writeText(LoginPage.password, password);
	}

	@And("Je clique sur le bouton LOGIN")
	public void jCliqueSurLeBoutonLOGIN() {
		super.click(LoginPage.btnLogin);
	}

	@Then("Je me redirige vers la page home {string}")
	public void jeMeRedirigeVersLaPageHome(String title) {
		validations.assertTrue(LoginPage.titlePage, title);
	}

}
