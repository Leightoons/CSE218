package model;

import datastructures.*;

public class Student implements Comparable<Student>{
	private Name name;
	private String id;
	private Major major;
	private double gpa;
	private Bag<Section> currentSections;
	
	public class Name {
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
	}
	
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}

	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public Section[] getSections() {
		return currentSections.toArray();
	}
	
	public Student(Name name, String id, Major major, double gpa) {
		this.name = name;
		this.id = id;
		this.major = major;
		this.gpa = gpa;
	}
	
	@Override
	public int compareTo(Student other) {
		return id.compareTo(other.id);
	}
}
