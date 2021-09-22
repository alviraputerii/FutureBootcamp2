Feature: Compare  Yugi-Oh cards

  @CompareYugiOh
  Scenario Outline: Compare  Yugi-Oh cards between 2 websites
    Given open original Yugi-Oh home page
    And   original Yugi-Oh home page should be opened
    When  at original Yugi-Oh home page click button card search
    And   at original Yugi-Oh home page search for card '<card>'
    And   at original Yugi-Oh card page click match result for '<card>'
    And   switch to card details page
    Then  get Yugi-Oh card's following information
      | cardName    |
      | attribute   |
      | rank/level  |
      | monsterType |
      | cardType    |
      | atk         |
      | def         |
      | cardEffects |

    Given open wiki Yugipedia home page
    And   wiki Yugipedia home page should be opened
    When  at wiki Yugipedia home page search for card '<card>'
    Then  get wiki Yugipedia following information
      | cardName    |
      | attribute   |
      | rank/level  |
      | monsterType |
      | cardType    |
      | atk         |
      | def         |
      | cardEffects |

    Then compare the following card information
      | cardName    |
      | attribute   |
      | rank/level  |
      | monsterType |
      | cardType    |
      | atk         |
      | def         |
      | cardEffects |

    Examples:
      | card                          |
#      | Dark Magician                 |
#      | Active Guard                  |
#      | Dark Magician Girl            |
#      | Rayquaza                      |
      | Slifer                        |
#      | Shooting Star Dragon          |
#      | Utopia Ray V                  |
      | Performapal Odd-Eyes Synchron |