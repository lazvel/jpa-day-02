package com.engineering.jpaday02task1;

import java.util.List;

import javax.persistence.Persistence;

import com.engineering.jpaday02task1.entity.City;
import com.engineering.jpaday02task1.entity.Contact;
import com.engineering.jpaday02task1.entity.ContactType;
import com.engineering.jpaday02task1.entity.Hobby;
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
		//start.savePersonWithContact();
		
		//start.personDelete();
		//start.savePersonWithContactBidirectional();
		
		start.personSaveOrUpdateWithHobby();
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
		city.setId(2L);
		List<Person> persons = personService.findByCity(city);
		for (Person person : persons) {
			System.out.println(person);
			for (Contact contact : person.getContacts()) {
				System.out.println("\t" + contact);
			}
		}
	}
	
	private void savePersonWithContact() {
		City city = new City();
		city.setId(2L);
		
		Person person = new Person();
		person.setId(null); // nova je osoba
		person.setFirstName("Laz");
		person.setLastName("Vel");
		person.setPersonalIdentityNumber("5553333122121");
		
		person.setBornCity(city);
		
//		person.getContacts().add(new Contact(null, ContactType.ADDRESS, "ul. Topolska 18", null));
//		person.getContacts().add(new Contact(null, ContactType.EMAIL, "lazvel@gmail.com", null));
//		person.getContacts().add(new Contact(null, ContactType.PHONE, "+38162555333", null));
//		person.getContacts().add(new Contact(null, ContactType.PHONE, "+38111555333", null));
		
		try {
			person = personService.saveOrUpdate(person);
			System.out.println(person);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private void savePersonWithContactBidirectional() {
		City city = new City();
		city.setId(2L);
		
		Person person = new Person();
		person.setId(null);
		person.setFirstName("Jok");
		person.setLastName("Ic");
		person.setPersonalIdentityNumber("11112222");
		
		person.setBornCity(city);
		
		person.addContact(new Contact(null, ContactType.ADDRESS, "bidirekciona 1"));
		person.addContact(new Contact(null, ContactType.PHONE, "011 212 321"));
		person.addContact(new Contact(null, ContactType.PHONE, "062 212 321"));
		
		try {
			person = personService.saveOrUpdate(person);
			System.out.println(person);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private void personSaveOrUpdateWithHobby() {
		City city = new City();
		city.setId(2L);
		
		Person person = new Person();
		person.setId(null);
		person.setFirstName("Zozi");
		person.setLastName("Zox");
		person.setPersonalIdentityNumber("1234567");
		
		person.setBornCity(city);
		
		// novo za hobby
		person.addHobby(new Hobby(null, "Sport"));
		person.addHobby(new Hobby(null, "Kuvanje"));
		
		
		try {
			person = personService.saveOrUpdate(person);
			System.out.println(person);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private void personDelete() {
		Person person = new Person();
		person.setId(3L);
		try {
			personService.delete(person);
			System.out.println("Osoba je obrisana");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
