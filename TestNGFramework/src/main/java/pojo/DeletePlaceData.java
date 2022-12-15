package pojo;

import pojo.DeletePlace;

public class DeletePlaceData  {
	
	public DeletePlace DeletePlacePayload(String place_id) {
	
		DeletePlace del = new DeletePlace();
		del.setPlace_id(place_id);
		return del;
	}
	
	

}
