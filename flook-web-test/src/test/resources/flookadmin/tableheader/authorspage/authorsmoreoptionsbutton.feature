Feature: Features in the more options button of the authors page

    @AdminWeb
    Scenario: Verify that when the more options button in the authors page is clicked it will display the full component
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to authors management page
        And I click on the more options button in table header
        Then I will see the data options fully displayed

    @AdminWeb
    Scenario: Verify that the add author function fully displays element
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to authors management page
        And I click on the more options button in table header
        And I click on add data button
        Then I will see a form to add a author with the information in the first group
        And I click on continue button
        Then I will see a form to add a author with the information in the second group
        And I click on back button
        Then I will see a form to add a author with the information in the first group

    @AdminWeb
    Scenario Outline: Verify that the add author function works correctly
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to authors management page
        And I click on the more options button in table header
        And I click on add data button
        And I enter author name "<authorName>"
        And I click on continue button
        And I select license "<license>"
        And I click on continue button
        And I click on submit button
        And I click on the column button in table header
        And I click hide all button
        And I click on "Tên" checkbox button
        And I click on the filter button in table header
        And I select the column "Tên" in column dropdown list
        And I enter the key word "<authorName>" in value edit text
        Then I will see the author that I created with the author name "<authorName>"

        Examples:
            |authorName     |license         |
            |Shilla Monogram|Lê Hữu Thành    |
            |Metropole      |Hoàng Linh Trung|

  @AdminWeb
  Scenario: Verify fields cannot be left blank in the first group of the add author form
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to authors management page
    And I click on the more options button in table header
    And I click on add data button
    And I click on continue button
    Then I will see the message "Bạn chưa nhập đủ thông tin!"

  @AdminWeb
  Scenario: Verify fields cannot be left blank in the second group of the add author form
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to authors management page
    And I click on the more options button in table header
    And I click on add data button
    And I enter author name "Shilla Monogram"
    And I click on continue button
    And I click on continue button
    Then I will see the message "Bạn chưa nhập đủ thông tin!"