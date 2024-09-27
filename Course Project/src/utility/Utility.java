package utility;

import java.nio.charset.*;
import java.util.*;

import model.*;

public class Utility {
	
	public static String randomString(int length) {
	    byte[] array = new byte[length];
	    new Random().nextBytes(array);
	    return new String(array, Charset.forName("UTF-8"));
	}
	
	@SafeVarargs
	public static <T> T choose(T... array) {
		int r = (int)(Math.random()*array.length);
		return array[r];
	}
	
	public static String randomNumberString(int length) {
		char[] c = new char[length];
		for (int i = 0; i < c.length; i++) {
			c[i] = (char)(48 + (Math.random()*10));
		}
		return new String(c);
	}
	
}
