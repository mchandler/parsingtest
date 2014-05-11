package com.mike.codetest.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WeatherResponse {
	
	private int dayNumber;
	
	public WeatherResponse() {}
	
	public WeatherResponse(int dayNumber) {
		this.dayNumber = dayNumber;
	}

	public int getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}
	
}
