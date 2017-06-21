package com.yue.spring.mvc.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller
public class PersonAction {
	@Resource
	private PersonService personService;
	
	public void savePerson(){
		this.personService.savePerson();
	}
	
	public void updatePerson(){
		this.personService.updatePerson();
	}
}
