package model;
import java.io.*;
import java.time.*;

import datastructures.*;

public class Section implements Comparable<Section>, Serializable {
	private static final long serialVersionUID = 1L;
	
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
