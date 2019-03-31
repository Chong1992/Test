package com.rakuten.serviceImpl;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import com.rakuten.service.UploadCSV;

public class UploadCSVImpl implements UploadCSV {

	@Override
	public List Coordinator(String link){
		// receives a link from UI
		
		boolean dateCheck;
		boolean shopNameCheck;
		
		UploadCSV uploadCSVImpl = new UploadCSVImpl();
		try {
		HashSet<String> fileContent =uploadCSVImpl.ContentCollector(link);
		
		dateCheck = uploadCSVImpl.OperatingDateValidator(fileContent);
		
		shopNameCheck = uploadCSVImpl.ShopRepetitionValidator(fileContent);
		
		// When both checkers are true, return the list to continue with the pageload
		if (dateCheck && shopNameCheck){
			List <String> list = new <String> ArrayList(fileContent);
			return list;
		}
		
		// The below determines which exception to throw when upload fails
		else if (!dateCheck){
			throw new exception ("One of the end date is earlier than start date");
		}
		else if (!shopNameCheck){
			throw new exception ("Repeated shop names found");
		}
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	
	@Override
	public boolean OperatingDateValidator (HashSet<String> set){
		
		String[] array = null;
		
		for (String s : set){
			array = s.split(",");
			// basically the end date cannot be smaller value than the start date , going by the format given 
			// the moment one of it fails, the check fails
			if ((Integer.parseInt(array[2])-Integer.parseInt(array[1]))<0){
				return false;
			}
			
		}
		
		
		
		return true;
		
	}
	
	
	@Override
	public boolean ShopRepetitionValidator (HashSet<String> set){
		
		
		int count=0;
		String[] array = null;
		HashSet<String> shopNames = new HashSet<String>(); // to store all the shopnames
		
		for (String s : set){
			array = s.split(",");
			shopNames.add(array[0]); //collecting just the shopname
		}
		String[] shopNameArray = new String[shopNames.size()];
		
		shopNames.toArray(shopNameArray);
		
		for (int i=0; i<shopNameArray.length;i++){
			for (int y=0; y<shopNameArray.length;y++){
				if (shopNameArray[i].equals(shopNameArray[y])){
					count++; // to check the number of times the name matches against the whole array, by rigth should only be once...
				}
			}
		}
		
		if (count>1){
			return false;
		}		
		else
		return true;
		
	}
	
	
	@Override
	public HashSet<String> ContentCollector (String link) throws IOException{
		HashSet<String> set = new HashSet<String>();
		
		String []Content1;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(link));
			String line = null;
			int i=0;
			while((line = reader.readLine())!=null){
				set.add(line);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return set;
		
	}


	@Override
	public List loadSearchResults(String date) {
		// TODO Auto-generated method stub
		// Basically there will be a DAO layer helping us obtain all the shops with their start and end date in an array
		List list = new List(); // List of shops opened on the date
		String[] array = null; // lets take this as the array obtained
		String[] array1 = null;
		for (int i=0; i<array.length;i++){
			array1 = array[i].split(",");
		if (Integer.parseInt(date) > Integer.parseInt(array1[1]) && Integer.parseInt(date) < Integer.parseInt(array1[2])){
				list.add(array1[0]);
			}
		}
		
		return list;
	}

}
