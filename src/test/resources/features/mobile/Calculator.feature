@CalculatorFeature
Feature: Calculator

  Scenario: Test input scenario from 9 to 0 and check whether numbers appear correctly
    When I press number from 9 to 0
    Then I could see all number from 9 to 0 appear on the formula screen

#    Given user open calculator app
#    When  user click number 2
#    And   user click operator '+'




