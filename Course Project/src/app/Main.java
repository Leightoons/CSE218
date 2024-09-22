package app;

import datastructures.*;

public class Main {

	public static void main(String[] args) {
		Bag<String> bag = new Bag<>(1);
		for (String s: new String[]{"a","b","c","c","d","e","f","c"}) {
			bag.add(s);
		}
		
		//bag.remove("c");
		
		for (String s: bag) {
			System.out.println(s);
		}
		
		System.out.println("End Process");
	}

}
