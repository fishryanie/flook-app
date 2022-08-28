Feature: Features in the filters button of the reviews page

  @AdminWeb
  Scenario: Verify that when the filters button in the reviews page is clicked it will display the full component
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to reviews management page
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
    And I navigate to reviews management page
    And I click on the column button in table header
    And I click hide all button
    And I click on "<columnTitle>" checkbox button
    And I click on the filter button in table header
    And I select the column "<columnTitle>" in column dropdown list
    And I select the option "contains" in operator dropdown list
    And I enter the key word "<keyWord>" in value edit text
    Then I'll see a list of reviews where the "<columnTitle>" column contains the keyword "<keyWord>"
    Examples:
      |columnTitle|keyWord|
      |Người dùng |inh    |
      |Truyện     |Thần   |
      |Đánh giá   |3      |

  @AdminWeb
  Scenario Outline: Verify that equals filter mode returns correct results
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to reviews management page
    And I click on the column button in table header
    And I click hide all button
    And I click on "<columnTitle>" checkbox button
    And I click on the filter button in table header
    And I select the column "<columnTitle>" in column dropdown list
    And I select the option "equals" in operator dropdown list
    And I enter the key word "<keyWord>" in value edit text
    Then I'll see a list of reviews where the "<columnTitle>" column equal the keyword "<keyWord>"
    Examples:
      |columnTitle|keyWord          |
      |Người dùng |Hoàng Nhật Lệ    |
      |Truyện     |Côn Thôn Thiên Hạ|
      |Đánh giá   |3                |

  @AdminWeb
  Scenario Outline: Verify that starts with filter mode returns correct results
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to reviews management page
    And I click on the column button in table header
    And I click hide all button
    And I click on "<columnTitle>" checkbox button
    And I click on the filter button in table header
    And I select the column "<columnTitle>" in column dropdown list
    And I select the option "starts with" in operator dropdown list
    And I enter the key word "<keyWord>" in value edit text
    Then I'll see a list of reviews where the "<columnTitle>" column star with the keyword "<keyWord>"
    Examples:
      |columnTitle|keyWord|
      |Người dùng |Hoàng  |
      |Truyện     |Siêu   |
      |Đánh giá   |5      |

  @AdminWeb
  Scenario Outline: Verify that ends with filter mode returns correct results
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to reviews management page
    And I click on the column button in table header
    And I click hide all button
    And I click on "<columnTitle>" checkbox button
    And I click on the filter button in table header
    And I select the column "<columnTitle>" in column dropdown list
    And I select the option "ends with" in operator dropdown list
    And I enter the key word "<keyWord>" in value edit text
    Then I'll see a list of reviews where the "<columnTitle>" column end with the keyword "<keyWord>"
    Examples:
      |columnTitle|keyWord|
      |Người dùng |Vy     |
      |Truyện     |Thần   |
      |Đánh giá   |5      |

  @AdminWeb
  Scenario: Verify that is empty filter mode hides the value input box
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to reviews management page
    And I click on the filter button in table header
    And I select the option "is empty" in operator dropdown list
    Then I will see value input box is hidden

  @AdminWeb
  Scenario Outline: Verify that is empty filter mode returns correct results
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to reviews management page
    And I click on the column button in table header
    And I click hide all button
    And I click on "<columnTitle>" checkbox button
    And I click on the filter button in table header
    And I select the column "<columnTitle>" in column dropdown list
    And I select the option "is empty" in operator dropdown list
    Then I will see a list of reviews that is empty
    Examples:
      |columnTitle |
      |Nội dung    |

  @AdminWeb
  Scenario: Verify that is not empty filter mode hides the value input box
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to reviews management page
    And I click on the filter button in table header
    And I select the option "is not empty" in operator dropdown list
    Then I will see value input box is hidden

  @AdminWeb
  Scenario Outline: Verify that is not empty filter mode returns correct results
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to reviews management page
    And I click on the column button in table header
    And I click hide all button
    And I click on "<columnTitle>" checkbox button
    And I click on the filter button in table header
    And I select the column "<columnTitle>" in column dropdown list
    And I select the option "is not empty" in operator dropdown list
    Then I will see a list of reviews with the column "<review>" not empty
    Examples:
      |columnTitle|
      |Nội dung   |

  @AdminWeb
  Scenario: Verify that the close button in the filters box works correctly
    Given I open the user website
    When I login with the username "huyhdang" and the password "Admin1@113355"
    And I navigate to reviews management page
    And I click on the filter button in table header
    And I select the column "Người dùng" in column dropdown list
    And I select the option "equals" in operator dropdown list
    And I enter the key word "abc" in value edit text
    And I click close button in filters box
    Then I will see value edit text is empty
    When I click close button in filters box
    And I click on the filter button in table header
    Then I will see the value of the column dropdown list as "Stt"
    And I will see the value of the operator dropdown list as "contains"