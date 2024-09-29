package app;

import java.util.*;

import datastructures.*;
import model.*;
import utility.*;

public class Main {

	public static void main(String[] args) {
		//testIndexedBag();
		testSearch();
	}
	
	public static void testIndexedBag() {
		IndexedBag<Student, String> bag = new IndexedBag<>(1, true, true);
		for (int i = 0; i < 20; i++) {
			Student s = DummyData.generateStudent();
			bag.add(s);
		}
		
		Student jeff = bag.find(e -> e.getName().getFirstName().equals("Jeff"));
		bag.remove(jeff);
		
		for (Student s : bag)
			System.out.println(s.getId());
	}

	
	public static void testSearch() {
		ArrayList<IndexedPair<Integer, Integer>> list = new ArrayList<>();
		Random rand = new Random();
		
		for (int i = 0; i < 101; i++) 
			list.add(new IndexedPair<Integer,Integer>(i, rand.nextInt(0,101)));
		
		IndexedBag<IndexedPair<Integer,Integer>, Integer> bag = new IndexedBag<>(false, true);

		for (IndexedPair ip : list) {
			bag.add(ip);
			System.out.println(ip);
		}
		
		System.out.println("\n\n------------------------\n\n");
		
		for (IndexedPair ip : bag)
			System.out.println(ip);
		
	}
}
