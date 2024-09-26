package app;

import datastructures.*;

public class Main {

	public static void main(String[] args) {
		SortedBag<String> bag = new SortedBag<>(1, true, true);
		for (String s: new String[]{"c","j","b","i","h","g","d","e","f","a",}) {
			bag.add(s);
		}
		bag.remove("c");
		System.out.println(bag.toString());
		
		
	}

}
