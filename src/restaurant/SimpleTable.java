package restaurant;

public class SimpleTable extends Table {
	private static int count = 1;
	private final int capacity;
	private final int ID; 
	
	public SimpleTable(int capacity) {
		if(capacity < 0) {
			throw new IllegalArgumentException("Du kan ikke ha negativt kapasitet");
		}
		else {
			this.capacity = capacity;
			this.ID = count;
			count ++;
		}
	}
	
	@Override
	protected int getCapacity() {
		return this.capacity;
	}
	
	public int getID() {
		return this.ID;
	}


}
