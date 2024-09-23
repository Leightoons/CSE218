package model;

public class Textbook implements Comparable<Textbook>{
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
	public int compareTo(Textbook other) {
		return isbn.compareTo(other.isbn);
	}
	
}
