Feature: Checkout Process

  Scenario Outline: Successful checkout as a registered user
    Given The user completes the registration form with "<Username>", "<Email>", "<Password>", "<First Name>", "<Last Name>", "<Phone Number>", "<Country>", "<City>", "<Address>", "<State>", and "<Postal Code>"
    And Agrees to the terms and submits the registration
    And The user adds items to the cart
    And The user proceeds to checkout
    When The user enters SafePay credentials "<safePayUsername>" and "<safePayPassword>"
    Then The checkout process should be successful

    Examples:
      | Username  | Email                | Password  | First Name | Last Name | Phone Number | Country | City   | Address         | State | Postal Code | safePayUsername | safePayPassword |
      | JohnDoe   | john.doe@example.com | #Root@123 | John       | Doe       | 1234567890   | Brazil  | Olinda | 123 Main Street | PE    | 53080000    | JohnDoe         | #Root@123       |
