package app;

import java.io.*;
import java.util.*;
import java.util.function.*;

import datastructures.*;
import model.*;

public class DataCenter implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String FILEPATH = System.getProperty("user.dir")+"/dataCenter.dat";
	private static DataCenter instance = null;
	
	// bags could be replaced with hashmaps for easier matching with crns/ids
	private SortedBag<Course> courses;
	private SortedBag<Section> sections;
	private SortedBag<Textbook> textbooks;
	private SortedBag<Student> students;
	//private Bag<Classroom> classrooms;
	
	private DataCenter() {
		courses = new SortedBag<Course>();
		sections = new SortedBag<Section>();
		textbooks = new SortedBag<Textbook>();
		//classrooms = new Bag<Classroom>();
		students = new SortedBag<Student>();
	}
	
	public static DataCenter getInstance() {
		if (instance == null)
			if (!loadFromFile())
				instance = new DataCenter();
		return instance;
	}
	
	public static boolean saveToFile() {
		File file = new File(FILEPATH);
		if (!file.exists()) {
			try {file.createNewFile();}
			catch (IOException e) {e.printStackTrace();}
		}
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
			out.writeObject(getInstance());
			out.flush();
			return true;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean loadFromFile() {
		File file = new File(FILEPATH);
		if (!file.exists()) return false;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
			DataCenter dc = (DataCenter)(in.readObject());
			if (dc != null && dc.getClass() == DataCenter.class) {
				instance = dc;
				return true;
			}
		}
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
