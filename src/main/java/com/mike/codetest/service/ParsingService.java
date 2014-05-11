package com.mike.codetest.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mike.codetest.processor.SoccerProcessor;
import com.mike.codetest.processor.WeatherProcessor;
import com.mike.codetest.response.SoccerResponse;
import com.mike.codetest.response.WeatherResponse;

public class ParsingService {
	
	public WeatherResponse parseWeather() {
		List<List<String>> data = parse(getWeatherData(), 4);
		WeatherProcessor processor = new WeatherProcessor();
		processor.process(data, 3);
		int day = (Integer) processor.getResults();
		
		return new WeatherResponse(day);
	}
	
	public SoccerResponse parseSoccer() {
		List<List<String>> data = parse(getSoccerData(), 9);
		SoccerProcessor processor = new SoccerProcessor();
		processor.process(data, 8);
		String team = (String) processor.getResults();
		
		return new SoccerResponse(team);
	}
	
	private String getWeatherData() {
		return getFileContent("/w_data.dat");
	}
	
	private String getSoccerData() {
		return getFileContent("/soccer.dat");
	}
	
	private List<List<String>> parse(String content, int breakAt) {
		Scanner scanner = new Scanner(content);
		List<List<String>> data = new ArrayList<List<String>>();
		
		while (scanner.hasNextLine()) {
			String thisLine = scanner.nextLine();
			
			if (thisLine.trim().length() > 0) {
				Scanner elementScanner = new Scanner(thisLine);
				elementScanner.useDelimiter("\\W"); // whitespace delimiter - that's not nice!
				
				int pos = 1;
				List<String> dataElements = new ArrayList<String>();
				
				while (elementScanner.hasNext()) {
					String element = elementScanner.next();
					
					if (element.trim().length() == 0) continue;
					
					dataElements.add(element);
					pos++;
					
					if (pos == breakAt) break; // break early if I don't need the rest
				}
				
				data.add(dataElements);
			}
			
		}
		
		return data;
	}
	
	private String getFileContent(String fileName) {
		InputStream stream = ParsingService.class.getResourceAsStream(fileName);
		String fileString = new Scanner(stream,"UTF-8").useDelimiter("\\A").next();
		return fileString;
	}
	
}
