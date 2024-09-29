package model;
import java.io.*;
import java.time.*;
import java.util.*;

import datastructures.*;

public class Section implements Comparable<Section>, Indexed<String>, Serializable {
	private static final long serialVersionUID = 1L;
	
	private String crn;
	private String courseNumber;
	private boolean isOnline;
	private int capacity;
	private Classroom room;
	private ArrayList<MeetingTime> meetingTimes;
	private String instructor;
	private ArrayList<String> textbooks;
	private ArrayList<String> students;
	
	public Section(String crn, String courseNumber, boolean isOnline, int capacity, Classroom room, MeetingTime[] meetingTimes, Instructor instructor, Textbook[] textbooks) {
		this.crn = crn;
		this.courseNumber = courseNumber;
		this.isOnline = isOnline;
		this.room = room;
		this.meetingTimes = new ArrayList<MeetingTime>();
			for (MeetingTime mt : meetingTimes) this.meetingTimes.add(mt);
		this.instructor = instructor.getId();
		this.textbooks = new ArrayList<String>();
			for (Textbook tb : textbooks) this.textbooks.add(tb.getIsbn());
		this.students = new ArrayList<String>();
	}
	
	public String getCrn() {
		return crn;
	}
	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Classroom getRoom() {
		return room;
	}
	public void setRoom(Classroom room) {
		this.room = room;
	}

	public ArrayList<MeetingTime> getMeetingTimes() {
		return meetingTimes;
	}

	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public ArrayList<String> getTextbooks() {
		return textbooks;
	}

	public ArrayList<String> getStudents() {
		return students;
	}
	
	@Override
	public int compareTo(Section other) {
		return crn.compareTo(other.crn);
	}
	
	@Override
	public String getId() {
		return crn;
	}
	
}
