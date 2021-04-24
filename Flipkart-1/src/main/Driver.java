package main;

import java.io.*;
import java.util.*;

public class Driver {
	
	ArrayList<User> users;
	ArrayList<Centre> centres;

	public Driver() {
		this.users = new ArrayList<User>();
		this.centres = new ArrayList<Centre>();
	}
	
	public void register_user(User user) {
		users.add(user);
	}
	
	public void register_centre(Centre centre) {
		centres.add(centre);
	}
	
	public void getCentres(User user) {
		String preferredVaccineType = user.getPreferredVaccineType();
		ArrayList<Centre> orderedCentres = (ArrayList<Centre>)centres.clone();
		if(preferredVaccineType.equals("COVAX"))
			Collections.sort(orderedCentres, (a,b)->b.covaxQuantity-a.covaxQuantity);
		else
			Collections.sort(orderedCentres, (a,b)->b.covidshieldQuantity-a.covidshieldQuantity);
		
		for(Centre centre:orderedCentres) {
			if((preferredVaccineType.equals("COVAX") && centre.covaxQuantity<=0) || (preferredVaccineType.equals("COVIDSHIELD") && centre.covidshieldQuantity<=0))
				break;
			if(preferredVaccineType.equals("COVAX"))
				System.out.println(centre.getCentreId()+" COVAX="+centre.getCovaxQuantity());
			if(preferredVaccineType.equals("COVIDSHIELD"))
				System.out.println(centre.getCentreId()+" COVIDSHIELD="+centre.getCovidshieldQuantity());
		}
		
	}


	public boolean bookslot(User user, Centre centre) {
		if(user.preferredVaccineType.equals("COVAX") && centre.getCovaxQuantity()<=0)
			return false;
		else
			centre.setCovaxQuantity(centre.getCovaxQuantity()-1);
		if(user.preferredVaccineType.equals("COVIDSHIELD") && centre.getCovidshieldQuantity()<=0)
			return false;
		else
			centre.setCovidshieldQuantity(centre.getCovidshieldQuantity()-1);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		
		User User1 = new User("User1", "M", "COVAX");
		User User2 = new User("User2", "F", "COVIDSHIELD");
		
		Centre Centre1 = new Centre("Centre1", 1, 5);
		Centre Centre2 = new Centre("Centre2", 10, 0);
		
		driver.register_user(User1);
		driver.register_user(User2);
		
		driver.register_centre(Centre1);
		driver.register_centre(Centre2);
		
		driver.getCentres(User1);
		
		
		
		
		

	}
	
	

}
