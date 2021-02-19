package com.engineering.jpaday02task1;

import java.util.List;

import javax.persistence.Persistence;

import com.engineering.jpaday02task1.entity.City;
import com.engineering.jpaday02task1.entity.Contact;
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
		//start.personFindByCity(); 
		start.savePersonWithContact();
	}


	private void citySaveOrUpdate() {
		City city = new City();
		city.setId(2L);
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
	
	private void savePersonWithContact() {
		Person person = new Person();
		City city = new City();
		city.setId(2L);
		person.setFirstName("Laz");
		person.setLastName("Vel");
		person.setPersonalIdentityNumber("322222223");
		
		person.setBornCity(city);
		
		person.getContacts().add(new Contact("ll@gmail.com", "+381112233", "+38160555333", "eng.it", "linkedin.com/engit", "eng.it"));
		person.getContacts().add(new Contact("fon@fon.bg.ac.rs", "+38113211", "+38160333555", "fon.ac.rs", "linkedin.com/fon", "fon.bg"));
		
		try {
			person = personService.saveOrUpdate(person);
			System.out.println(person);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
