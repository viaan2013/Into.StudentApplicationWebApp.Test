@courseselector
Feature: CourseSelector

Scenario Outline:
Given I am in CourseSelectorHomepage
When I Click and select "<country>"
And I enter subject in "<subject>" area
And I click on Add subject button
And I select "<level>"of study
And I should see Universities information which is "<optional>"
And I select "<University>" from list
And I click on Show courses button
Then I should see search results 
Examples:
|country|subject|level|optional|University|
|gb|social|Undergraduate|Yes|uni-list-item|
|us|science|Postgraduate|Yes|uni-list-item|