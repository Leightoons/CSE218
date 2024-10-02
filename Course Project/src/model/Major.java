package model;

public enum Major {
	CSE("Computer Science"),
	ENG("English"),
	MAT("Math"),
	SCI("Science"),
	HIS("History"),
	;
	
	public final String label;
	
	private Major(String label) {
		this.label = label;
	}
	
}
