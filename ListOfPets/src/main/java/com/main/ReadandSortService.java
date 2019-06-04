package com.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;

import com.beans.Pets;

public class ReadandSortService {
public void readJsonFromURL(URL url)
{
	final String petType="Cat";
	String jsonArrayString="";
	JSONArray petsjsonArrayMale=null;
	JSONArray petsjsonArrayFemale=null;
	List<Pets> pet_array_Male=new ArrayList<Pets>();
	List<Pets> pet_array_Female=new ArrayList<Pets>();
	Pets pets=null;
	
	try
	{
//		Consume the Jsonarray from the given url into a string
		InputStreamReader is= new InputStreamReader(url.openStream());
		BufferedReader br = new BufferedReader(is);

		String tempstr;
		while (null != (tempstr = br.readLine())) {
		jsonArrayString= tempstr;
		}
		
//		creating json array from the String
		JSONArray jsonArray = new JSONArray(jsonArrayString);
		
//		Iterate over jsonarray to get the jsonobjects
		for (int i = 0; i < jsonArray.length(); i++) {
			
//			filtering the jsonobjects based on gender
			
			if(jsonArray.getJSONObject(i).getString("gender").equals("Male") )//& !(jsonArray.getJSONObject(i).get("pets").equals(null)))
			{
//				filter again to eliminate null values and get the pets as a jsonarray 
				if(!(jsonArray.getJSONObject(i).get("pets").equals(null)))
				{
				petsjsonArrayMale=(JSONArray)jsonArray.getJSONObject(i).get("pets");
//				Looping through the filtered jsonarray to get a list of pets of specific type
				for(int b=0;b<petsjsonArrayMale.length();b++)
				{
					 pets= new Pets();
					 String type=petsjsonArrayMale.getJSONObject(b).getString("type");
					 if(type.equals(petType))
							 {
							pets.setName(petsjsonArrayMale.getJSONObject(b).getString("name"));
							pets.setType(petsjsonArrayMale.getJSONObject(b).getString("type"));
							pet_array_Male.add(pets);
							 }
					 
					
				}
				}
			}
			else if(jsonArray.getJSONObject(i).getString("gender").equals("Female")&& !(jsonArray.getJSONObject(i).get("pets").equals(null)))
			{
				petsjsonArrayFemale=(JSONArray)jsonArray.getJSONObject(i).get("pets");
				for(int b=0;b<petsjsonArrayFemale.length();b++)
				{
					 pets= new Pets();
					 String type=petsjsonArrayFemale.getJSONObject(b).getString("type");
					 if(type.equals(petType))
							 {
							pets.setName(petsjsonArrayFemale.getJSONObject(b).getString("name"));
							pets.setType(petsjsonArrayFemale.getJSONObject(b).getString("type"));
							pet_array_Female.add(pets);
							 }
					 
				}
			}
		
			}
		 System.out.println("OUTPUT");
		 System.out.println("-------------------------------------------------------------");
		 System.out.println("pets of Male Owners:"+pet_array_Male.size()+"\n");
		 doSortCatsByName(pet_array_Male);
		 System.out.println("-------------------------------------------------------------");
		 System.out.println("pets of Female Owners:"+pet_array_Female.size()+"\n");
		 doSortCatsByName(pet_array_Female);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}

public void doSortCatsByName(List<Pets> pet_array_to_sort)
{
	Collections.sort(pet_array_to_sort, new Comparator<Pets>() {
	    public int compare(Pets p1, Pets p2) {
	    	return p1.getName().compareTo(p2.getName());

	    }
	});
	
	for(Pets pets:pet_array_to_sort)
	{
		System.out.println(pets);
	}
}
}
