Feature: Add Produce To Cart

  @AddToCart
  Scenario: Success Add Product to Cart
    Given User already login
    When User click add to cart button
    Then Product added to cart