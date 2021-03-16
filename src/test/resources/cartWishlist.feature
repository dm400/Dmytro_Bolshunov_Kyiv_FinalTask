Feature: CartAndWishlist
  As a user
  I want to test cart`s and wishlist`s functional
  So that i can be sure that site works correctly

  Scenario Outline: checkAddingProductToWishlist
    Given User opens '<homepage>'
    And User makes search by keyword '<keyword>'
    When User clicks on first wishlist button
    And User go to wishlist
    Then User checks that the product is on the wishlist
    Examples:
      | homepage              | keyword     |
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
      | homepage              | keyword   |
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
      | homepage              |
      | https://www.asos.com/ |

  Scenario Outline: checkDeletingFromCart
    Given User opens '<homepage>'
    And User clicks on women category button
    And User clicks on shopNow button
    And User clicks on first product in list
    And User chooses product`s size
    When User clicks on add to bag button
    And User checks if quantity of products in the cart is correct
    Then User go to cart page
    And User delete item from cart
    And User checks product has been removed
    Examples:
      | homepage              |
      | https://www.asos.com/ |

  Scenario Outline: deleteFromCartUsingPopUpWindow
    Given User opens '<homepage>'
    And User makes search by keyword '<keyword>'
    And User clicks on first product in list
    And User chooses product`s size
    And User clicks on add to bag button
    And User checks if quantity of products in the cart is correct
    When User delete item from cart`s popup menu
    Then User checks product has been removed
    Examples:
      | homepage              | keyword |
      | https://www.asos.com/ | swoosh  |