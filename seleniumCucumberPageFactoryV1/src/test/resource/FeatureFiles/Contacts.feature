@ActiveFeature
Feature: This feature file cover scenario related to contacts form

Background:
Given i login as "visitorUser" using passowrd "visitorUserPassword"

@Active
  Scenario: check that name and email is mandatory on contact form
    Given I click on contact link
    And I click on Send button
    Then I got validation error message

@Active
    Scenario: check that user can submit contact form successfully
    Given I click on contact link
    And I fill the contact form
    And I click on Send button
    Then I got success message "Your message was sent successfully. Thanks."
  
