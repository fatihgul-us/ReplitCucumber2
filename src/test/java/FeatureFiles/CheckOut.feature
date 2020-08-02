Feature: Add to basket and check out function test

  Scenario: Login to page
    Given Navigate to: "http://automationpractice.com/index.php"
    Then Click on sign in menu
    Then Enter the email: "atlanta@gmail.com" and password: "Asdf4321-"
    And Click on sign in button

  Scenario: Add an item to basket and check price
    When Click on the dresses
    Then Click on the any item from the page
    And Click on the add to cart
    Then Click on the proceed to checkout button-1
    And Verify Total products + Total shipping = Total

  Scenario: Check out procedure and order confirmation
    When Click on the proceed to checkout button-2
    Then Click on the proceed to checkout button-3
    Then Click on the 'I agree....' checkbox
    And Click on the proceed to checkout button-4
    Then Click on the Pay by bank wire
    And Click on the I confirm my order button
    Then Verify Order confirmation text is displayed
