package com.mike.codetest.processor;

import java.util.ArrayList;

public class WeatherProcessor extends Processor {

	private int maxSpread = 0;
	private int dayNumber = 0;
	
	@Override
	public Object getResults() {
		return dayNumber;
	}
	
	@Override
	public int getDiff(ArrayList<String> elements) {
		return Math.abs(val(elements.get(1)) - val(elements.get(2)));
	}
	
	@Override
	public void calculateResults(int diff, ArrayList<String> myElements) {
		if (diff > maxSpread) {
			maxSpread = diff;
			dayNumber = val(myElements.get(0));
		}
	}

}
