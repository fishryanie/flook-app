Feature: Features in the filters button of the ebooks page

  @AdminWeb
  Scenario: Verify that when the filters button in the ebooks page is clicked it will display the full component
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to ebooks management page
    And I click on the column button in table header
    And I click show all button
    And I click on the filter button in table header
    Then I will see the filters box appear with close icon
    And I will see column dropdown list with full options
    And I will see operator dropdown list with full options
    And I will see filter value edit text

  @AdminWeb
  Scenario Outline: Verify that contains filter mode returns correct results
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to ebooks management page
    And I click on the column button in table header
    And I click hide all button
    And I click on "<columnTitle>" checkbox button
    And I click on the filter button in table header
    And I select the column "<columnTitle>" in column dropdown list
    And I select the option "contains" in operator dropdown list
    And I enter the key word "<keyWord>" in value edit text
    Then I will see a list of ebooks that contain the key word "<keyWord>"
    Examples:
      |columnTitle  |keyWord|
      |Stt          |5      |
      |Tên truyện   |Siêu   |
      |Tác giả      |Oda    |
      |Thể loại     |Action |
      |Trạng thái   |Đang   |

  @AdminWeb
  Scenario Outline: Verify that equals filter mode returns correct results
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to ebooks management page
    And I click on the column button in table header
    And I click hide all button
    And I click on "<columnTitle>" checkbox button
    And I click on the filter button in table header
    And I select the column "<columnTitle>" in column dropdown list
    And I select the option "equals" in operator dropdown list
    And I enter the key word "<keyWord>" in value edit text
    Then I will see a list of ebooks that equal the key word "<keyWord>"
    Examples:
      |columnTitle|keyWord                  |
      |Tên truyện |Bắt Đầu Từ Độ Kiếp       |
      |Tác giả    |Toriyama Akira           |
      |Thể loại   |Action, Anime, Truyện Màu|

  @AdminWeb
  Scenario Outline: Verify that starts with filter mode returns correct results
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to ebooks management page
    And I click on the column button in table header
    And I click hide all button
    And I click on "<columnTitle>" checkbox button
    And I click on the filter button in table header
    And I select the column "<columnTitle>" in column dropdown list
    And I select the option "starts with" in operator dropdown list
    And I enter the key word "<keyWord>" in value edit text
    Then I will see a list of ebooks that star with the key word "<keyWord>"
    Examples:
      |columnTitle |keyWord|
      |Tên truyện  |Nhất   |
      |Tác giả     |Oda    |
      |Giới thiệu  |Anh    |

  @AdminWeb
  Scenario Outline: Verify that ends with filter mode returns correct results
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to ebooks management page
    And I click on the column button in table header
    And I click hide all button
    And I click on "<columnTitle>" checkbox button
    And I click on the filter button in table header
    And I select the column "<columnTitle>" in column dropdown list
    And I select the option "ends with" in operator dropdown list
    And I enter the key word "<keyWord>" in value edit text
    Then I will see a list of ebooks that end with the key word "<keyWord>"
    Examples:
      |columnTitle |keyWord   |
      |Tên truyện  |Thần      |
      |Tác giả     |oki       |
      |Thể loại    |Truyện Màu|

  @AdminWeb
  Scenario: Verify that is empty filter mode hides the value input box
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to ebooks management page
    And I click on the filter button in table header
    And I select the option "is empty" in operator dropdown list
    Then I will see value input box is hidden

  @AdminWeb
  Scenario Outline: Verify that is empty filter mode returns correct results
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to ebooks management page
    And I click on the column button in table header
    And I click hide all button
    And I click on "<columnTitle>" checkbox button
    And I click on the filter button in table header
    And I select the column "<columnTitle>" in column dropdown list
    And I select the option "is empty" in operator dropdown list
    Then I will see a list of ebooks that is empty
    Examples:
      |columnTitle |
      |Giới thiệu  |

  @AdminWeb
  Scenario: Verify that is not empty filter mode hides the value input box
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to ebooks management page
    And I click on the filter button in table header
    And I select the option "is not empty" in operator dropdown list
    Then I will see value input box is hidden

  @AdminWeb
  Scenario Outline: Verify that is not empty filter mode returns correct results
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to ebooks management page
    And I click on the column button in table header
    And I click hide all button
    And I click on "<columnTitle>" checkbox button
    And I click on the filter button in table header
    And I select the column "<columnTitle>" in column dropdown list
    And I select the option "is not empty" in operator dropdown list
    Then I will see a list of ebooks that is not empty
    Examples:
      |columnTitle |
      |Trạng thái  |

  @AdminWeb
  Scenario: Verify that the close button in the filters box works correctly
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to ebooks management page
    And I click on the filter button in table header
    And I select the column "Tên truyện" in column dropdown list
    And I select the option "equals" in operator dropdown list
    And I enter the key word "abc" in value edit text
    And I click close button in filters box
    Then I will see value edit text is empty
    When I click close button in filters box
    And I click on the filter button in table header
    Then I will see the value of the column dropdown list as "Stt"
    And I will see the value of the operator dropdown list as "contains"