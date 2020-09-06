package Kont2017;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Kitchen {
	  
    // for each Table that has requested Courses,
    // there is a Collection of the Courses that are yet to be made
    private Map<Table, Collection<Course>> courseQueue = new HashMap<Table, Collection<Course>>();
    private Collection<KitchenListener> lyttere = new ArrayList<KitchenListener>();
     
    
    
    public void addListener(KitchenListener lytter) {
    	if(!this.lyttere.contains(lytter)) {
    		this.lyttere.add(lytter);
    	}
    }
    
    public void removeListener(KitchenListener lytter) {
    	if(this.lyttere.contains(lytter)) {
    		this.lyttere.remove(lytter);
    	}
    }
    
    public void alertTheOthers(Table table, Course course){
    	for(KitchenListener lytter: lyttere) {
    		lytter.courseReady(table, course);
    	}	
    }
    /**
     * Enqueues a Course in the production queue, that is part of the provided Table.
     * @param table
     * @param course
     */
    private void produceCourse(Table table, Course course) {
        Collection<Course> courses = courseQueue.get(table);
        if(courses == null) {
        	courses = new ArrayList<Course>();
        }
        courses.add(course);
        courseQueue.put(table, courses);
    }
  
    /**
     * Internal methods that must be called when a Course of a Table has been produced.
     * Notifies registered listeners about the event.
     * @param table
     * @param course
     */
    private void courseProduced(Table table, Course course) {
        Collection<Course> courses = courseQueue.get(table);
        courses.remove(course);
        this.alertTheOthers(table, course);
    }
  
    /**
     * Should be called when a MenuItem is added to a Table,
     * so the corresponding Courses can be produced.
     * @param table
     * @param item
     */
    public void menuItemAdded(Table table, MenuItem item) {
        if(item instanceof Course) {
        	this.produceCourse(table, (Course) item);
        }
        else if(item instanceof Meal) {
        	for(Course c: ((Meal) item).getCourses()) {
        		this.produceCourse(table, c);
        	}
        }
    }
  
    //
  

}
