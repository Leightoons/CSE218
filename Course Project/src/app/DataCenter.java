package app;

import java.io.*;
import java.util.*;
import java.util.function.*;

import datastructures.*;
import model.*;
import utility.Utility;

public class DataCenter implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String FILEPATH = System.getProperty("user.dir")+"/dataCenter.dat";
	public static final int STUDENTID_LENGTH = 12;
	public static final int INSTRUCTORID_LENGTH = 12;
	
	private static DataCenter instance = null;
	
	private Long studentIdSeq;
	private Long instructorIdSeq;
	
	private IndexedTree<Course, String> courses;
	private IndexedTree<Section, String> sections;
	private IndexedTree<Textbook, String> textbooks;
	private IndexedTree<Student, String> students;
	private IndexedTree<Instructor, String> instructors;
	private IndexedTree<Classroom, String> classrooms;
	
	
	private DataCenter() {
		System.out.println("Reinitializing DataCenter");
		studentIdSeq = 1L;
		instructorIdSeq = 1L;
		
		courses = new IndexedTree<>();
		sections = new IndexedTree<>();
		textbooks = new IndexedTree<>();
		students = new IndexedTree<>();
		instructors = new IndexedTree<>();
		classrooms = new IndexedTree<>();
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
			System.out.printf("DataCenter saved successfully to %s\n", FILEPATH);
			return true;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("Failed to save DataCenter to %s\n", FILEPATH);
		return false;
	}

	public static boolean loadFromFile() {
		File file = new File(FILEPATH);
		if (file.exists()){
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
				DataCenter dc = (DataCenter)(in.readObject());
				if (dc != null && dc.getClass() == DataCenter.class) {
					instance = dc;
					System.out.printf("DataCenter loaded successfully from %s\n", FILEPATH);
					return true;
				}
			}
			catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("DataCenter could not be loaded from %s\n", FILEPATH);
		return false;
	}
	
	
	private String generateUniqueId(Long seq, int length, IndexedTree<?,String> bag) {
		boolean isUnique = false;
		String temp = "";
		while (!isUnique) {
			temp = Utility.longToString(seq++, length);
			isUnique = !bag.contains(temp);
		}
		return temp;
	}
	public String generateUniqueStudentId() {
		return generateUniqueId(studentIdSeq, STUDENTID_LENGTH, students);
	}
	public String generateUniqueInstructorId() {
		return generateUniqueId(instructorIdSeq, INSTRUCTORID_LENGTH, instructors);
	}
	
	
	public IndexedTree<Course, String> getCourses() {
		return courses;
	}
	public IndexedTree<Section, String> getSections() {
		return sections;
	}
	public IndexedTree<Textbook, String> getTextbooks() {
		return textbooks;
	}
	public IndexedTree<Student, String> getStudents() {
		return students;
	}
	public IndexedTree<Instructor, String> getInstructors() {
		return instructors;
	}
	public IndexedTree<Classroom, String> getClassrooms() {
		return classrooms;
	}
	
	public Course findCourse(String courseNumber) {
		return courses.find(courseNumber);
	}
	public Section findSection(String crn) {
		return sections.find(crn);
	}
	public Textbook findTextbook(String isbn) {
		return textbooks.find(isbn);
	}
	public Student findStudent(String id) {
		return students.find(id);
	}
	public Instructor findInstructor(String id) {
		return instructors.find(id);
	}
	public Classroom findClassroom(String id) {
		return classrooms.find(id);
	}
	
	public Course addCourse(Course course) {
		return courses.add(course);
	}
	public Section addSection(Section section) {
		return sections.add(section);
	}
	public Textbook addTextbook(Textbook textbook) {
		return textbooks.add(textbook);
	}
	public Student addStudent(Student student) {
		return students.add(student);
	}
	public Instructor addInstructor(Instructor instructor) {
		return instructors.add(instructor);
	}
	public Classroom addClassroom(Classroom classroom) {
		return classrooms.add(classroom);
	}
	
	public Course removeCourse(Course course) {
		return courses.remove(course);
	}
	public Section removeSection(Section section) {
		return sections.remove(section);
	}
	public Textbook removeTextbook(Textbook textbook) {
		return textbooks.remove(textbook);
	}
	public Student removeStudent(Student student) {
		return students.remove(student);
	}
	public Instructor removeInstructor(Instructor instructor) {
		return instructors.remove(instructor);
	}
	public Classroom removeClassroom(Classroom classroom) {
		return classrooms.remove(classroom);
	}
	
	public int getCourseCount() {
		return courses.getSize();
	}
	public int getSectionCount() {
		return sections.getSize();
	}
	public int getTextbookCount() {
		return textbooks.getSize();
	}
	public int getStudentCount() {
		return students.getSize();
	}
	public int getInstructorCount() {
		return instructors.getSize();
	}
	public int getClassroomCount() {
		return classrooms.getSize();
	}
	
}
