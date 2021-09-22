@PokeApiFeature
Feature: PokeApi

  Scenario: get pokemon data from PokeApi website
    When  send request for pokemon 'Pikachu' in PokeApi
    Then  response code must be 200





