package model;

import java.io.*;

import datastructures.*;

public class Course implements Comparable<Course>, Serializable {
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String courseNumber;
	private String desc;
	private double credits;
	private Major major;
	private Bag<String> sections;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public double getCredits() {
		return credits;
	}
	public void setCredits(double credits) {
		this.credits = credits;
	}
	
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	
	public Bag<String> getSections() {
		return sections;
	}
	
	@Override
	public int compareTo(Course other) {
		return courseNumber.compareTo(other.courseNumber);
	}
}
