package app;
import java.util.*;

import datastructures.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import model.*;
import utility.*;

public class Main extends Application {

	public static void main(String[] args) {
		DataCenter dc = DataCenter.getInstance();
		//generateDummyData(3);
		//Utility.printDatabase();
		launch(args);
		DataCenter.saveToFile();
		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Course Registration App");
		
		Pane root = new Pane();
		Scene scene = new Scene(root, 640, 480);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public static void test1() {
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

	public static void test2() {
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
	
	public static void generateDummyData(int n) {
		DataCenter dc = DataCenter.getInstance();
		
		for (int i = 0; i < n; i++) {
			dc.addClassroom(DummyData.generateClassroom());
			dc.addTextbook(DummyData.generateTextbook());
			dc.addInstructor(DummyData.generateInstructor());
			dc.addStudent(DummyData.generateStudent());
			dc.addCourse(DummyData.generateCourse());
			dc.addSection(DummyData.generateSection());
		}

		DataCenter.saveToFile();
	}

	public static void test3() {
		ArrayList<String> list = new ArrayList<>();
		DataCenter dc = DataCenter.getInstance();
		for (int i = 0; i < 5; i++) {
			Student s = DummyData.generateStudent();
			s.setId(dc.generateUniqueStudentId());
			dc.addStudent(s);
			list.add(s.getId());
		}
		System.out.println(list.toString());
	}
	
	
}
