Feature: Product Search

<As a user><I want to able to search product>

    Scenario: Validate the Search results as per the inputs given
        Given User is on Landing Page
        And User enters the search keywords
        And User clicks on the search button
        Then user should see the search result


