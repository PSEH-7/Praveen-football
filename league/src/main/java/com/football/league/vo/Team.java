package com.football.league.vo;

public class Team {

	int id;
    String name;
    Country country;
    int position;
    
    
	public Team(int id, String name, Country country, int position) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.position = position;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
    
    
	
}
