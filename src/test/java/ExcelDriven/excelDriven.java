package ExcelDriven;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class excelDriven {
	
	 	@Test
		public void AddBookAPI() throws IOException
		
		{
	 		
	 		dataDriven d= new dataDriven();
	 		ArrayList<String> data = d.getData("RestAddBook", "RestAssured");
	 		
	 		Map<String, Object>  jsonAsMap = new HashMap<>();   
	 		jsonAsMap.put("name", data.get(1));
	 		jsonAsMap.put("isbn", data.get(2));
	 		jsonAsMap.put("aisle", data.get(3));
	 		jsonAsMap.put("author", data.get(4));
	 		
	 		
	 		// if we have an nested json then we need to create 2 objects of hasmap
	 		// for example below is the json for refernece
	 	/*	{
	 			  "location": {
	 			    "lat": -38.383494,
	 			    "lng": 33.427362
	 			  },
	 		Map<String, Object> jsonmap2 = new HashMap<>();
	 		jsonAsMap.put("lat", "12");
	 		jsonAsMap.put("long", "34");
	 		jsonAsMap.put("loation", jsonmap2); 	*/
	 		
	 		
			RestAssured.baseURI = "http://216.10.245.166";
		String resp =	given().log().all().queryParam("key", "qaclick123").header("content-type","application/json")
			.body(jsonAsMap)
			.when().post("/Library/Addbook.php").then().log().all()
			.assertThat().statusCode(200).extract().response().asString();
		
			JsonPath js = new JsonPath(resp);
			String msgID = js.get("ID");
			System.out.println(msgID);
		}
}
