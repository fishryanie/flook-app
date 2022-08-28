Feature: Features in the more options button of the genres page

    @AdminWeb
    Scenario: Verify that when the more options button in the genres page is clicked it will display the full component
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to genres management page
        And I click on the more options button in table header
        Then I will see the data options fully displayed

    @AdminWeb
    Scenario: Verify that the add genre function fully displays element
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to genres management page
        And I click on the more options button in table header
        And I click on add data button
        Then I will see a form to add a genre with all the fields

    @AdminWeb
    Scenario Outline: Verify that the add genre function works correctly
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to genres management page
        And I click on the more options button in table header
        And I click on add data button
        And I enter genre name "<genreName>"
        And I click on continue button
        And I click on submit button
        And I click on the column button in table header
        And I click hide all button
        And I click on "Tên loại" checkbox button
        And I click on the filter button in table header
        And I select the column "Tên loại" in column dropdown list
        And I enter the key word "<genreName>" in value edit text
        Then I will see the genre that I created with the name "<genreName>"

        Examples:
            |genreName |
            |testGenre1|
            |testGenre2|

    @AdminWeb
    Scenario: Verify fields cannot be left blank in the first group of the add genre form
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to genres management page
        And I click on the more options button in table header
        And I click on add data button
        And I enter genre name "testGenre1"
        And I click on continue button
        Then I will see the message "Bạn chưa nhập đủ thông tin!"