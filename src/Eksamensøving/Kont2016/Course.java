package Kont2016;


import java.time.Year;

public class Course implements Comparable<Course>{
	private final String code;
	private Double credits;
	private char semester;
	private int year;
    
    public Course(String code) {
    	this.code = code;
    }
    
    public int getYear() {
    	return this.year;
    }
    
    public char getSemester() {
    	return this.semester;
    }

    /**
     * Gets the time this Course is given, in the format <semester><year>
     * E.g. if the semester is 'S' and the year is 2016,
     * it should return S2016.
     */
    public String getTime() {
    	String nystreng = Character.toString(this.semester);
    	String nystreng2 = Integer.toString(this.getYear());
    	return nystreng + nystreng2;
    }
    
    /**
     * Sets the time that this Course is taught. The format is the semester
     * (char) followed by the year. The year may be shortened to two digits;
     * if it is below 50 then 2000 should be added, otherwise 1900.
     * E.g. S16 means Spring 2016, while F86 means Fall 1986.
     * @param time The time in the format <semester><year>
     * @throws IllegalArgumentException if the format is incorrect
     */
    public void setTime(String time) {
    	if(time.toUpperCase().charAt(0) != 'F' || time.toUpperCase().charAt(0) != 'S') {
    		throw new IllegalArgumentException("Format is wrong");
    	}
    	else {
    		this.semester = time.toUpperCase().charAt(0);
    		int year = Integer.parseInt(time.substring(1));
    		if(year < 100) {
    			year = (year < 50 ? 2000 : 1900) + year;
    		}
    		this.year = year;
    	}
          
    }

    // Compares based on the time given, earlier means smaller.
    @Override
    public int compareTo(Course other) {
       if (year != other.year) {
          return year - other.year;
       }
       return (other.semester - semester);
    }
}