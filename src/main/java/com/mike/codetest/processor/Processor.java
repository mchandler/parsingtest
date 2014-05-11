package com.mike.codetest.processor;

import java.util.ArrayList;
import java.util.List;

public abstract class Processor {
	public abstract Object getResults();
	public abstract int getDiff(ArrayList<String> elements);
	public abstract void calculateResults(int diff, ArrayList<String> myElements);
	
	public void process(List<List<String>> data, int validSize) {
		processDataElements(data, validSize);
	}
	
	private void processDataElements(List<List<String>> data, int validSize) {
		for (List<String> elements : data) {
			if (elements.size() != validSize) continue;
			
			ArrayList<String> myElements = (ArrayList<String>) elements;
			
			boolean isValid = true;
			String element = myElements.get(0);
			
			// if our first element isn't an integer, let's move on
			try {
				Integer.parseInt(element);
			} catch (NumberFormatException e) {
				isValid = false;
			}
			
			if (!isValid) continue; // if we're not looking at valid data, move on
			
			int diff = getDiff(myElements);
			
			calculateResults(diff, myElements);
		}
	}
	
	// remove non numeric characters
	protected int val(String figure) {
		return Integer.parseInt(figure.replaceAll( "[^\\d]", ""));
	}
}
