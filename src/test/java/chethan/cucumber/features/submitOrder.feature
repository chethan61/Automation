Feature: Purchase order in Ecommerce Application
  I want to use this template for my feature file

  Background: 
    Given I launch the application

  @tag2
  Scenario Outline: Submitting order in the Application
    Given I login with <username> and <password>
    When I check <product> and submit order
    Then I verify " Thankyou for the order. " message

    Examples: 
      | username            | password     | product         |
      | chethan1@gmail.com  | Chaithu@3    | ZARA COAT 3     |
      | chethan12@gmail.com | Chaithu@mpl4 | ADIDAS ORIGINAL |
