Feature: Features in the more options button of the roles page

    @AdminWeb
    Scenario: Verify that when the more options button in the roles page is clicked it will display the full component
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to roles management page
        And I click on the more options button in table header
        Then I will see the data options fully displayed

    @AdminWeb
    Scenario: Verify that the add role function fully displays element
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to roles management page
        And I click on the more options button in table header
        And I click on add data button
        Then I will see a form to add a role with all the fields

    @AdminWeb
    Scenario Outline: Verify that the add role function works correctly
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to roles management page
        And I click on the more options button in table header
        And I click on add data button
        And I enter role name "<roleName>" and description "<description>"
        And I click on continue button
        And I click on submit button
        And I click on the column button in table header
        And I click hide all button
        And I click on "Tên" checkbox button
        And I click on the filter button in table header
        And I select the column "Tên" in column dropdown list
        And I enter the key word "<roleName>" in value edit text
        Then I will see the role that I created with the name "<roleName>"

        Examples:
            |roleName  |description  |
            |testRole1 |abc abc      |
            |testRole2 |xyz xyz      |

    @AdminWeb
    Scenario Outline: Verify fields cannot be left blank in the first group of the add role form
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to roles management page
        And I click on the more options button in table header
        And I click on add data button
        And I enter role name "<roleName>" and description "<description>"
        And I click on continue button
        Then I will see the message "<Message>"

        Examples:
            |roleName  |description  |Message                    |
            |          |xyz xyz      |Bạn chưa nhập đủ thông tin!|