package com.babala.storetracker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Visitor  {
	
	public static LinkedList<Visitor> visitorList = new LinkedList<>();
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumber;
	private LocalDate birthDate;
	private LocalDateTime visitDateTime;
	
	
	public Visitor (String firstName, String middleName, String lastName, String phoneNumber, LocalDate birthDate) {
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setBirthDate(birthDate);
		setVisitDateTime(LocalDateTime.now());
		
	}
	
	
	
	public String getFirstName() {
		return firstName;
	}
	
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getMiddleName() {
		return middleName;
	}
	
	private void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	private void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	private void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	
	public LocalDateTime getVisitDateTime() {
		return visitDateTime;
	}
	
	private void setVisitDateTime(LocalDateTime visitDateTime) {
		this.visitDateTime = visitDateTime;
	}
	
	
	public static String [][] Search(String searchKeyword, SearchType searchType) {
		LinkedList<Visitor> resultList = new LinkedList<>();
		
		
		for (Visitor v:visitorList) {
			
			
			switch (searchType) {
			
			case FirstName:
			
				if (v.firstName.equalsIgnoreCase(searchKeyword)) {
					resultList.add(v);
			
			
			}
				break;
				
				
			case LastName:
				

				if (v.lastName.equalsIgnoreCase(searchKeyword)) {
					resultList.add(v);
			
			
			}
				
				break;	
		
			}
		}
		
		
		String results[][] = new String[resultList.size()][5];  
		for (int i = 0; i < resultList.size(); i++) {
			results [i][0] = resultList.get(i).getLastName();
			results [i][1] = resultList.get(i).getFirstName();
			results [i][2] = resultList.get(i).getMiddleName();
			results [i][3] = resultList.get(i).getBirthDate().toString();
			results [i][4] = resultList.get(i).getVisitDateTime().toLocalDate().toString();
		}
		return results;
	
	
	}
	
	
	public static String [][] Search(LocalDate searchDate) {
		LinkedList<Visitor> resultList = new LinkedList<>();
		
		
		for (Visitor v:visitorList) {
			
			
			LocalDate visitDate = v.getVisitDateTime().toLocalDate();
			
			if (visitDate.equals(searchDate)) {
				resultList.add(v);
				
			}
				
			
	}
		
		
		
		String results[][] = new String[resultList.size()][5];  
		for (int i = 0; i < resultList.size(); i++) {
			results [i][0] = resultList.get(i).getLastName();
			results [i][1] = resultList.get(i).getFirstName();
			results [i][2] = resultList.get(i).getMiddleName();
			results [i][3] = resultList.get(i).getBirthDate().toString();
			results [i][4] = resultList.get(i).getVisitDateTime().toLocalDate().toString();
		}
		return results;
	
	
	}
	
	

}
