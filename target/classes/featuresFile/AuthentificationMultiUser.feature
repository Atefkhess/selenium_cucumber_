@connexion_multi_utilisateur
Feature: Authentification avec multi utilisateur
  Je souhaite me connecter sur l application avec plusieurs utilisateurs

  @multi_utilisateurs
  Scenario Outline: Title of your scenario outline
    Given Je me connecte sur l application nopcommerce
    When Je saisis le email "<email>"
    And Je saisis le password "<password>"
    And Je clique sur le bouton LOGIN
    Then Je me redirige vers la page home "Dashboard"

    Examples: 
      | email               | password   |
      | admin@yourstore.com | admin      |
      | atef@gmail.com      | atef123    |
      | hanen@gmail.com     | hanen123   |
      | oussama@gmail.com   | oussama123 |
      | yosra@gmail.com     | yosra123   |
      | xxx@gmail.com       | xxx123     |
