Feature: Validating Place APIs

@AddPlace @Regression
  Scenario Outline: Verify if place is being successfully addd using AddplaceAPI
    Given Add place Payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with "POST" http request
#this scenario can be any request either get post or etc 
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "getPlaceAPI"


Examples:
	|name 		|	language	| address 						|
	|AAhouse	|	English		|	world cross centre 	| #1st data set
#	|BBhouse	|japnies		|Sea cross center			|	#2nd data set
	
	
#data driven testing mechanism for API test using cucumber examples feature
#when we give the scenario outline insted of scenarion then cucumber will recognize there is some data/parameter which is passed in methods

@deletePlace @Regression
Scenario: Verify if delete Place functionality is working
	
		Given DeletePlace Payload
		When user calls "deletePlaceAPI" with "POST" http request
		Then the API call is success with status code 200
		And "status" in response body is "OK"