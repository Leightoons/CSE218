package model;
import java.io.*;
import java.time.*;

public class TimeRange implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private LocalTime startTime;
	private LocalTime endTime;
	
	public TimeRange(LocalTime startTime, LocalTime endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public TimeRange(int startHour, int startMinute, int endHour, int endMinute) {
		this(LocalTime.of(startHour, startMinute), LocalTime.of(endHour, endMinute));
	}
	
	public enum TimeSegment { //not yet used, TimeRanges all placeholder
		EARLYMORNING(LocalTime.of(0, 0), LocalTime.of(0, 0)),
		MORNING(LocalTime.of(0, 0), LocalTime.of(0, 0)),
		AFTERNOON(LocalTime.of(0, 0), LocalTime.of(0, 0)),
		EVENING(LocalTime.of(0, 0), LocalTime.of(0, 0))
		;
		
		public final LocalTime start;
		public final LocalTime end;
		
		private TimeSegment(LocalTime start, LocalTime end) {
			this.start = start;
			this.end = end;
		}
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
	
	public Duration getDuration() {
		return Duration.between(startTime, endTime);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		TimeRange other = (TimeRange) obj;
		return startTime.equals(other.startTime) && endTime.equals(other.endTime);
	}
	
	@Override
	public String toString() {
		return String.format("TimeRange [%s - %s]", startTime, endTime);
	}
	
	public boolean isOverlapping(TimeRange other) {
		int comp = startTime.compareTo(other.startTime);
		if (comp == 0) return true;
		TimeRange[] times = new TimeRange[2];
		times[0] = (comp < 0)? this : other;
		times[1] = (comp < 0)? other : this;
		return times[0].endTime.compareTo(times[1].startTime) > 0;
	}
	
	
}
