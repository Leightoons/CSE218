package model;

import java.io.*;

public class Classroom implements Comparable<Classroom>, Serializable{
	private static final long serialVersionUID = 1L;
	
	private String room;
	private String building;
	private int capacity;
	private boolean hasProjector;
	
	public Classroom(String room, String building, int capacity, boolean hasProjector) {
		super();
		this.room = room;
		this.building = building;
		this.capacity = capacity;
		this.hasProjector = hasProjector;
	}
	
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}

	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}

	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean hasProjector() {
		return hasProjector;
	}
	public void setHasProjector(boolean hasProjector) {
		this.hasProjector = hasProjector;
	}

	public boolean equals(Classroom other) {
		return (building.equals(other.building) && room.equals(other.room));
	}
	
	@Override
	public int compareTo(Classroom other) {
		int comp = building.compareTo(other.building);
		return (comp == 0)? room.compareTo(other.room) : comp;
	}
}
