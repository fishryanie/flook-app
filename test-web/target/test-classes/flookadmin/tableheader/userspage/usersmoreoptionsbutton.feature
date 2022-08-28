Feature: Features in the more options button of the users page

    @AdminWeb
    Scenario: Verify that when the more options button in the users page is clicked it will display the full component
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to user management page
        And I click on the more options button in table header
        Then I will see the data options fully displayed

    @AdminWeb
    Scenario: Verify that the add user function fully displays element
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to user management page
        And I click on the more options button in table header
        And I click on add data button
        Then I will see a form to add a user with the information in the first group
        And I click on continue button
        Then I will see a form to add a user with the information in the second group
        And I click on continue button
        Then I will see a form to add a user with the information in the third group
        And I click on continue button
        Then I will see a form to add a user with the information in the fourth group
        And I click on back button
        Then I will see a form to add a user with the information in the third group
        And I click on back button
        Then I will see a form to add a user with the information in the second group
        And I click on back button
        Then I will see a form to add a user with the information in the first group

    @AdminWeb
    Scenario Outline: Verify that the add user function works correctly
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to user management page
        And I click on the more options button in table header
        And I click on add data button
        And I enter display name "<DisplayName>", phone number "<phoneNumber>", username "<UserName>", email "<Email>" and password "<Password>"
        And I click on continue button
        And I select is active "<IsActive>"
        And I click on continue button
        And I select role "<roles>"
        And I click on continue button
        And I select image
        And I click on continue button
        And I click on submit button
        And I click on the column button in table header
        And I click hide all button
        And I click on "Email" checkbox button
        And I click on the filter button in table header
        And I select the column "Email" in column dropdown list
        And I enter the key word "<Email>" in value edit text
        Then I will see the user that I created with the email "<Email>"

        Examples:
            |DisplayName  |phoneNumber  |UserName      |Email                   |Password     |IsActive |roles|
            |Dany Sweet   |8858995989   |sweetsweet8858|sweetsweet8858@gmail.com|AaAaAa*121314|Active   |Admin|
            |Hala Angry   |7787997989   |angryangry7787|angryangry7787@gmail.com|AaAaAa*121314|No Active|Admin|

  @AdminWeb
  Scenario Outline: Verify fields cannot be left blank in the first group of the add user form
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to user management page
    And I click on the more options button in table header
    And I click on add data button
    And I enter display name "<DisplayName>", phone number "<phoneNumber>", username "<UserName>", email "<Email>" and password "<Password>"
    And I click on continue button
    Then I will see the message "<Message>"

    Examples:
      |DisplayName  |phoneNumber  |UserName      |Email                   |Password     |Message                    |
      |Dany Sweet   |8858995989   |sweetsweet8858|                        |AaAaAa*121314|Bạn chưa nhập đủ thông tin!|
      |Hala Angry   |7787997989   |              |angryangry7787@gmail.com|AaAaAa*121314|Bạn chưa nhập đủ thông tin!|
      |Hala Angry   |7787997989   |angryangry7787|angryangry7787@gmail.com|             |Bạn chưa nhập đủ thông tin!|

  @AdminWeb
  Scenario Outline: Verify fields cannot be left blank in the second group of the add user form
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to user management page
    And I click on the more options button in table header
    And I click on add data button
    And I enter display name "<DisplayName>", phone number "<phoneNumber>", username "<UserName>", email "<Email>" and password "<Password>"
    And I click on continue button
    And I click on continue button
    Then I will see the message "<Message>"

    Examples:
      |DisplayName  |phoneNumber  |UserName      |Email                   |Password     |Message                    |
      |Dany Sweet   |8858995989   |sweetsweet8858|sweetsweet8858@gmail.com|AaAaAa*121314|Bạn chưa nhập đủ thông tin!|