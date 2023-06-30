Feature: Login to Amazon and Add to Cart

  Scenario: User logs in to Amazon
    Given User is on the Amazon login page
    When User clicks on the Sign in button
    And User enters valid username and password
    When User clicks on the Signin Submit button
    Then User should be able to logged in succeffuly and redirected to the home page

  Scenario: User searches for a book, adds it to the cart and verifies the details
    Given User searches for "100+ Solutions in Java"
    And User selectes the book
    When User sets the quanitity to 2
    And User adds the book to the cart
    Then User navigate to the cart and verifies the product, quanitity, and amount
