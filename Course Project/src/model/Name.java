package model;

import java.io.*;

public class Name implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String middleName;
	
	public Name(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	public Name(String firstName, String lastName) {
		this(firstName, null, lastName);
	}
	public Name(String firstName) {
		this(firstName, null, null);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	@Override
	public String toString() {
		String s = firstName;
		if (middleName != null && middleName.length()>0) s += " " + middleName;
		if (lastName != null && lastName.length()>0) s += " " + lastName;
		return s;
	}
	
	
}