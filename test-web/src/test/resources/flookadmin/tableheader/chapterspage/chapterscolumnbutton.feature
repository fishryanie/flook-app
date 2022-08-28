Feature: Features in the column button of the chapters page

  @AdminWeb
  Scenario: Verify that when the column button in the chapters page is clicked it will display the full component
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to chapters management page
    And I click on the column button in table header
    Then I will see the column box appear with search edit text
    And I will see all chapter column checkboxes are displayed
    And I will see hide all and show all button are displayed

  @AdminWeb
  Scenario Outline: Verify that when entering a keyword in chapters page column box search box, a list of checkboxes matching the keyword will be returned
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to chapters management page
    And I click on the column button in table header
    And I enter keyword "<keyWord>" in the column box search box
    Then I will see all column checkboxes that match the keyword "<keyWord>"
    Examples:
      |keyWord |
      |St      |
      |Tên     |
      |N       |

  @AdminWeb
  Scenario: Verify that clicking chapters page hide all button will deselect all checkboxes and hide all columns
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to chapters management page
    And I click on the column button in table header
    And I click hide all button
    Then I will see all checkboxes unchecked
    And I will see all columns hidden

  @AdminWeb
  Scenario: Verify that clicking chapters page show all button will deselect all checkboxes and hide all columns
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to chapters management page
    And I click on the column button in table header
    And I click show all button
    Then I will see all checkboxes checked
    And I will see all chapter columns displayed

  @AdminWeb
  Scenario Outline: Verify that chapters page column box hides and shows the correct column
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to chapters management page
    And I click on the column button in table header
    And I click show all button
    And I click on "<columnTitle>" checkbox button
    Then I will see column "<columnTitle>" hidden
    When I click on "<columnTitle>" checkbox button
    Then I will see column "<columnTitle>" show
    Examples:
      |columnTitle|
      |Stt        |
      |Tên        |
      |Truyện     |
