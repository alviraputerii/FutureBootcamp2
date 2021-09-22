Feature: Lookup a definition
  In order to talk better
  As an English student
  I want to look up word definitions

  Scenario: Looking up the definition of 'apple'
    Given the user is on the Wikipedia home page
    When the user looks up the definition of the word 'Apple'
    Then they should see the header of article is 'Apple'