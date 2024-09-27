package app;

import datastructures.*;
import model.*;
import utility.*;

public class Main {

	public static void main(String[] args) {
		SortedBag<Student> bag = new SortedBag<>(1, true, true);
		for (int i = 0; i < 100; i++) {
			bag.add(DummyData.generateStudent());
		}
		Student s = bag.find(e -> e.getName().getFirstName().equals("Jeff"));
		bag.remove(s);
		System.out.println(bag.toString());
		
		
	}

}
