#Author: swastika.soumya@sunlife.com


@web @amazon
Feature: Amazon Home Page Exploratory Test Case
  

  @exploratory @homescreen @amazon 
  Scenario: Homescreen Test for Amazon
    Given User launches amazon.in
    And User verifies title of webpage
    #When User clicks on language selector and select "Hindi" Language
    #Then User quits the application
    
    
  #@exploratory @homedecorscreen @amazon 
  #Scenario: Homescreen Test for Amazon
    #Given User launches amazon.in
    #And User clicks on Explore All link for Revamp your home in style section
    #Then User verifies title of webpage

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
