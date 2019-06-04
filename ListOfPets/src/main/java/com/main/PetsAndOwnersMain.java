package com.main;

import java.net.MalformedURLException;
import java.net.URL;



public class PetsAndOwnersMain {

	public static void main(String[] args) throws MalformedURLException {
		URL url=new URL("http://agl-developer-test.azurewebsites.net/people.json");
		
		ReadandSortService readandSortService = new ReadandSortService();
		readandSortService.readJsonFromURL(url);
		
	}
}
