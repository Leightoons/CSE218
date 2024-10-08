package utility;

import java.nio.charset.*;
import java.time.*;
import java.util.*;

import app.DataCenter;
import model.*;

public class Utility {
	
	// Randomization
	
	public static String randomString(int length) {
	    byte[] array = new byte[length];
	    new Random().nextBytes(array);
	    return new String(array, Charset.forName("UTF-8"));
	}
	public static String randomString(int minLength, int maxLength) {
		return randomString(randomInt(minLength, maxLength));
	}
	
	public static String randomNumberString(int length) {
		char[] c = new char[length];
		for (int i = 0; i < c.length; i++) {
			c[i] = (char)(48 + (Math.random()*10));
		}
		return new String(c);
	}
	public static String randomNumberString(int minLength, int maxLength) {
		return randomNumberString(randomInt(minLength, maxLength));
	}
	
	public static String randomLetterString(int length) {
		char[] c = new char[length];
		for (int i = 0; i < c.length; i++) {
			c[i] = (char)('a' + (Math.random()*27));
		}
		return new String(c);
	}
	public static String randomLetterString(int minLength, int maxLength) {
		return randomLetterString(randomInt(minLength, maxLength));
	}
	
	public static int randomInt(int min, int max) {
		return min + (int) (Math.random()*(max-min+1));
	}
	
	@SafeVarargs
	public static <T> T choose(T... array) {
		int r = (int)(Math.random()*array.length);
		return array[r];
	}
	
	public static boolean randomBoolean() {
		return Utility.choose(0, 1) == 1;
	}
	
	public static LocalTime randomTime() {
		return LocalTime.of(randomInt(0,23), randomInt(0,59));
	}
	
	
	
	// Generating/Converting Data
	
	public static String longToString(long value, int length) {
		String s =  String.valueOf(value);
		return ("0".repeat(length)+s).substring(s.length());
	}
	
	
	
	
	// Displaying/Printing Data
	
	public static void printDatabase() {
		DataCenter dc = DataCenter.getInstance();
		
		System.out.println("Courses");
		for (Course c : dc.getCourses())
			//System.out.println("   " + c.getTitle() + " " + c.getId());
			System.out.println(" " + c.toString());
		
		System.out.println("Sections");
		for (Section s : dc.getSections())
			//System.out.println("   " + dc.findCourse(s.getCourseNumber()).getTitle() + " " + s.getId());
			System.out.println(" " + s.toString());
		
		System.out.println("Textbooks");
		for (Textbook t : dc.getTextbooks())
			//System.out.println("   " + t.getTitle() + " " + t.getId());
			System.out.println(" " + t.toString());
		
		System.out.println("Students");
		for (Student s : dc.getStudents())
			//System.out.println("   " + s.getName().toString() + " " + s.getId() + " " + s.getGpa());
			System.out.println(" " + s.toString());
		
		System.out.println("Instructors");
		for (Instructor i : dc.getInstructors())
			//System.out.println("   " + i.getName().toString() + " " + i.getId());
			System.out.println(" " + i.toString());
		
		System.out.println("Classrooms");
		for (Classroom c : dc.getClassrooms())
			//System.out.println("   " + c.getId());
			System.out.println(" " + c.toString());
		
		//System.out.println(dc.getCourses());
		//System.out.println(dc.getSections());
		//System.out.println(dc.getTextbooks());
		//System.out.println(dc.getStudents());
		//System.out.println(dc.getInstructors());
		//System.out.println(dc.getClassrooms());
		System.out.println();
	}
	
	
	
}







