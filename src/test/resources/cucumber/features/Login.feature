Feature: As a user I want to login to my account

  @smoke
  Scenario Outline: User must be logged in
    Given the user open OnlineShop Website
    When the user click on the Sign in button
    And the user type the "<userName>" and "<password>"
    Then the user is signedIn
    Examples:
    |userName||password|
    |hayk@mail.ru||Qwerty12@|
