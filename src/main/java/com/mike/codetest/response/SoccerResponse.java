package com.mike.codetest.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SoccerResponse {
	
	private String teamName;

	public SoccerResponse() {}
	
	public SoccerResponse(String teamName) {
		this.teamName = teamName;
	}
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
