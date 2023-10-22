Feature: See Product Detail

  @DetailProduct
  Scenario: Success to see product detail
    Given User already login for detail
    When User click product item
    Then User is on product detail