package utility;

import java.util.*;

import datastructures.*;
import model.*;

public class DummyData {
	public static final String[] BUILDINGS = new String[]{"RH","SH","SS","IA","BS"};
	public static final String[] FIRSTNAMES  = new String[]{"Dan","Ted","Ben","Jeff","Pat","Mia","Amy","Bob","Ana","Eve"};
	public static final String[] COURSENAMEPARTS  = new String[]{"Math","Science","History","Study","Philosophy","Culture",""};
	
	public static Classroom generateClassroom() {
		String bldg = Utility.choose(BUILDINGS);
		String room = Utility.randomNumberString(3);
		int capacity = new Random().nextInt(12, 33);
		boolean hasProjector = Utility.choose(0, 1) == 1;
		return new Classroom(bldg, room, capacity, hasProjector);
	}
	
	public static Course generateCourse() {
		String title = Utility.randomString(6);
		String courseNumber = Utility.randomNumberString(8);
		String desc = Utility.randomString((int)(Math.random()* 65));
		double credits = new Random().nextDouble(0, 4.0);
		Major major = Utility.choose(Major.values());
		return new Course(title, courseNumber, desc, credits, major);
	}
	
}
