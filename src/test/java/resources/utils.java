package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class utils {
	
	public static RequestSpecification req;
	
	public RequestSpecification requestSpecification() throws IOException {
		
		 // to avoid the log file is replacing for every exection for multipe set of data 
			
//			The code checks whether the req (request specification) is null.
//			If req is null, it creates a new PrintStream named log that writes to a file named "Logging(req&resp).txt." This file will be used to log both request and response information.
//			A new RequestSpecBuilder is created to build a request specification.
//			The base URI is set using the getGlobalValue("baseUrl") method.
//			Query parameters are added to the request (e.g., "key" with the value "qaclick123").
//			Two logging filters (RequestLoggingFilter and ResponseLoggingFilter) are added to log the request and response, respectively, to the log PrintStream.
//			The content type of the request is set to JSON.
//			The request specification is built using the build() method.
//			The created request specification is assigned to the req variable.
//			The method returns the created request specification.
//			If the req is not null, it means that the request specification has already been created, and the existing req is returned without creating a new one.
		if(req==null)
		{
		// by this the file is created in the project that can be viewed, by refreshing the project
			
		PrintStream log = new PrintStream(new FileOutputStream("Logging(req&resp).txt")); // stream the logging the request and response in seperate file logging.txt
// this is not required 		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		 
		req	= new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				.addQueryParam("key","qaclick123")
				//for logging the request, filter we need to add below method
				.addFilter(RequestLoggingFilter.logRequestTo(log)) // created and printstream object for loging req and resp
				// for logging the response
				.addFilter(ResponseLoggingFilter.logResponseTo(log)) // by this the file is created in the project that can be viewed, by refreshing the project
				.setContentType(ContentType.JSON).build();
		
		return req;
	}
	return req;
	}
	
	
	// lets create to extrat the properties from global properties file which is base url
	
	public static String getGlobalValue(String key) throws IOException  // by this method as static so that it can be accesed to another method in the same class
	{
		Properties prop = new Properties();
		// get the file which is proesent in globalproperties file under resource package
		FileInputStream fis = new FileInputStream("Y:\\Yashvanth patil learnings\\Eclipse Workspace\\API_Framework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	public String getJsonPath(Response response, String key) {
		
		String responseValue = response.asString();
		JsonPath js = new JsonPath(responseValue);
		return js.get(key).toString();
		
	}
	
	
}
