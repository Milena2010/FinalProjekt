Feature: MyStore logIn

  Scenario Outline: Create new user account with full address information

    Given User can logged to MyStore shop site from CodersLab
    When User create new address form <alias>, <address>, <city>, <postCode>, <country>, <phone>
    Then User check address

  Examples:
      | alias     | address   | city     | postCode | country        | phone        |
      | Mrs.      | Wielka 3  | Wroclaw  | 50-077   | United Kingdom | +55666777888 |