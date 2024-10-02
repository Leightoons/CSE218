package model;

import java.io.*;
import java.util.*;

import datastructures.*;

public class Student implements Comparable<Student>, Indexed<String>, Serializable {
	private static final long serialVersionUID = 1L;
	
	private Name name;
	private String id;
	private Major major;
	private double gpa;
	private ArrayList<Section> currentSections;
	
	public Student(Name name, String id, Major major, double gpa) {
		this.name = name;
		this.id = id;
		this.major = major;
		this.gpa = gpa;
		currentSections = new ArrayList<Section>();
	}
	
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	
	@Override
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
	
	public ArrayList<Section> getSections() {
		return currentSections;
	}
	
	@Override
	public String toString() {
		return String.format("Student [name=%s, id=%s, major=%s, gpa=%s, currentSections=%s]",
				name, id, major, gpa, currentSections.toArray().toString());
	}

	@Override
	public int compareTo(Student other) {
		return id.compareTo(other.id);
	}
}
