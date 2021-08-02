Feature: Adding and Updating the product in to the cart

<As a user><I want to be able to place a successful order>

  Scenario: Validate Adding the product to the Cart is successful
    Given User is on Product Page
    And User clicks on Add To Cart button
    Then product should be added successfully to the cart
    Given User is on shopping cart page
    And click on remove check box of product
    And Click on Update Shopping cart button
    Then product should be removed successfully from the cart


