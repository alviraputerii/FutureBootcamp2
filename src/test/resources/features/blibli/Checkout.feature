@Checkout
Feature: Checkout some Blibli products

  @SearchBar
  Scenario Outline: Checkout product by search bar
    Given open blibli.com home page
    And   blibli.com home page should be opened
    When  at blibli.com home page search for product '<product>'
    And   at blibli.com product page get first product name
    And   at blibli.com product page hover the first product
    And   at blibli.com product page first product dropdown click tambah ke bag
    And   at blibli.com product page get product price
    And   at blibli.com product page modal click tambah ke bag
    Then  at blibli.com product page hover bag icon
    Then  product should be added to bag
    And   check product name that added to bag
    And   check product price that added to bag

    Examples:
      | product   |
#      | indomie   |
      | pepsodent |

  @Category
  Scenario: Checkout product by category menu
    Given open blibli.com home page
    And   blibli.com home page should be opened
    When  at blibli.com product page click button category
    And   at blibli.com product page category dropdown hover bliblimart
    And   at blibli.com product page bliblimart dropdown click kuliner jepang
    And   at blibli.com product page get first product name
    And   at blibli.com product page hover the first product
    And   at blibli.com product page first product dropdown click tambah ke bag
    And   at blibli.com product page get product price
    And   at blibli.com product page modal click tambah ke bag
    Then  at blibli.com product page hover bag icon
    Then  product should be added to bag
    And   check product name that added to bag
    And   check product price that added to bag