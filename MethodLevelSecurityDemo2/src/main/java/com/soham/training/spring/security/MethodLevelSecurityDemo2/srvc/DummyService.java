package com.soham.training.spring.security.MethodLevelSecurityDemo2.srvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

@Service
public class DummyService {

	@PreAuthorize(value="hasRole('ADMIN')")
	public void doSomeAdminWork() {
		System.out.println("DummyService.doSomeAdminWork()->VERY Critical and sensitive task"+new Date());
		
	}
	@PreAuthorize("#city==authentication.principal.username")
	public void domeSomethingElse(String city) {
		System.out.println("DummyService.domeSomethingElse()");
	}
	
	@PostAuthorize("returnObject %2 ==0")
	public int sillyRandom() {
		int r=(int)(Math.random()*1000);
		System.out.println("DummyService.sillyRandom()"+r);
		return r;
	}
	
	@PreFilter("filterObject != 'thu'")
	public List<String> getOtherDays(List<String> x){
		return x;
	}
	
	public List<DTO_Day> getAllDaysAsObjects(){
		List<DTO_Day> al=new ArrayList<>();
		al.add(new DTO_Day("Sun",1));
		;
		al.add(new DTO_Day("Sat",7));
		al.add(new DTO_Day("Mon",2));
		al.add(new DTO_Day("Tues",3));
		al.add(new DTO_Day("Wed",4));
		al.add(new DTO_Day("Thu",5));
		al.add(new DTO_Day("Fri",6));
		return al;
	}
	@PreFilter("filterObject.name!= 'Thu'")
	public String getAllOtherDaysAsObjects(List<DTO_Day> lstDays){
		StringBuffer sb=new StringBuffer();
		for(DTO_Day d:lstDays) {
			sb.append(d.getName()+"  , ");
		}
		return sb.toString();
	}
	
	public List<String> getAllDays(){
		List<String> al=new ArrayList<>();
		al.add("Sun")
		;
		al.add("Sat");
		al.add("Mon");
		al.add("Tues");
		al.add("Wed");
		al.add("thu");
		al.add("Fri");
		return al;
	}
}
