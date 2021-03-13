Feature: Smoke
  As a user
  I want to test all main site`s functional
  So that i can be sure that site works correctly

  Scenario Outline: checkAddingProductToWishlist
    Given User opens '<homepage>'
    And User makes search by keyword '<keyword>'
    When User clicks on first wishlist button
    And User go to wishlist
    Then User checks that the product is on the wishlist
    Examples:
      | homepage                | keyword     |
      | https://www.asos.com/ | ASOS DESIGN |

  Scenario Outline: checkDeletingProductFromWishlist
    Given User opens '<homepage>'
    And User makes search by keyword '<keyword>'
    When User clicks on first wishlist button
    And User go to wishlist
    Then User checks that the product is on the wishlist
    And User delete item from wishlist
    And User checks that item has been deleted from wishlist

    Examples:
      | homepage                | keyword     |
      | https://www.asos.com/ | oversized |

    Scenario Outline: checkAddingToCart
      Given User opens '<homepage>'
      And User clicks on women category button
      And User clicks on shopNow button
      And User clicks on first product in list
      And User chooses product`s size
      When User clicks on add to bag button
      Then User checks if quantity of products in the cart is correct
      Examples:
        | homepage |
|       https://www.asos.com/   |