package com.football.league.vo;

import java.util.Set;

public class Leauge {
int id;
String name;
Set<Team> teams;


public Leauge(int id, String name, Set<Team> teams) {
	super();
	this.id = id;
	this.name = name;
	this.teams = teams;
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
public Set<Team> getTeams() {
	return teams;
}
public void setTeams(Set<Team> teams) {
	this.teams = teams;
}


}
