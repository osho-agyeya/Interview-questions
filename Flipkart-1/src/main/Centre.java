package main;

import java.util.ArrayList;

class Centre {
	
	String centreId;
	int covaxQuantity;
	int covidshieldQuantity;
	ArrayList<User> assignedUsers;
	
	public Centre(String centreId, int covaxQuantity, int covidshieldQuantity) {
		super();
		this.centreId = centreId;
		this.covaxQuantity = covaxQuantity;
		this.covidshieldQuantity = covidshieldQuantity;
		this.assignedUsers = new ArrayList<User>();
	}

	public String getCentreId() {
		return centreId;
	}

	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}

	public int getCovaxQuantity() {
		return covaxQuantity;
	}

	public void setCovaxQuantity(int covaxQuantity) {
		this.covaxQuantity = covaxQuantity;
	}

	public int getCovidshieldQuantity() {
		return covidshieldQuantity;
	}

	public void setCovidshieldQuantity(int covidshieldQuantity) {
		this.covidshieldQuantity = covidshieldQuantity;
	}
	
	

}