Feature: Functions in the bottom bar

    Scenario: Verify that the bottom bar shows all the tabs
        Given I open Flook application
        Then I will see the bottom bar showing all the tabs

    Scenario: Verify that the tabs on the bottom bar navigate to the correct page
        Given I open Flook application
        When I click on the "Tủ sách" tab
        Then I will see the app navigate to the "Tủ sách" screen
        When I click on the "Diễn đàn" tab
        Then I will see the app navigate to the "Diễn đàn" screen
        When I click on the "Thông báo" tab
        Then I will see the app navigate to the "Thông báo" screen
        When I click on the "Cá nhân" tab
        Then I will see the app navigate to the "Cá nhân" screen