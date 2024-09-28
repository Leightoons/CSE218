package model;
import java.io.*;
import java.time.*;

import datastructures.*;

public class Section implements Comparable<Section>, Serializable {
	private static final long serialVersionUID = 1L;
	
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
	public void setMeetingTimes(Bag<MeetingTime> meetingTimes) {
		this.meetingTimes = meetingTimes;
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
	public void setTextbooks(Bag<String> textbooks) {
		this.textbooks = textbooks;
	}

	public SortedBag<String> getStudents() {
		return students;
	}
	public void setStudents(SortedBag<String> students) {
		this.students = students;
	}

	private String crn;
	private String courseNumber;
	private boolean isOnline;
	private int capacity;
	private Classroom room;
	private Bag<MeetingTime> meetingTimes;
	private String instructor;
	private Bag<String> textbooks;
	private SortedBag<String> students;
	
	public Section(String crn, String courseNumber, boolean isOnline, int capacity, Classroom room, MeetingTime[] meetingTimes, Instructor instructor, Textbook[] textbooks) {
		this.crn = crn;
		this.courseNumber = courseNumber;
		this.isOnline = isOnline;
		this.room = room;
		this.meetingTimes = new Bag<MeetingTime>();
			for (MeetingTime mt : meetingTimes)
				this.meetingTimes.add(mt);
		this.instructor = instructor.getId();
		this.textbooks = new Bag<String>();
			for (Textbook tb : textbooks)
				this.textbooks.add(tb.getIsbn());
		this.students = new SortedBag<String>(capacity, false);
	}
	
	@Override
	public int compareTo(Section other) {
		return crn.compareTo(other.crn);
	}
	
}
