package model;

import java.io.*;
import java.util.*;

import datastructures.*;

public class Textbook implements Indexed<String>, Comparable<Textbook>, Serializable{
	private static final long serialVersionUID = 1L;
	
	private String isbn;
	private String title;

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Textbook other = (Textbook) obj;
		return isbn.equals(other.isbn) && title.equals(other.title);
	}
	
	@Override
	public String getId() {
		return isbn;
	}
	
	@Override
	public int compareTo(Textbook other) {
		return isbn.compareTo(other.isbn);
	}
	
}
