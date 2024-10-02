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
	private Bag<MeetingTime> meetingTimes;
	private String instructor;
	private Bag<String> textbooks;
	private Bag<String> students;
	
	public Section(String crn, String courseNumber, boolean isOnline, int capacity, Classroom room, MeetingTime[] meetingTimes, Instructor instructor, Textbook[] textbooks) {
		this.crn = crn;
		this.courseNumber = courseNumber;
		this.isOnline = isOnline;
		this.capacity = capacity;
		this.room = room;
		this.meetingTimes = new Bag<MeetingTime>();
			for (MeetingTime mt : meetingTimes) this.meetingTimes.add(mt);
		this.instructor = instructor.getId();
		this.textbooks = new Bag<String>();
			for (Textbook tb : textbooks) this.textbooks.add(tb.getIsbn());
		this.students = new Bag<String>();
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

	public Bag<MeetingTime> getMeetingTimes() {
		return meetingTimes;
	}

	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public Bag<String> getTextbooks() {
		return textbooks;
	}

	public Bag<String> getStudents() {
		return students;
	}
	
	@Override
	public int compareTo(Section other) {
		return crn.compareTo(other.crn);
	}
	
	@Override
	public String toString() {
		return String.format(
				"Section [crn=%s, courseNumber=%s, isOnline=%s, capacity=%s, room=%s, meetingTimes=%s, instructor=%s, textbooks=%s, students=%s]",
				crn, courseNumber, String.valueOf(isOnline), capacity, room, meetingTimes.toString(), instructor, textbooks.toString(), students.toString());
	}
	
	@Override
	public String getId() {
		return crn;
	}
	
}
