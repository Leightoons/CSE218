package app;

import datastructures.*;

public class Main {

	public static void main(String[] args) {
		SortedBag<String> bag = new SortedBag<>(1, true);
		for (String s: new String[]{"a","c","b","c","a","c","d","e","f","c"}) {
		//for (Integer s: new Integer[]{2,3,1,5,4,6,9,8,7}) {
			bag.add(s);
		}
		//bag.remove("c");
		//for (String s: bag) System.out.println(s);
		System.out.println(bag.toString());
		
		System.out.println();
		int[] array1 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12};
		
	}

}
