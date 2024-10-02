package model;

import java.io.*;
import java.util.*;

import datastructures.*;

public class Course implements Comparable<Course>, Indexed<String>, Serializable {
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String courseNumber;
	private String desc;
	private double credits;
	private Major major;
	private ArrayList<String> sections;
	
	public Course(String title, String courseNumber, String desc, double credits, Major major) {
		this.title = title;
		this.courseNumber = courseNumber;
		this.desc = desc;
		this.credits = credits;
		this.major = major;
	}
	
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
	
	public ArrayList<String> getSections() {
		return sections;
	}
	
	@Override
	public int compareTo(Course other) {
		return courseNumber.compareTo(other.courseNumber);
	}

	@Override
	public String toString() {
		return String.format(
				"Course [title=%s, courseNumber=%s, desc=%s, credits=%.2f, major=%s, sections=%s]",
				title, courseNumber, desc, credits, major.label, getSections().toArray().toString());
	}

	@Override
	public String getId() {
		return courseNumber;
	}
}
