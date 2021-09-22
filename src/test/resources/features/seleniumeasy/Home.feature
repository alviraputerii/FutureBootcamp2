@FormDataTable
Feature: Fill Form

  @FirstTryDataTable
  Scenario Outline: Fill input form in seleniumeasy with dummy data
    Given user open form
    Then  validate url
    When  user fill the form with following data
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | <email>     |

    Examples:
      | firstName | lastName | email             |
      | Blibli1   | Dot Com  | blibli@DotCom.Com |
      | Blibli2   | Dot Com  | blibli@gdn.Com    |
      | Blibli3   | Dot Com  | blibli@gdn.Com    |


