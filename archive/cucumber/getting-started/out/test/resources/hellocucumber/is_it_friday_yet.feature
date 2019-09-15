Feature: Is it Friday yet?
  Everyone wants to know when it is Friday.

  Scenario: Sunday isn't Friday
    Given today is Sunday
    When I ask whether it's Friday
    Then I should be told "Nope"

