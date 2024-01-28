package StepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@deletePlace")
	public void beforeScenario() throws IOException {
		
		// write a code to get place id
		// execute this when the place id is null
		StepDefination m = new StepDefination();
		if(StepDefination.place_id==null) // place is static so it is called from class name .method name
		{
		m.add_place_payload_with("shetty", "french", "asia");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		m.verify_place_id_created_maps_to_using("shetty", "getPlaceAPI");
	}
	}

}
