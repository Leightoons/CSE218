package utility;

import java.time.*;
import java.util.*;

import app.DataCenter;
import datastructures.*;
import model.*;

public class DummyData {
	public static final String[] BUILDINGS = new String[]{"RH","SH","SS","IA","BS"};
	public static final String[] NAMES  = new String[]{"Dan","Ted","Ben","Jeff","Pat","Mia","Amy","Bob","Ana","Eve"};
	
	
	public static Classroom generateClassroom() {
		return new Classroom(
				Utility.choose(BUILDINGS),
				Utility.randomNumberString(3),
				new Random().nextInt(12, 33),
				Utility.randomBoolean()
		);
	}
	
	public static Course generateCourse() {
		return new Course(
				Utility.randomLetterString(6),
				Utility.randomNumberString(8),
				Utility.randomString(10,100),
				new Random().nextDouble(1.0, 8.0),
				Utility.choose(Major.values())
		);
	}
	
	public static Instructor generateInstructor() {
		return new Instructor(
				new Name(Utility.choose(NAMES), Utility.choose(NAMES)),
				Utility.randomNumberString(DataCenter.STUDENTID_LENGTH)
		);
	}
	
	public static Student generateStudent() {
		return new Student(
				new Name(Utility.choose(NAMES), Utility.choose(NAMES)),
				Utility.randomNumberString(DataCenter.STUDENTID_LENGTH),
				Utility.choose(Major.values()),
				new Random().nextDouble(0, 4.0)
		);
	}
	
	public static Section generateSection() {
		DataCenter dc = DataCenter.getInstance();
		return new Section(
				Utility.randomNumberString(8),
				Utility.choose(dc.getCourses().getRandomElement().getCourseNumber()),
				Utility.randomBoolean(),
				Utility.randomInt(16, 32),
				(Classroom)Utility.choose(dc.getClassrooms().toArray()),
				new MeetingTime[]{generateMeetingTime()},
				(Instructor)Utility.choose(dc.getInstructors().toArray()),
				new Textbook[]{(Textbook)Utility.choose(dc.getTextbooks().toArray())}
		);	
	}
	
	public static Textbook generateTextbook() {
		return new Textbook(
				Utility.randomNumberString(13),
				Utility.randomLetterString(8)
		);
	}
	
	public static MeetingTime generateMeetingTime() {
		LocalTime[] t = new LocalTime[]{Utility.randomTime(), Utility.randomTime()};
		if (t[0].compareTo(t[1]) > 0) {
			LocalTime temp = t[1];
			t[1] = t[0];
			t[0] = temp;
		}
		return new MeetingTime(t[0], t[1], Utility.choose(DayOfWeek.values()));
	}
	
}
