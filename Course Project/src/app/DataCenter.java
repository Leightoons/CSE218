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
	
	private Bag<Course> courses;
	private Bag<Section> sections;
	private Bag<Textbook> textbooks;
	private Bag<Classroom> classrooms;
	private Bag<Student> students;
	
	private DataCenter() {
		courses = new Bag<Course>();
		sections = new Bag<Section>();
		textbooks = new Bag<Textbook>();
		classrooms = new Bag<Classroom>();
		students = new Bag<Student>();
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
