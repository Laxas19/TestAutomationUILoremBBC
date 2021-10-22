Feature: Lorem Ipsum right text generation tests
  As a User
  I want to test Lorem Ipsum main functionality
  So I will be sure site works correctly and generates right text

  Scenario: Check that first paragraph of russian Lorem Ipsum version contains specific word
    Given User opens main Lorem Ipsum page
    When User clicks on russian version of site
    Then First paragraph must contain specific word

  Scenario: Check that generated Lorem Ipsum starts from specific sentence
    Given User opens main Lorem Ipsum page
    When User clicks generate Lorem Ipsum button
    Then User verify that first sentence of generated paragraph must be equal to specific value

  Scenario: Check that generated Lorem Ipsum with not toggled  start with Lorem checkbox not starts from specific sentence
    Given User opens main Lorem Ipsum page
    And User uncheck start with Lorem Ipsum checkbox
    When User clicks generate Lorem Ipsum button
    Then User verify that first sentence of generated paragraph must be not equal to specific value

  Scenario: Check that generated Lorem Ipsum paragraphs contains word lorem with probability
    Given User opens main Lorem Ipsum page
    When User clicks generate Lorem Ipsum button
    Then User checks that average amount of paragraphs more then 2

  Scenario Outline: Check that generated Lorem Ipsum consists from right amount of words
    Given User opens main Lorem Ipsum page
    And User clicks words radiobutton
    When User inputs '<amount>' of words to generate
    And User clicks generate Lorem Ipsum button
    Then User checks amount of words equals to '<value>'
    Examples:
      | amount | value |
      | 5      | 5     |
      | 20     | 20    |
      | 0      | 5     |
      | -1     | 5     |






