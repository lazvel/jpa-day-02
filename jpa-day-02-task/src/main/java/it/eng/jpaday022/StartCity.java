package it.eng.jpaday022;

import javax.persistence.Persistence;

import it.eng.jpaday022.entity.City;
import it.eng.jpaday022.service.CityService;

public class StartCity {
	private final CityService cityService;
	
	public StartCity() {
		cityService = new CityService(Persistence.createEntityManagerFactory("BiloSta"));
	}
	
    public static void main(String[] args ){
    	StartCity startCity = new StartCity();
    	startCity.save(11000L, "Beograd");
    }

	private void save(long number, String name) {
		try {
			cityService.save(new City(number, name));
			System.out.println("Uspesno sacuvan grad");
		} catch (Exception e) {
			System.out.println("MAIN: greska: " + e.getMessage());
		}
	}
}
