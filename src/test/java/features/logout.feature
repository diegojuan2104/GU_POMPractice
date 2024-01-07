Feature: Logout functionality
  As a logged-in user
  I want to log out from the system
  So that my session is terminated

  Scenario Outline: Logout successfully redirects to login page
    Given I am logged in to the system with valid <username> and <password>
    When I click on the logout button
    Then I should be redirected to the login page
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |