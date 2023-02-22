@Datastructure
Feature: launching dsalgo application load Datastructure page

@TestSuit_Datastructure_01
Scenario: navigate to Time complexity from signin
Given user is in Datastructure  page after logged in
When user clicks "Time complexity" button datastu
Then user should be redirected to Time complexity pagedatastu

@TestSuit_Datastructure_02
Scenario: navigate to Time complexity and practice question page	
Given user is in Time complexity page after logged in
When user clicks "Try Here" button in Time complexity page
Then user displayed with a page have an tryEditor with a Run button to test and navigate to practice question page