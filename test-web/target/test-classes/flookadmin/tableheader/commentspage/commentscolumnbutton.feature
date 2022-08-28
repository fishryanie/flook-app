Feature: Features in the column button of the comments page

  @AdminWeb
  Scenario: Verify that when the column button in the comments page is clicked it will display the full component
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to comments management page
    And I click on the column button in table header
    Then I will see the column box appear with search edit text
    And I will see all comment column checkboxes are displayed
    And I will see hide all and show all button are displayed

  @AdminWeb
  Scenario Outline: Verify that when entering a keyword in comments page column box search box, a list of checkboxes matching the keyword will be returned
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to comments management page
    And I click on the column button in table header
    And I enter keyword "<keyWord>" in the column box search box
    Then I will see all column checkboxes that match the keyword "<keyWord>"
    Examples:
      |keyWord |
      |St      |
      |Ng      |

  @AdminWeb
  Scenario: Verify that clicking comments page hide all button will deselect all checkboxes and hide all columns
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to comments management page
    And I click on the column button in table header
    And I click hide all button
    Then I will see all checkboxes unchecked
    And I will see all columns hidden

  @AdminWeb
  Scenario: Verify that clicking comments page show all button will deselect all checkboxes and hide all columns
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to comments management page
    And I click on the column button in table header
    And I click show all button
    Then I will see all checkboxes checked
    And I will see all comment columns displayed

  @AdminWeb
  Scenario Outline: Verify that comments page column box hides and shows the correct column
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to comments management page
    And I click on the column button in table header
    And I click show all button
    And I click on "<columnTitle>" checkbox button
    Then I will see column "<columnTitle>" hidden
    When I click on "<columnTitle>" checkbox button
    Then I will see column "<columnTitle>" show
    Examples:
      |columnTitle|
      |Stt        |
      |Người dùng |
      |Nội dung   |
