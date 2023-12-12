@nopCommerce
Feature: Ajouter les informations des vendors
  Je veux ajouter des informations pour les vendors

  Background: 
    Given Je me connecte sur l application nopcommerce
    When Je saisis le email " admin@yourstore.com"
    And Je saisis le password "admin"
    And Je clique sur le bouton LOGIN
    And je clique sur l icone Custmors
    Then la sous liste Custmors s affiche

  @ajout_Info_Vendor
  Scenario: Je remplis les informations des vendors de l application nopommerce
    Given Je clique sur le bouton Vendors
    When Je clique sur le bouton Add new
    Then le formulaire Vendor info s affiche "Add a new vendor"
    When Je remplis le formulaire Vendor info
    And Je clique sur le bouton Save
    Then Un message d ajout s affiche
    When Je click sur le bouton LOGOUT
    Then Je me redirige vers la page login "Welcome, please sign in!"
