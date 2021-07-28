Feature: SalesForce login Functionality

#Background:
#Given Launch the ChromeBworser 
#Given Load SFDC URL

Scenario: TC_SFDC Login using Positive credendial

Given Enter userName as 'mercury.bootcamp@testleaf.com'
Given Enter Password as 'Bootcamp@123'
When Click Loging button
Then Validate HomePage

Scenario Outline: TC_SFDC Login using Negative credendial

Given Enter userName as <userName>
Given Enter Password as <password>
When Click Loging button
Then Validate LoginPage

Examples:
|userName|password|
|'mercury.bootcamp'|'Boot'|
|'TestLeaf'|'TestLeaf'|