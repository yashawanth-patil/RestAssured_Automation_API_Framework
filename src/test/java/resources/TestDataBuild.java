package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

// yashvanth
	
	public AddPlace addPlacePayload(String name, String language, String address) {
		
		AddPlace p = new AddPlace();
		p.setAccuracy(10);
		p.setName(name);
		p.setAddress(address);
		p.setPhone_number("(+91) 666 222 1111");
		p.setWebsite("ww.go.com");
		p.setLanguage(language);
// ***************************************************************************************************	
		List<String> myList = new ArrayList<String>();
		myList.add("show1");
		myList.add("show2");
		p.setTypes(myList);
// *************************************************************************************************	
		Location l = new Location();
		l.setLng(-00.383494);
		l.setLat(00.427362);
		p.setLocation(l);
		return p;
	}
	
	public String deletePlacePayload(String placeID) {
		
		return "{\"place_id\":\""+placeID+"\"}";
	}
}
