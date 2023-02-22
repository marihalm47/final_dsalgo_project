# Dsalgo_The-Xpathers

## Table of Contents
* [Introduction](#Introduction)
* [Tools and Technologies](#Tools-and-Technologies)
* [Framework](#Framework)
* [Struture of Project](#Struture-of-Project)
* [Reporting](#Reporting)

## Introduction:
* Numpy Ninja’s “Data Structures and Algorithms(Ds Algo)” Project is learning tool It provides an excellent guide to implement algorithms from scratch like Arrays, Linked lists, Stack, Queue, Tree, Graph algorithms in Python.The purpose of this project is to provide a resource for anyone looking to improve their understanding and implementation skills in these important computer science concepts.

## Tools and Technologies:
* This project is created with,
#### * Maven- Dependency Management
#### * Java- Programming Language
#### * Selenium Webdriver
#### * Cucumber with Pagefactory-BDD approach
#### * log4j - Logging
#### * Allure Report

## Framework
```mermaid
flowchart TD
    src-->test
    test-->driverFactory
    test-->pageObjects
    test-->runner
    test-->stepDefinition
    test-->utilities
    src-->resources
    resources-->config
    resources-->Exceldata
    resources-->features
    resources-->log4j
 ```
 ## Struture of Project
 
 ### Feature Files
 A feature file is a file that lets you describe software’s behavior without detailing how that behavior is implemented. Feature files are written using the
 Gherkin language and must live in a folder named features within the root of your project.For Ex:
 ```
# ./features/sigin.feature

Feature: User to sigin 

  Scenario: User SignIn into Project
    Given User is in sigin page 
    When  User Enters Username valid Userid
    And   User Enters Password valid password
    And   User clicks on sigin button 
    Then  User Redirect to home Page

```
 ### Step Definition
 Step definitions act as the glue between features files and the actual system under test.When Cucumber executes a Gherkin step in a scenario, it will look for a matching step definition to execute. So, now when Cucumber executes a step of the scenario mentioned in the feature file, it scans the step definition file and figures out which function is to be called.
 
 ### Testrunner
 This dsalgo project is run by Testrunner file. The test runner file should contain the path of the feature file and step definition file that we want to execute.
 Right click the feature file and select "Run" or "Debug" to start the test.
Features will run in order :
1. Home.feature
2. Register.feature
3. Signin.feature
4. Array.feature
5. LinkedList.feature
6. Stack.feature
7. Queue.feature
8. Tree.feature
9. Graph.feature

## Reporting
Once tests complete run reports are generated. This framework uses different types of test reporters to communicate pass/failure.

**Allure Report**: 

Report will be generated into temp folder. Web server with results will start appearing in your default browser.it provides a good representation of test execution output and is designed to create reports that are clear to everyone by creating graphs regarding test execution time, overall test result overviews, test result history, etc. Web server with results will start appearing in your default browser.
```
$ cd <Project Directory>

$ allure serve allure-results
```

**HTML Report:**

To open an HTML report, from the Code Coverage Results view, right-click a result, and select Open as > HTML Report

**Log4j**
Log4j in selenium is one such logging framework that helps in gathering information in the form of logs or log files.In our project we used 3 main component of logger,appenders and layouts.Once execution is completed refresh the project where you see the log folder and it automatically contains the logs of your project

## Develop automation scripts using BDD approach - Cucumber-Java :
Tests are written in the Cucumber framework using the Gherkin Syntax. More about Gherkin & Cucumber can be found at [https://cucumber.io/docs/reference] 

## The Page Object Design Pattern (Selenium PageFactory) :
Page Object Model, also known as POM, is a design pattern,that creates an object repository for storing all web elements. It helps reduce code duplication and improves test case maintenance.
Page Object Model using Page Factory is implemented in Selenium automation frameworks. It helps in maintaining the test scripts by separating the test objects from the test scripts.
When A test fails due to selector that is no longer valid/have changed, and that selector may be used by many other steps.
By having all selectors at single place, fixing one selector on the page object could repair a number of failing tests that were affected by the same selector

## Data Driven Selenium Cucumber:
In our project we used Data driven methodology.Data driven testing means passing data with the help of  external sources like xls,xlsx,csv files., etc. In this we are taking inputs from external source.
 
