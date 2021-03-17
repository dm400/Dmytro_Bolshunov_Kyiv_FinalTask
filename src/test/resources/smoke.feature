Feature: Smoke
  As a user
  I want to main functional
  So that i can be sure that site works correctly

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

  Scenario Outline: checkSearchReturnCorrectResults
    Given User opens '<homepage>'
    When User makes search by keyword '<keyword>'
    Then User checks that search results are correct
    Examples:
      | homepage              | keyword |
      | https://www.asos.com/ | Air     |

    Scenario Outline: checkIfFilterBySizeWorksCorrectly
    Given User opens '<homepage>'
    And User clicks on men`s category button
    And User clicks on first shopNow button
    When User clicks on Size button
    And User clicks on size menu item
    And User clicks on Size button
    And User clicks on first product in list
    Then User checks that filter works correctly
    Examples:
      | homepage              | keyword |
      | https://www.asos.com/ | shirt   |

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

  Scenario Outline: inputIncorrectDataIntoLoginAndPasswordFields
    Given User opens '<homepage>'
    And User hover over Account icon
    And User go to Sign in screen
    When User clicks on SignIn Button
    Then User checks empty fields warnings
    And User checks button sign in is disabled
    Examples:
      | homepage              |
      | https://www.asos.com/ |

  Scenario Outline: checkIfUrlContainsSearchText
    Given User opens '<homepage>'
    When User makes search by keyword '<keyword>'
    Then User checks that url contains '<keyword>' search text
    Examples:
      | homepage              | keyword |
      | https://www.asos.com/ | nike    |
