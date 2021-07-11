Feature: Add Location Functionality

#Background:
#Given Launch the ChromeBworser 
#Given Load SFDC URL

Scenario: TC_SFDC Add Location with valid Details

Given Click AppLauncher Icon
And Click ViewAll link
And Click on Locations link
And Click on New button
And Enter Location Name as 'TestLocationJul21'
And Select Location Type as 'Site'
And Enter External Referance as 'TestExtRefJul21'
When Click on Save button
Then Verify the Created Location as 'TestLocationJul21'