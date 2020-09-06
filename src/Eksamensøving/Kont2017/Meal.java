package Kont2017;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Represents a set of (pre-defined) Courses that are ordered as a whole
 */
public class Meal extends MenuItem implements Iterable<Course>{

    private Collection<Course> courses;
   
    public Course findCourse(Predicate<Course> test) {
        return this.courses
        .stream()
        .filter(test)
        .findFirst()
        .orElse(null);
    }
  
    public Meal(String name, String description, Course[] courses) {
        super(name, description);
        this.courses = Arrays.asList(courses);
    }
     
   
    public void addCourses(Course course) {
    	if(!courses.contains(course)) {
    		this.courses.add(course);
    	}
    	else {
    		throw new IllegalArgumentException("Du kan ikke legge til en rett 2 ganger");
    	}
    }
    
    public void removeCourses(Course course) {
    	if(this.courses.contains(course)) {
    		this.courses.remove(course);
    	}
    	else {
    		throw new IllegalArgumentException("Denne retten finnes ikke");
    	}
    }
    
    
    public Collection<Course> getCourses(){
    	return this.courses;
    }
     

	@Override
	public Iterator<Course> iterator() {
		return this.courses.iterator();
	}


}
  