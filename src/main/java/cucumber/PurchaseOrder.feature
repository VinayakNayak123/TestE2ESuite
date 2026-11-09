#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Sale transactions on the cart

Background: Given I landed on Ecomm Page

  
   @tag1
  Scenario Outline: Adding Items to basket
    Given I have correct  <username> and <password>
    And I have logged in
    When I add Item <product> in my basket
    Then Finally message "THANKYOU FOR THE ORDER." should be displayed
    And I should see it

    Examples: 
      | username  | password | product |
      | user@usertest.com |     Usertest@123 | ZARA COAT 3 |
      
    
      
    @tag2
      Scenario: Payment by Cash
      Given : I am logged into POS
      And : present on Home Page
      When : User adds item
      Then : I pay by Cash
      
      
      