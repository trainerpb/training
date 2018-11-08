package com.soham.training.spring.security.MethodLevelDemo1.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.soham.training.spring.security.MethodLevelDemo1.dto.DTO_Player;

@Service
public class Srvc_SomeService {

	@PreAuthorize(value = "hasRole('EMP')")
	public void doA() {
		Authentication authentication= SecurityContextHolder
				.getContext().getAuthentication();
		System.out.println("Srvc_SomeService.doA()" + new Date() + " " 
				+ authentication.getName()+" "
				+authentication.getPrincipal().toString()
				);
	}
	
	@PreAuthorize(value="#name==authentication.principal.username")
	public String getMyEmail(String name) {
		return "Email of "+name +" is xyz@gmail.com";
	}
	
	//@PostAuthorize(value="returnObject >=authentication.principal.username.length()")
	public int  getRandomNumber() {
		int a=(int)(Math.random()*1000) ;
		return a%8;
	}
	
	@PreFilter("filterObject != authentication.principal.username")
	public List<String> getUsers(List<String> users){
		return users;
	}
	public List<String> getUsres(){
		ArrayList<String> al=new ArrayList<>();
		al.add("rohit");
		al.add("virat");
		al.add("dhawan");
		al.add("dhoni");
		al.add("jadeja");
		return al;
	}
	
	public List<DTO_Player> getPlayers(){
		ArrayList<DTO_Player> al=new ArrayList<>();
		al.add(new DTO_Player("rohit", 200));
		al.add(new DTO_Player("virat", 180));
		al.add(new DTO_Player("dhawan", 100));
		al.add(new DTO_Player("jadeja", 78));
		al.add(new DTO_Player("dhoni", 86));
		
		return al;
	}
	
	@PreFilter("filterObject.name != authentication.principal.username")
	public List<DTO_Player> getOthers(List<DTO_Player> players){
		return players;
	}
	@PostFilter("filterObject.name==authentication.principal.username")
	public List<DTO_Player> getByRun(List<DTO_Player> players,int run) {
		return players.stream().filter(p->p.getRun()==run).collect(Collectors.toList());
	}
}
