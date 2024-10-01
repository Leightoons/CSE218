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
	
	
	
	
	
	
}
