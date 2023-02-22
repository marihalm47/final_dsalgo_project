@GraphSuite
Feature: User to sign in the dsalgo application and test Graph page

@TestDemo_Graph_01
  Scenario: user is logged in into the dsalgo project to test Graph page
    Given After signin user is in home page
    When  User clicks on get started button or dropdown for graph
    Then  user directed to the graph page

@TestDemo_Graph_02
	Scenario: User is able to navigate to graph page
		Given User in graph page
		When User clicks on graph link button
		Then User should be directed to graph link page
		
@TestDemo_Graph_03
	Scenario Outline: User should be directed to editor page with run button to test python code
		Given User is in graph link page
		When User clicks on Tryhere link for graph link page
		Then User navigates to Editor page to enter valid python code for graph link page
		And User clicks on the run button for graph link page
		Then User is presented with the result after run button is clicked for graph link page
		
@TestDemo_Graph_04    
 Scenario Outline: User is presented with error message for invalid code in Editor for graph link page
    Given User is in a page having an Editor with a Run button to test for graph link page
    When User enters invalid python code for graph link page  
    And clicks run button for graph link page
    Then The user gets an error message for graph link page
    
 @TestDemo_Graph_05
	Scenario: User is able to navigate to graph page and click on graph representations
		Given User in editor page and navigates to the graph page for graph representations
		When User clicks on graph representations link
		Then User should be redirected to graph representations
		
@TestDemo_Graph_06
	Scenario Outline: User should be directed to editor page with run button to test python code from graph representations
		Given User is in graph representations
		When User clicks on Tryhere link for graph representations
		Then User navigates to Editor page to enter valid python code for graph representations
		And User clicks on the run button for graph representations
		Then The user is presented with the result after run button is clicked for graph representations
		
@TestDemo_Graph_07     
 	Scenario Outline: The user is presented with error message for invalid code in Editor for graph representations
    Given User is in a page having an Editor with a Run button to test for graph representations
    When User enters invalid python code in Editor for graph representations
    And clicks run button for graph representations
    Then The user gets an error message for graph representations
    
 @TestDemo_Graph_08
Scenario: User is able to navigate tograph representations page and click on Practice Questions
 Given User is in Editor page and navigates to graph representations page
 When User clicks on Practice Questions from graph representations page
 Then User is directed to the Practice page
		
		