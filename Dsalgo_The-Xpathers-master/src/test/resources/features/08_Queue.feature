@QueueSuite
Feature: User to sign in the dsalgo application and test Queue page

@TestDemo_Queue_01
  Scenario: user is logged in into the dsalgo project to test Queue page
    Given user is logged into the home page
    When  user clicks on get started button or dropdown for queue
    Then  user directed to the queue page
    
@TestSuite_queue_02
	Scenario: The user is able to navigate to Implementation of Queue in Python link page
		Given The user in queue page
		When user clicks on Implementation of Queue in Python link page
		Then user should be directed to Implementation of Queue in Python link page

@TestSuite_queue_03
	Scenario Outline: The user should be directed to editor page with run button to test python code
		Given The user is in Implementation of queue in python link page
		When The user clicks on Tryhere link for Implementation of queue in python
		Then The user navigates to Editor page to enter valid python code for Implementation of queue in python
		And user clicks on the run button for Implementation of queue in python
		Then The user is presented with the result after run button is clicked for Implementation of queue in python

@TestSuite_queue_04     
 Scenario Outline: The user is presented with error message for invalid code in Editor for Implementation of queue page
    Given The user is in a page having an Editor with a Run button to test for Implementation of queue in python
    When The user enters invalid python code for Implementation of queue in python  
    And clicks run button for Implementation of queue
    Then The user gets an error message for Implementation of queue
    
@TestSuite_queue_05
	Scenario: The user is able to navigate to queue page and click on Implementation using collections deque link
		Given User in editor page and navigates to the queue page for Implementation using collections deque link
		When User clicks on Implementation using collections deque link
		Then User should be redirected to Implementation using collections deque page 

@TestSuite_queue_06
	Scenario Outline: The user should be directed to editor page with run button to test python code from Implementation using collections delque link
		Given User in implementation using collections page
		When User clicks on Tryhere link for collections page
		Then User navigates to Editor page to enter valid python code for collections page 
		And User clicks on the run button for collections page
		Then The user is presented with the result after run button is clicked for collections page
 
 @TestSuite_queue_07     
 	Scenario Outline: The user is presented with error message for invalid code in Editor for Implementation using collections page
    Given User is in a page having an Editor with a Run button to test for collection page
    When User enters invalid python code in Editor for collections page 
    And clicks run button for collection page link
    Then The user gets an error message for collection page
   
 @TestSuite_queue_08
	Scenario: User is able to navigate to queue page and click on Implementation using array link
		Given User in editor page and navigates to the queue page for Implementation using array link
		When The user clicks on Implementation using array link
		Then The user should be redirected to Implementation using array page

 @TestSuite_queue_09
	Scenario: User should be directed to editor page with run button to test python code from Implementation using array link
		Given User in Implementation using array link
		When User clicks on Tryhere link from Implementation using array link
		Then User navigates to Editor page to enter valid python code for array link
		And User clicks on the run button for array link
		Then User is presented with the result after run button is clicked for array link
		
@TestSuite_queue_10     
 Scenario Outline: The User is presented with error message for invalid code in Editor for Implementation using array page
    Given User is in a page having an Editor with a Run button to test for array page
    When User enters invalid python code in Editor for array page.
    And clicks run button for array page
    Then The user gets an error message for array page

@TestSuite_queue_11
	Scenario: User is able to navigate to queue page and click on Queue Operations link
	 Given User in editor page and navigates to the queue page for Queue Operations link
	 When The user clicks on Queue Operations link
	 Then The user should be redirected to Queue Operations page

@TestSuite_queue_12
	Scenario Outline: The user should be directed to editor page with run button to test python code from Queue Operations link
		Given User in Queue Operations link
		When User clicks on Tryhere link from Queue Operations link
		Then User navigates to Editor page to enter valid python code for Queue Operations link
		And User clicks on the run button for Queue Operations link
		Then User is presented with the result after run button is clicked for Queue Operations link
      
@TestSuite_queue_13    
	Scenario Outline: The User is presented with error message for invalid code in Editor for Queue Operations page
    Given User is in a page having an Editor with a Run button to test for Queue Operations page
    When User enters invalid python code in Editor for Queue Operations page
    And clicks run button for Queue Operations page
    Then The user gets an error message for Queue Operations page
    
@TestSuite_queue_14
Scenario: User is able to navigate to Queue page and click on Practice Questions
 Given User is in Editor page and navigates to Queue operation page
 When User clicks on Practice Questions
 Then User is directed to Practice page