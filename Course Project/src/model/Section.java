package model;
import java.time.*;

import datastructures.*;

public class Section {
	private String crn;
	private Course course;
	private Bag<String> textbooks;
	private Classroom room;
	private boolean isOnline;
	private Bag<MeetingTime> meetingTimes;
	//private int instructor;
	//private int[] students
	
	public Section(String crn, Course course, boolean isOnline, int capacity, Classroom room, Textbook[] textbooks) {
		this.crn = crn;
		this.course = course;
		this.isOnline = isOnline;
		this.room = room;
		this.textbooks = new Bag<String>(); {
			for (Textbook t : textbooks)
				this.textbooks.add(t.getId());
		}
		//this.instructor = null;
		//this.students = new int[capacity];
	}
	
}
