@ActiveFeature
Feature: This feature file cover scenario related to registration form

  Background: 
    Given i am on registration page

  @Active
  Scenario: check that name and email is mandatory on registration form
    And I click on Submit button
    Then I got validation error message for mandatory fields

  @Active
  Scenario: check that user can resgister successfully
    Given i fill the registration form
      | First Name | Last Name | Phone Number | Password   | Confirm Password |
      | Kuldeep    | Kumar     |   8460876970 | Password@1 | Password@1       |
    And I click on Submit button
    Then I got registration success message

  @Active
  Scenario Outline: check that user can not use existing email for registration
    Given i fill the registration form using <email>
    And I click on Submit button
    Then I got validation error stating email already exists

    Examples: 
      | email                |
      | kuldeep123@gmail.com |
      | ajit123@gmail.com    |
