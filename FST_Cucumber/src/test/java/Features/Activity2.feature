@activity2
Feature: Login Test

  Scenario: Testing Login
    Given User is on Login page
    When User enters username and password
    Then Close the Browser