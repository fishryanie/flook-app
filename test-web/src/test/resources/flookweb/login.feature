Feature: Log in to the website

  @Login
  Scenario: Verify that the login interface fully displays the elements
    Given I open the Flook website
    When I click the login button
    Then I will see the elements fully displayed

  @Login
  Scenario: Verify the Google account login functionality is working correctly
    Given I open the Flook website
    When I click the login button
    And I click the login with Google account button
    Then I will see the Google account login page, or a notification that the function is updating

  @Login
  Scenario: Verify the Facebook account login functionality is working correctly
    Given I open the Flook website
    When I click the login button
    And I click the login with Facebok account button
    Then I will see the Facebook account login page, or a notification that the function is updating

  @Login
  Scenario Outline: Verify that it is possible to log into the system with the correct account and password
    Given I open the Flook website
    When I click the login button
    And I enter my username "<username>" in the username field
    And I enter my password "<password>" in the password field
    And I click the submit button
    Then I will see the system display the message "Đăng nhập thành công!"
    When I wait "6000" milliseconds
    Then I will see the login button change to the password change button
    When I click the account button
    Then I will see the logout button displayed.

    Examples:
      |username       |password        |
      |moderator      |Moderator@113355|
      |huyhdang       |Admin1@113355   |
      |thanhlehuu223  |Abc*123456789   |

  @Login
  Scenario Outline: Verify that the system works correctly when the user leaves the account or password blank
    Given I open the Flook website
    When I click the login button
    And I enter my username "<username>" in the username field
    And I enter my password "<password>" in the password field
    And I click the submit button
    Then I will see the system display the message "<Message>"

    Examples:
      |username |password         |Message                             |
      |         |Moderator@113355 |Vui lòng nhập tài khoản!            |
      |huyhdang |                 |Vui lòng nhập mật khẩu!             |
      |         |                 |Vui lòng nhập tài khoản và mật khẩu!|

  @Login
  Scenario Outline: Verify that the system works correctly when the user enters the wrong account or password
    Given I open the Flook website
    When I click the login button
    And I enter my username "<username>" in the username field
    And I enter my password "<password>" in the password field
    And I click the submit button
    Then I will see the system display the message "Sai tên tài khoản hoặc mật khẩu!"

    Examples:
      |username     |password        |
      |moderatoh    |Moderator@113355|
      |huyhdang     |dAmin1@113356   |
      |thanFlehuu253|Abc*123456553   |

  @Login
  Scenario Outline: Verify that the admin account can access the admin page
    Given I open the Flook website
    When I click the login button
    And I enter my username "<username>" in the username field
    And I enter my password "<password>" in the password field
    And I click the submit button
    And I go to admin page
    Then I will see the dashboard of the admin page

    Examples:
      |username     |password        |
      |moderator    |Moderator@113355|
      |huyhdang     |Admin1@113355   |

  @Login
  Scenario Outline: Verify that a non-admin account can't access the admin page
    Given I open the Flook website
    When I click the login button
    And I enter my username "<username>" in the username field
    And I enter my password "<password>" in the password field
    And I click the submit button
    And I go to admin page
    Then I will not see the dashboard of the admin page
    And I will see the system display the message "Bạn không có quyền truy cập link này!"

    Examples:
      |username      |password     |
      |thanhlehuu223 |Abc*123456789|
      |trunghoang1145|Abc*123456789|