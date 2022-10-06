Feature: Use google cloud calculator

  Background: Open compute engine calculator
    Given user opens google cloud pricing calculator

  Scenario: User fills compute engine and adds to estimate
    Given user fills compute engine
    And user adds to estimate
    Then user verifies price is '1.234,05'

  Scenario Outline: Calculator header contains appropriate tabs
    Then user verifies <title> tabs are displayed
    Examples:
      | title          |
      | Compute Engine |
      | GKE Standard   |
