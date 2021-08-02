Feature: Sanity test by validating all the links present in the Webpage

#This is Sanity test to quickly validate all the links present in Webpage working fine and there should not be ant broken link

  Scenario: Validate the result of search is as per the input search string
	Given User is on Landing Page
    Then User is validating the broken links
