@authentification
Feature: Je souhaite verifier la page login de l application SwagLabs
  En tant qu utilisateur je souhaite me connecter

  @login_CasPassant
  Scenario: Authentification sur l application SwagLabs - Cas passant
    Given Je me connecte sur l application SwagLabs
    When Je saisis le Username "standard_user"
    And Je saisis le password "secret_sauce"
    And J clique sur le bouton LOGIN
    Then Je me redirige vers la page home "PRODUCTS"