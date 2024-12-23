package model;

import java.io.*;
import java.util.*;

import datastructures.*;

public class Instructor implements Comparable<Instructor>, Indexed<String>, Serializable {
	private static final long serialVersionUID = 1L;

	private Name name;
	private String id;
	private Bag<String> currentSections;
	
	public Instructor(Name name, String id) {
		this.name = name;
		this.id = id;
		currentSections = new Bag<String>();
	}

	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Bag<String> getCurrentSections() {
		return currentSections;
	}
	
	@Override
	public String toString() {
		return String.format("Instructor [name=%s, id=%s, currentSections=%s]",
				name, id, currentSections.toString());
	}

	@Override
	public int compareTo(Instructor other) {
		return id.compareTo(other.id);
	}

}
