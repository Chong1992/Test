package com.rakuten.service;

import java.awt.List;
import java.io.IOException;
import java.util.HashSet;

public interface UploadCSV {
	
	public List loadSearchResults(String date);
	
	public List Coordinator(String link);
	
	public boolean OperatingDateValidator (HashSet<String> set);
	
	public boolean ShopRepetitionValidator (HashSet<String> set);
	
	public HashSet ContentCollector (String link) throws IOException;
}
