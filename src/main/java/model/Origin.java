package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Origin{

	@JsonProperty("name")
	private String name;

	@JsonProperty("url")
	private String url;

	public String getName(){
		return name;
	}

	public String getUrl(){
		return url;
	}
}