package StepDefinations;
//yashvanth
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.utils;

public class StepDefination extends utils {
	RequestSpecification res;
	ResponseSpecification respspec;
	Response response;
	static String place_id;

	TestDataBuild data = new TestDataBuild();

//	@Given("Add place Payload")
//	public void add_place_payload() throws IOException {
//		// Write code here that turns the phrase above into concrete actions
//		
//		// Request specification is calling frm the utils class file as this is the common values for every request
//		// the payload is calling from the testbuild class by extending it to the stepdefination class
//		res = given().spec(requestSpecification()).body(data.addPlacePayload()); 
//		
//	}
	
	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    
		res = given().spec(requestSpecification())
				.body(data.addPlacePayload(name,language,address));
	}

//	@When("user calls {string} with post http request")
//	public void user_calls_with_post_http_request(String resource )
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method)
	 {
	
		//When user calls "resource api" with "request method" http request
	//constructor will be called with value of resource which you pass in feature file which is mentioned above
		
		ApiResources resourceAPI = ApiResources.valueOf(resource);  // this is calling from the API Resoources enum class
		System.out.println(resourceAPI.getResource());
		
		respspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		response = res.when().post(resourceAPI.getResource()); // resource api is called from the enum class which is resource api
		if(method.equalsIgnoreCase("GET"))
			response = res.when().get(resourceAPI.getResource());
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is_ok(String keyValue, String ExpectedValue) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(getJsonPath(response, keyValue), ExpectedValue);
	}

	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
	    //
		//hit get api call
		place_id = getJsonPath(response, "place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource,"GET");
		String actualName = getJsonPath(response, "name");
		assertEquals(actualName, expectedName);
	}
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}
	
}
