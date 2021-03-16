Feature: SearchSortFilter
  As a user
  I want to test search, filter, sort functional
  So that i can be sure that site works correctly

  Scenario Outline: checkSearchReturnCorrectResults
    Given User opens '<homepage>'
    When User makes search by keyword '<keyword>'
    Then User checks that search results are correct
    Examples:
      | homepage              | keyword |
      | https://www.asos.com/ | Air     |

  Scenario Outline: checkCorrectDescendingSort
    Given User opens '<homepage>'
    And User clicks on men`s category button
    And User clicks on first shopNow button
    When User clicks on sort button
    And User clicks on descending item of sort menu
    Then User checks that sorting function works correctly

    Examples:
      | homepage              |
      | https://www.asos.com/ |