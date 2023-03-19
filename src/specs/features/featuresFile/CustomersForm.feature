@customers_Form
Feature: Ajouter un formulaire client
  Je veux ajouter un client en remplissant le formulaire client

  Background: 
    Given Je me connecte sur l application nopcommerce
    When Je saisis le email " admin@yourstore.com"
    And Je saisis le password "admin"
    And Je clique sur le bouton LOGIN

  @ajout_Client
  Scenario: Je remplis le formulaire client de l application nopommerce
    And je clique sur l icone Custmors
    Then la sous liste Custmors s affiche
    When Je clique sur le bouton customers
    And je clique sur le boutton Add New
    Then un formulaire pour ajouter un client s affiche
    When je remplis le formulaire
    And je clique sur save
    Then un nouveau client s ajoute "The new customer has been added successfully."
    When Je click sur le bouton LOGOUT
    Then Je me redirige vers la page login "Welcome, please sign in!"
