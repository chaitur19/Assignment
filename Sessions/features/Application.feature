Feature: HighChart Sessions Count
Scenario: Comparing Sessions Count

Given I launch highcharts homepage
When  I hover on Jan 5th 2018 sessions point
And   I Store sessions Count value
And   I click on Jan 5th 2018 sessions point
Then  I should see the same sessions count value