@YoutubeFeature
Feature: Youtube

  Scenario: validate blibli channel description
    Given user search for 'Blibli'
    When  user click Blibli channel
    And   user go to about tab
    Then  get channel description

    When user go to playlist tab
    And  user open playlist 'Blibli 10th Anniversary – by Blibli.com - 14 videos'
    And  get fist video title
    And  user click the first video
    Then validate that the top video clicked is the one being play





