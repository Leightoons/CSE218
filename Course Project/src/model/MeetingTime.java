package model;
import java.io.*;
import java.time.*;

public class MeetingTime implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private LocalTime startTime;
	private LocalTime endTime;
	private DayOfWeek weekday;
	
	public enum TimeSegment {
		EARLYMORNING,
		MORNING,
		AFTERNOON,
		EVENING
	}
	
	public MeetingTime(LocalTime startTime, LocalTime endTime, DayOfWeek weekday) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.weekday = weekday;
	}

	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public DayOfWeek getWeekday() {
		return weekday;
	}
	public void setWeekday(DayOfWeek weekday) {
		this.weekday = weekday;
	}
	
	public Duration getDuration() {
		return Duration.between(startTime, endTime);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		MeetingTime other = (MeetingTime) obj;
		return weekday.equals(other.weekday) && startTime.equals(other.startTime) && endTime.equals(other.endTime);
	}
	
	public boolean isConflicting(MeetingTime other) {
		if (!weekday.equals(other.weekday)) return false;
		int comp = startTime.compareTo(other.startTime);
		if (comp == 0) return true;
		MeetingTime[] times = new MeetingTime[2];
		times[0] = (comp < 0)? this : other;
		times[1] = (comp < 0)? other : this;
		return times[0].endTime.compareTo(times[1].startTime) > 0;
	}
	
	
}
