package pojo;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class AddPlaceData {

	public AddPlace payload() throws Exception {

		/*
		 * DataDrivenUsingExcel data = new DataDrivenUsingExcel(); ArrayList arraylist =
		 * data.getExcelData("mapApi","Sheet3");
		 */

		AddPlace add = new AddPlace();
		/*
		 * add.setAccuracy(acc); add.setAddress(add2); add.setLanguage(lang);
		 * add.setPhone_number(phone); add.setWebsite(web); add.setName(name);
		 * 
		 * List<String> list = new ArrayList<String>(); list.add(type1);
		 * list.add(type2); add.setTypes(list);
		 * 
		 * Location loc = new Location(); loc.setLat(lat); loc.setLng(lng);
		 * 
		 * add.setLocation(loc);
		 */
		Location loc = new Location();
		loc.setLat(67);
		loc.setLng(90);

		add.setLocation(loc);
		add.setAccuracy(78);
		add.setName("Google");
		add.setPhone_number("9876543210");
		add.setAddress("Pune");
		add.setWebsite("https://www.google.co.in/");
		add.setLanguage("English");

		List<String> list = new ArrayList<String>();
		list.add("ass");
		list.add("sasa");
		add.setTypes(list);


		return add;

	}

}
