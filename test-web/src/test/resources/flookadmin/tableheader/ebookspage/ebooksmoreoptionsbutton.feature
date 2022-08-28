Feature: Features in the more options button of the ebooks page

    @AdminWeb
    Scenario: Verify that when the more options button in the ebooks page is clicked it will display the full component
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to ebooks management page
        And I click on the more options button in table header
        Then I will see the data options fully displayed

    @AdminWeb
    Scenario: Verify that the add ebook function fully displays element
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to ebooks management page
        And I click on the more options button in table header
        And I click on add data button
        Then I will see a form to add a ebook with the information in the first group
        And I click on continue button
        Then I will see a form to add a ebook with the information in the second group
        And I click on continue button
        Then I will see a form to add a ebook with the information in the third group
        And I click on back button
        Then I will see a form to add a ebook with the information in the second group
        And I click on back button
        Then I will see a form to add a ebook with the information in the first group

    @AdminWeb
    Scenario Outline: Verify that the add ebook function works correctly
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to ebooks management page
        And I click on the more options button in table header
        And I click on add data button
        And I enter name "<name>", status "<status>" and description "<description>"
        And I click on continue button
        And I select authors "<authors>" and genres "<genres>"
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
        Then I will see the ebook that I created with the name "<name>"

        Examples:
            |name                    |status       |description   |authors        |genres|
            |Truyện test 1           |Đang cập nhật|abc           |Chiba Tetsuya  |Anime |
            |Truyện test 2           |Đang cập nhật|abc           |Miyazaki Hayao |Magic |

  @AdminWeb
  Scenario Outline: Verify fields cannot be left blank in the first group of the add ebook form
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to ebooks management page
    And I click on the more options button in table header
    And I click on add data button
    And I enter name "<name>", status "<status>" and description "<description>"
    And I click on continue button
    Then I will see the message "<message>"

    Examples:
      |name|status       |description   |message                    |
      |    |Đang cập nhật|abc           |Bạn chưa nhập đủ thông tin!|

  @AdminWeb
  Scenario Outline: Verify fields cannot be left blank in the second group of the add ebook form
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to ebooks management page
    And I click on the more options button in table header
    And I click on add data button
    And I enter name "<name>", status "<status>" and description "<description>"
    And I click on continue button
    And I click on continue button
    Then I will see the message "<Message>"

    Examples:
      |name                    |status       |description   |Message                    |
      |Truyện test 1           |Đang cập nhật|abc           |Bạn chưa nhập đủ thông tin!|