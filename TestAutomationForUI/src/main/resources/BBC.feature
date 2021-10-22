Feature: BBC news site article tests
  As a User
  I want to test BBC news page articles
  So I will be sure contains right versions of articles

  Scenario:Check the name of the headline article against a specified value
    Given User opens BBC home page
    When User clicks News button
    Then User checks the name of headline article matches specific query

    Scenario:Check the name of the first search result page article against a specified value
      Given User opens BBC home page
      And User clicks News button
      When User input in search field category link of the headline article
      Then User checks that first article of search result matches specific value

  Scenario: Check that User cant submit question with blank input fields
    Given User opens BBC home page
    And User clicks News button
    And User clicks on the coronavirus button
    And User clicks Your coronavirus story button
    And User clicks ask your question link
    When User clicks submit button with blank input fields
    Then User checks that errors massages are displayed

  Scenario: Check that User cant submit question with unchecked radio button for terms of services but correct inputs
    Given User opens BBC home page
    And User clicks News button
    And User clicks on the coronavirus button
    And User clicks Your coronavirus story button
    And User clicks ask your question link
    When User clicks submit button with correct data in input fields but not checks radiobutton for terms of services
    Then User checks that errors massages are displayed

  Scenario: Check that User can submit question with checked radio button for terms of services and correct inputs
    Given User opens BBC home page
    And User clicks News button
    And User clicks on the coronavirus button
    And User clicks Your coronavirus story button
    And User clicks ask your question link
    When User clicks submit button with correct data in input fields but not checks radiobutton for terms of services
    And User clicks checkbox fort terms of services
    Then User checks that massage about question submit success displayed
