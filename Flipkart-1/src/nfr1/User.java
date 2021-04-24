package nfr1;

import java.util.UUID;

class User {

	String name;
	String gender;
	String preferredVaccineType;
	String id;
	Centre assignedCentre;
	
	public User(String name, String gender, String preferredVaccineType) {
		this.name = name;
		this.gender = gender;
		this.preferredVaccineType = preferredVaccineType;
		this.id=UUID.randomUUID().toString()+name+gender+preferredVaccineType;
		assignedCentre = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPreferredVaccineType() {
		return preferredVaccineType;
	}

	public void setPreferredVaccineType(String preferredVaccineType) {
		this.preferredVaccineType = preferredVaccineType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Centre getAssignedCentre() {
		return assignedCentre;
	}

	public void setAssignedCentre(Centre assignedCentre) {
		this.assignedCentre = assignedCentre;
	}

	
	
}
