Feature: Features in the density button of the ebooks page

  @AdminWeb
  Scenario: Verify that when the density button in the ebooks page is clicked it will display the full component
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to ebooks management page
    And I click on the density button in table header
    Then I will see the display options fully displayed

  @AdminWeb
  Scenario Outline: Verify that ebooks display modes are working correctly
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to ebooks management page
    And I click on the density button in table header
    And I choose "<mode>" mode
    Then I will see the data displayed in "<mode>" mode
    Examples:
      |mode       |
      |Compact    |
      |Standard   |
      |Comfortable|