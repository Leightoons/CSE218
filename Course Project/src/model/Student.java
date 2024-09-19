package model;

import java.util.ArrayList;

public class Student {
	private Name name;
	private int id;
	private Major major;
	private double gpa;
	private ArrayList<Section> currentSections;
	
	public class Name {
		private String firstName;
		private String lastName;
		private String middleName;
	}
}
