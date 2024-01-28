package resources;
// enum is a special class in java which has collection of constants or collection methods

public enum ApiResources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	
	ApiResources(String resource) {
		// TODO Auto-generated constructor stub
		this.resource=resource;
	}

	public String getResource()
	{
		return resource;
		
	}
	
}
