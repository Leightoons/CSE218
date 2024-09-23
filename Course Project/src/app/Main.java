package app;

import datastructures.*;

public class Main {

	public static void main(String[] args) {
		Bag<String> bag = new Bag<>(1, false);
		for (String s: new String[]{"a","c","b","c","c","d","e","f","c"}) {
			bag.add(s);
		}
		
		//bag.remove("c");
		
		for (String s: bag) {
			System.out.println(s);
		}
		
		//System.out.println("End Process");
	}

}
