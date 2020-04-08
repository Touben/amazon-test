Feature: Amazon: User can search and access search results
    As a user
    I want to search items on Amazon and view results

Scenario: Second item is searched item
    Given Open Chrome and navigate to 'amazon.com'
    When Search Nikon and sort results from highest price to slowest
    When Select second product and click it for details
    Then From details verify that product topic contains text 'Nikon D3X'