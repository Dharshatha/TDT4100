package Kont2017;

import java.util.Map;

/**
 * Manages the set of Courses and Meals offered and their prices.
 */
public class Menu {
	private Map<MenuItem, Double> MenuItem;
  
    /**
     * Gets the price for a Course.
     * @param course
     * @return the price
     * @throws IllegalArgumentException if this Menu doesn't include the provided Course
     */
    public double getPrice(Course course) throws IllegalArgumentException {
    	if(this.MenuItem.containsKey(course)) {
    		return this.MenuItem.get(course);
    	}
    	else {
    		throw new IllegalArgumentException("Denne retten finnes ikke i menyen");
    	}
    }
  
    /**
     * Sets/changes the price of the provided Course.
     * @param course
     * @param price
     * denne vil også legge til nye dersom corse ikke eksisterer fra før
     */
    public void updatePrice(MenuItem item, double price) {
    		this.MenuItem.put(item,price);
    }
    

     
    /**
     * Gets the price for a Meal. If the registered price is 0.0,
     * the price is computed as the sum of the prices of the Meal's courses.
     * @param meal
     * @return
     * @throws IllegalArgumentException if this Menu doesn't include the provided Meal,
     *  or if a price of a Course is needed, but is missing
     */
    public double getPrice(MenuItem item) throws IllegalArgumentException {
    	Double sum = 0.00;
    	if(this.MenuItem.containsKey(item)) {
    		if(item instanceof Course) {
    			sum += this.MenuItem.get(item);
    		}
    		else if(item instanceof Meal) {
    			if(this.MenuItem.get(item) == 0.00) {
    				for(Course c : ((Meal) item).getCourses()) {
    					if(this.MenuItem.get(c) == 0.0 || !(this.MenuItem.containsKey(c))) {
    						throw new IllegalArgumentException("Dette gikk dårlig");
    					}
    					else {
    						sum += this.MenuItem.get(c);
    					}
    					
    				}
    			}
    			else {
    				sum += this.MenuItem.get(item);
    			}
    		}
    		return sum;
    	}
    	else {
    		throw new IllegalArgumentException("Dette gikk dårlig");
    	}

    }   
  
}