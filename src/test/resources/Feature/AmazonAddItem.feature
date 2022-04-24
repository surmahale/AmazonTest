#Author: Surabhi Mahale
@smokeTest
Feature: Test the Amazon UK website

  Scenario: Add an item to Amazon basket and increase its quantity
    Given user launches browser
    When user logins to Amazon
    When searches for the product and verifies the search result
    Then add the product to basket
    Then validate the product is added to basket
    And increase the quantity and validate the subtotal
