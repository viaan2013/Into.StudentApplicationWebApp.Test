@AboutYou
Feature: UK-AboutYou

Scenario Outline:
Given I am in AboutYou session of UKapplicationform
When I enter "<Email>","<Firstname>","<Lastname>","<PhoneNumber>"
And I select "<date>","<Month>","<Year>"
And I select "<Gender>"gender
And I select"<Countryofnationality>"
And I select "<line1>","<line2>","<line3>","<town>","<city>","<state>","<zipcode>"
And I select "<country>" from dropdown
And I click on next button
Then I should see additional information session of application form

Examples:
|Email|Firstname|Lastname|PhoneNumber|date|Month|Year|Gender|Countryofnationality|line1|line2|line3|town|city|state|zipcode|country|
|sru@j.l|sru|@submit|645263426|21|September|1904|gender_f|Pakistan|brighton|surrey|college|brighton|UK|UK|5643564536|India|
|sru@c.o|sruthi|@sf|6452634264324|9|October|2000|gender_m|Egypt|sussex|surrey|threebridges|brighton|UK|USA|rh1 1hh|India|