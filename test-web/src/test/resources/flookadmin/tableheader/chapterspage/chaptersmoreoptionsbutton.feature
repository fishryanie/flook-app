Feature: Features in the more options button of the chapters page

    @AdminWeb
    Scenario: Verify that when the more options button in the chapters page is clicked it will display the full component
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to chapters management page
        And I click on the more options button in table header
        Then I will see the data options fully displayed

    @AdminWeb
    Scenario: Verify that the add chapter function fully displays element
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to chapters management page
        And I click on the more options button in table header
        And I click on add data button
        Then I will see a form to add a chapter with the information in the first group
        And I click on continue button
        Then I will see a form to add a chapter with the information in the second group
        And I click on continue button
        Then I will see a form to add a chapter with the information in the third group
        And I click on back button
        Then I will see a form to add a chapter with the information in the second group
        And I click on back button
        Then I will see a form to add a chapter with the information in the first group

    @AdminWeb
    Scenario Outline: Verify that the add chapter function works correctly
        Given I open the user website
        When I login with the username "huyhdang" and the password "Admin1@113355"
        And I navigate to chapters management page
        And I click on the more options button in table header
        And I click on add data button
        And I enter chapter name "<chapterName>" and status "<status>"
        And I click on continue button
        And I select ebook "<ebook>"
        And I click on continue button
        And I select image
        And I click on continue button
        And I click on submit button
        And I click on the column button in table header
        And I click hide all button
        And I click on "Tên" checkbox button
        And I click on the filter button in table header
        And I select the column "Tên" in column dropdown list
        And I enter the key word "<chapterName>" in value edit text
        Then I will see the chapter that I created with the chapter name "<chapterName>"

        Examples:
            |chapterName     |status       |ebook              |
            |Chapter Test 001|Đang cập nhật|Anh Hùng, Hồi Quy  |
            |Chapter Test 002|Đã hoàn thành|Cựu Tác Long Hổ Môn|

  @AdminWeb
  Scenario Outline: Verify fields cannot be left blank in the first group of the add chapter form
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to chapters management page
    And I click on the more options button in table header
    And I click on add data button
    And I enter chapter name "<chapterName>" and status "<status>"
    And I click on continue button
    Then I will see the message "<Message>"

    Examples:
      |chapterName     |status       |Message                    |
      |                |Đang cập nhật|Bạn chưa nhập đủ thông tin!|

  @AdminWeb
  Scenario Outline: Verify fields cannot be left blank in the second group of the add chapter form
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to chapters management page
    And I click on the more options button in table header
    And I click on add data button
    And I enter chapter name "<chapterName>" and status "<status>"
    And I click on continue button
    And I click on continue button
    Then I will see the message "<Message>"

    Examples:
      |chapterName     |status       |Message                    |
      |Chapter Test 005|Đang cập nhật|Bạn chưa nhập đủ thông tin!|