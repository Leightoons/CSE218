package model;
import java.io.*;
import java.time.*;

public class MeetingTime extends TimeRange implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private DayOfWeek weekday;
	
	public MeetingTime(LocalTime startTime, LocalTime endTime, DayOfWeek weekday) {
		super(startTime, endTime);
		this.weekday = weekday;
	}
	public MeetingTime(int startHour, int startMinute, int endHour, int endMinute, DayOfWeek weekday) {
		this(LocalTime.of(startHour, startMinute), LocalTime.of(endHour, endMinute), weekday);
	}
	
	public DayOfWeek getWeekday() {
		return weekday;
	}
	public void setWeekday(DayOfWeek weekday) {
		this.weekday = weekday;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && weekday.equals(((MeetingTime)obj).weekday);
	}
	
	@Override
	public String toString() {
		return String.format("MeetingTime [%s - %s, %s]", getStartTime(), getEndTime(), weekday.name());
	}
	
	public boolean isOverlapping(MeetingTime other) {
		return weekday.equals(other.weekday) && isOverlapping(other);
	}
	
	
}
