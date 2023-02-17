@authentification
Feature: Je souhaite verifier la page login de l application nopcommerce
  En tant qu utilisateur je souhaite me connecter

  @login_CasPassant
  Scenario: Authentification sur l application nopcommerce - Cas passant
    Given Je me connecte sur l application nopcommerce
    When Je saisis le email " admin@yourstore.com"
    And Je saisis le password "dmin"
    And Je clique sur le bouton LOGIN
    Then Je me redirige vers la page home "Dashboard"