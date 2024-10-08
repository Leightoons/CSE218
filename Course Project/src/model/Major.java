package model;

public enum Major {
	// Business
	ACC("Accounting"),
	BUS("Business Administration"),
	// Humanities
	ENG("English"),
	MUS("Music"),
	PHL("Philosophy"),
	ART("Visual Arts"),
	// Physical Education
	EXS("Exercise Science"),
	NUR("Nursing"),
	PAR("Paramedic"),
	PED("Physical Education"),
	// Science & Math
	AST("Astronomy"),
	BIO("Biology"),
	CHE("Chemistry"),
	MAT("Mathematics"),
	PHY("Physics"),
	// Engineering Science/Tech
	CSE("Computer Science"),
	CYB("Cybersecurity"),
	ELT("Electrical Engineering"),
	ENS("Engineering Science"),
	// Social Sciences
	ECO("Economics"),
	GEO("Geography"),
	HIS("History"),
	POL("Political Science"),
	PSY("Psychology"),
	SOC("Sociology"),
	// Special Areas
	CRJ("Criminal Justice"),
	EDU("Education"),
	VST("Veterinary Science")
	;
	
	public final String label;
	
	private Major(String label) {
		this.label = label;
	}
	
}
