package com.football.league.service;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.databind.JsonNode;
import com.football.league.vo.ResponseObject;

@RestController
public class FootballLeagueService {
	public static final String TEAMS="teams";
	public static final String COUNTRY="country";
	
	 @GetMapping(value="country/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ResponseObject> getCountry(@PathVariable String name) {
		 
		 ClassLoader classLoader = getClass().getClassLoader();
		 File file = new File(classLoader.getResource("config.json").getFile());
		 System.out.println(file.toString());
		 ResponseObject objectRes ;
		 List<ResponseObject>  list = new ArrayList<>();
		 JSONParser parser = new JSONParser();
			try {
				Object obj = parser.parse(new FileReader(file));
	 
				
				JSONObject jsonObject = (JSONObject) obj;	
				JSONArray leaguesRoot = (JSONArray) jsonObject.get("leagues");	
				
				Iterator<JSONObject> leagues = leaguesRoot.iterator();
				
				while (leagues.hasNext()) {
					JSONObject league = leagues.next();
					
					
					JSONArray teamList = (JSONArray) league.get(TEAMS);	 
					Iterator<JSONObject> iterator = teamList.iterator();
					while (iterator.hasNext()) {
						objectRes = new ResponseObject();
						
						objectRes.setLeagueId(Integer.valueOf(league.get("id").toString()));
						objectRes.setLeagueName(league.get("name").toString());
						JSONObject team = iterator.next();
						objectRes.setTeamId(Integer.valueOf(team.get("id").toString()));
						objectRes.setTeamName(team.get("name").toString());
						objectRes.setPosition(Integer.valueOf(team.get("position").toString()));
						JSONObject country =(JSONObject) team.get(COUNTRY);	
						objectRes.setCountryId(Integer.valueOf(country.get("id").toString()));
						objectRes.setCountryName(country.get("name").toString());
						if(name.equals(country.get("name").toString())) {
						list.add(objectRes);
						}
					}
				}
					 
			
				
		 
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
    }

	 

	 @GetMapping(value="league/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ResponseObject> getLeauge(@PathVariable String name) {
		 
		 ClassLoader classLoader = getClass().getClassLoader();
		 File file = new File(classLoader.getResource("config.json").getFile());
		 System.out.println(file.toString());
		 ResponseObject objectRes ;
		 List<ResponseObject>  list = new ArrayList<>();
		 JSONParser parser = new JSONParser();
			try {
				Object obj = parser.parse(new FileReader(file));
	 
				
				JSONObject jsonObject = (JSONObject) obj;	
				JSONArray leaguesRoot = (JSONArray) jsonObject.get("leagues");	
				
				Iterator<JSONObject> leagues = leaguesRoot.iterator();
				
				while (leagues.hasNext()) {
					JSONObject league = leagues.next();
					
					
					JSONArray teamList = (JSONArray) league.get(TEAMS);	 
					Iterator<JSONObject> iterator = teamList.iterator();
					while (iterator.hasNext()) {
						objectRes = new ResponseObject();
						
						objectRes.setLeagueId(Integer.valueOf(league.get("id").toString()));
						objectRes.setLeagueName(league.get("name").toString());
						JSONObject team = iterator.next();
						objectRes.setTeamId(Integer.valueOf(team.get("id").toString()));
						objectRes.setTeamName(team.get("name").toString());
						objectRes.setPosition(Integer.valueOf(team.get("position").toString()));
						JSONObject country =(JSONObject) team.get(COUNTRY);	
						objectRes.setCountryId(Integer.valueOf(country.get("id").toString()));
						objectRes.setCountryName(country.get("name").toString());
						if(name.equals(league.get("name").toString())) {
						list.add(objectRes);
						}
					}
				}
					 
			
				
		 
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
    }
	 
	 @GetMapping(value="team/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<ResponseObject> getteam(@PathVariable String name) {
			 
			 ClassLoader classLoader = getClass().getClassLoader();
			 File file = new File(classLoader.getResource("config.json").getFile());
			 System.out.println(file.toString());
			 ResponseObject objectRes ;
			 List<ResponseObject>  list = new ArrayList<>();
			 JSONParser parser = new JSONParser();
				try {
					Object obj = parser.parse(new FileReader(file));
		 
					
					JSONObject jsonObject = (JSONObject) obj;	
					JSONArray leaguesRoot = (JSONArray) jsonObject.get("leagues");	
					
					Iterator<JSONObject> leagues = leaguesRoot.iterator();
					
					while (leagues.hasNext()) {
						JSONObject league = leagues.next();
						
						
						JSONArray teamList = (JSONArray) league.get(TEAMS);	 
						Iterator<JSONObject> iterator = teamList.iterator();
						while (iterator.hasNext()) {
							objectRes = new ResponseObject();
							
							objectRes.setLeagueId(Integer.valueOf(league.get("id").toString()));
							objectRes.setLeagueName(league.get("name").toString());
							JSONObject team = iterator.next();
							objectRes.setTeamId(Integer.valueOf(team.get("id").toString()));
							objectRes.setTeamName(team.get("name").toString());
							objectRes.setPosition(Integer.valueOf(team.get("position").toString()));
							JSONObject country =(JSONObject) team.get(COUNTRY);	
							objectRes.setCountryId(Integer.valueOf(country.get("id").toString()));
							objectRes.setCountryName(country.get("name").toString());
							if(name.equals(team.get("name").toString())) {
							list.add(objectRes);
							}
						}
					}
						 
				
					
			 
				}catch (Exception e) {
					e.printStackTrace();
				}
				return list;
	    }


}
