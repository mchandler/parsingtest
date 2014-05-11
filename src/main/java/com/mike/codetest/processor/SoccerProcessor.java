package com.mike.codetest.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SoccerProcessor extends Processor {

	private Map<String, Integer> teams = new HashMap<String, Integer>();
	
	@Override
	public Object getResults() {
		String team = "";
		int minValue = Collections.min(teams.values());
		
		for (Map.Entry<String, Integer> teamEntry : teams.entrySet()) {
			if (minValue == teamEntry.getValue()) {
				team = teamEntry.getKey();
			}
		}
		
		return team;
	}

	@Override
	public int getDiff(ArrayList<String> elements) {
		return Math.abs(val(elements.get(6)) - val(elements.get(7)));
	}

	@Override
	public void calculateResults(int diff, ArrayList<String> myElements) {
		teams.put(myElements.get(1), diff);
	}

}
