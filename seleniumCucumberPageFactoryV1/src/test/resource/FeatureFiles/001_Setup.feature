@ActiveFeature
Feature: This feature file cover scenario related to set up

  @Active
  Scenario: check that name and email is mandatory on contact form
    Given i login as "superUser" using passowrd "superUserPassword"
    And i navigae to new contact form
    And i select title

  @Active
  Scenario: Check existence of contact
    Given i login as "superUser" using passowrd "superUserPassword"
    And i search for contact

  @Active
  Scenario: Create Company
    Given i login as "superUser" using passowrd "superUserPassword"
    And I navigate to "Companies" configuration screen
    And I check existence of company "Test Company 4"

  @Active
  Scenario: Create SLA Definitions
    Given i login as "superUser" using passowrd "superUserPassword"
    And I navigate to "System Case SLA Definitions" configuration screen
    And I check existence of SLA Definition "SLA Definition Test"
