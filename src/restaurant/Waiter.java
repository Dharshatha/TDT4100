package restaurant;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Handles guests arriving at and departing from a Restaurant.
 */
public class Waiter implements CapacityListener{

	private final Restaurant restaurant;
	private Collection<Group> waitingGroups = new ArrayList<>();

	/**
	 * Initialized this Waiter for the provided Restaurant.
	 * @param restaurant
	 */
	public Waiter(Restaurant restaurant) {
		this.restaurant = restaurant;
		restaurant.AddListener(this);
	}
	
	
	/**
	 * Handles arriving groups, by either seating them immediately
	 * (if possible) or putting them in queue. Those enqueued will
	 * be seated when the Restaurant's (change in) capacity allows it.
	 * @param group
	 */
	public void groupArrived(Group group) {
		if (! restaurant.seatGroup(group)) {
			waitingGroups.add(group);
		}
	}

	/**
	 * Handles departing groups, by removing their seating.
	 * @param tableNum the table where the group was seated
	 */
	public void groupDeparted(int tableNum) {
		restaurant.removeGroupFromTable(tableNum);
	}

	
	// to support testing
	public boolean isWaiting(Group group) {
		return waitingGroups.contains(group);
	}


	@Override
	public void capacityChanged(Restaurant restaurant) {
		for(Group g: this.waitingGroups) {
			if(restaurant.seatGroup(g)) {
				this.waitingGroups.remove(g);
			}
		}
		
	}
}
