package model;
import java.time.*;

import datastructures.*;

public class Section implements Comparable<Section> {
	private String crn;
	private String courseNumber;
	private Bag<String> textbooks;
	//private Classroom room;
	private String room;
	private boolean isOnline;
	private Bag<MeetingTime> meetingTimes;
	//private int instructor;
	//private int[] students
	
	public Section(String crn, String courseNumber, boolean isOnline, int capacity, String room, MeetingTime[] meetingTimes, Textbook[] textbooks) {
		this.crn = crn;
		this.courseNumber = courseNumber;
		this.isOnline = isOnline;
		this.room = room;
		this.meetingTimes = new Bag<MeetingTime>(); {
			for (MeetingTime mt : meetingTimes)
				this.meetingTimes.add(mt);
		}
		this.textbooks = new Bag<String>(); {
			for (Textbook tb : textbooks)
				this.textbooks.add(tb.getIsbn());
		}
		//this.instructor = null;
		//this.students = new int[capacity];
	}
	
	@Override
	public int compareTo(Section other) {
		return crn.compareTo(other.crn);
	}
	
}
