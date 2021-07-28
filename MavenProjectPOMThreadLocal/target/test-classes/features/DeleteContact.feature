Feature: SFDC Delete Contact Functionality

Scenario Outline: TC_Delete Given Contact request

Given Enter userName as 'mercury.bootcamp@testleaf.com'
Given Enter Password as 'Bootcamp@123'
Given Click Loging button
Given Click AppLauncher Icon
And Click ViewAll link
And Click Contact Request link
And Click on Down icon for request as <ContactReq>
And Click on Delete Link
When Click on Delete Button

Examples:
|ContactReq|
|'00000040'|
|'00000041'|
