package Kont2017;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class MealTest extends TestCase {
    private Course c1, c2;
    private Meal meal;
 
    @Before
    protected void setUp() throws Exception {
        this.c1 = new Course("Salat", "Sunt");
        this.c2 = new Course("Kake","Søtt");
        this.meal = new Meal("Dessert","Godt", new Course[]{c1,c2});
    }
     
    @Test
    public void testIteration() {
    	Iterator<Course> it = meal.iterator();
    	assertTrue(it.hasNext());
    	assertEquals(c1, it.next());
    	assertTrue(it.hasNext());
    	assertEquals(c2, it.next());
    	assertFalse(it.hasNext());
    	assertFalse(it.hasNext());
    	
        
    }
     
    @Test
    public void testFindCourse() {
    	assertEquals(c1, meal.findCourse(course -> course.getName().equals("c1")));
    }
}