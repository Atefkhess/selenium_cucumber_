@nopCommerce
Feature: Je souhaite verifier la page login de l application nopcommerce
  En tant qu utilisateur je souhaite me connecter

  Background: 
    Given Je me connecte sur l application nopcommerce
    When Je saisis le email " admin@yourstore.com"
    And Je saisis le password "admin"
    And Je clique sur le bouton LOGIN

  @login_CasPassant
  Scenario: Authentification sur l application nopcommerce - Cas passant
    Then Je me redirige vers la page home "Dashboard"

  @logout
  Scenario: deconnexion de l application nopcommerce 
    When Je click sur le bouton LOGOUT
    Then Je me redirige vers la page login "Welcome, please sign in!"
