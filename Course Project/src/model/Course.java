package model;

import datastructures.*;

public class Course implements Comparable<Course>{
	private String name;
	private String courseNumber;
	private String desc;
	private double credits;
	private Major major;
	private Bag<String> sections;
	
	@Override
	public int compareTo(Course other) {
		return courseNumber.compareTo(other.courseNumber);
	}
}
