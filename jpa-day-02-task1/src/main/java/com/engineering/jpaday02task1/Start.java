package com.engineering.jpaday02task1;

import java.util.List;

import javax.persistence.Persistence;

import com.engineering.jpaday02task1.entity.City;
import com.engineering.jpaday02task1.entity.Person;
import com.engineering.jpaday02task1.service.CityService;
import com.engineering.jpaday02task1.service.PersonService;

public class Start {
	private final CityService cityService;
	private final PersonService personService;
	
	public Start() {
		cityService = new CityService(Persistence.createEntityManagerFactory("JPADay02"));
		personService = new PersonService(Persistence.createEntityManagerFactory("JPADay02"));
	}
	
	public static void main(String[] args) {
		Start start = new Start();
		//start.citySaveOrUpdate();
		//start.personSaveOrUpdate(); // ovaj metod prodji opet
		start.personFindByCity(); 
	}

	private void citySaveOrUpdate() {
		City city = new City();
		city.setId(null);
		city.setNumber(11000L);
		city.setName("Beograd");
		try {
			city = cityService.saveOrUpdate(city);
			System.out.println(city);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void personSaveOrUpdate() {
		Person person = new Person();
		City city = new City();
		city.setId(2L);
		person.setFirstName("Zozi");
		person.setLastName("Zox");
		person.setPersonalIdentityNumber("1212121212121");
		
		person.setBornCity(city);
		
		try {
			person = personService.saveOrUpdate(person);
			System.out.println(person);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private void personFindByCity() {
		City city = new City();
		city.setId(1L);
		//List<Person> persons = 
	}
}
