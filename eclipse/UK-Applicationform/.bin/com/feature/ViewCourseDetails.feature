Feature: View course details link

@CourseDetails
Scenario Outline: View course details link redirects to course details page
Given I am in CourseSelectorHomepage
When I Click and select "<country>"
And I enter subject in "<subject>" area
And I click on Add subject button
And I select "<level>"of study
And I should see Universities information which is "<optional>"
And I select "<University>" from list
And I click on Show courses button
Then I should see search results 
And I select and click on one of the courses view course details link
Then I should see "<course>" details page

Examples:
|country |subject|level        |optional|University   |course|
|gb      |social |Undergraduate|Yes     |uni-list-item|city-university-london|
|us      |science|Undergraduate|Yes    |uni-list-item|colorado-state-university|