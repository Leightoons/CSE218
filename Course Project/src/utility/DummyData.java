package utility;

import java.util.*;

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
				Utility.randomString(6),
				Utility.randomNumberString(8),
				Utility.randomString((int)(Math.random()* 65)),
				new Random().nextDouble(0, 8.0),
				Utility.choose(Major.values())
		);
	}
	
	public static Instructor generateInstructor() {
		return new Instructor(
				new Name(Utility.choose(NAMES), Utility.choose(NAMES)),
				Utility.randomNumberString(8)
		);
	}
	
	public static Student generateStudent() {
		return new Student(
				new Name(Utility.choose(NAMES), Utility.choose(NAMES)),
				Utility.randomNumberString(8),
				Utility.choose(Major.values()),
				new Random().nextDouble(0, 4.0)
		);
	}
	
	public static Section generateSection() {
		return new Section(
				Utility.randomNumberString(8),
				Utility.randomNumberString(8),
				Utility.randomBoolean(),
				new Random().nextInt(12, 33),
				null, //GET CLASSROOM
				new MeetingTime[0], //GET MEETING TIMES
				null, //GET INSTRUCTOR
				new Textbook[0] //GET TEXTBOOKS
		);	
	}
	
	
	
	
}
