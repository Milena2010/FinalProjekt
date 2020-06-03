Feature: MyStore logIn

  Scenario Outline: Create new user account with full address information

    Given User can logged to MyStore shop site from CodersLab
    When User create new address form <alias>, <address>, <city>, <postalCode>, <country>, <phone> check information
    And User click save button
    And User sees information Address successfully added!
    Then User remove address checking the deletion with information Address successfully deleted!

  Examples:
      | alias     | address   | city     | postalCode | country  | phone     |
      | Mrs.      | Wielka 3  | Wroclaw  | 50-077     | 17       | +55666777 |