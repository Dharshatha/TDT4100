package Kont2017;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Manages the set of ordered items for a table (set of guests).
 */
public class Table implements KitchenListener{
	private final Menu menu;
	Collection<MenuItem> item = new ArrayList<MenuItem>();
	private Kitchen kitchen;

  
  
    /**
     * Initializes a new Table with a Menu that provides the prices for the Courses and Meals
     * @param menu
     */
    public Table(Menu menu) {
		this.menu = menu;
    }
    
    public void addMenuItem(MenuItem item) {
    	this.item.add(item);
    	this.kitchen.menuItemAdded(this, item);
    }

    	 
    /**
     * Computes the total price for all the added items. Prices are provided by the Menu.
     * @return the total price
     * @throws IllegalStateException when the price of an item cannot be provided by the Menu
     */
    public double getPrice() throws IllegalStateException {
    	   double total = 0.0;
    	   for(MenuItem i : this.item) {
    		   try {
    			   total += menu.getPrice(i);
    		   }
    		   catch(IllegalArgumentException e) {
    			   throw new IllegalStateException(e);
    		   }
    	   }
    	   return total;
    	}
    /**
     * Sets the Kitchen that should be notified when items are added.
     * Note that this method may be called several times with different Kitchen objects.
     * @param kitchen
     */
    public void setKitchen(Kitchen kitchen) {
    	Kitchen OldKitchen = this.kitchen;
        if(kitchen != null) {
        	this.kitchen = kitchen;
        	kitchen.addListener(this);
        }
        if(OldKitchen != null) {
        	OldKitchen.removeListener(this);
        }
    }

	@Override
	public void courseReady(Table table, Course course) {
		// TODO Auto-generated method stub	
	}
    
}