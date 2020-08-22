package restaurant;

/**
 * A group (of people) dining together, and should be seated at the same table.
 */
public class Group {
	private final int guestCount;
	private Table table = null;

	/**
	 * Initializes this Group with the provided guest count
	 * @param guestCount
	 */
	public Group(int guestCount) {
		this.guestCount = guestCount;
	}
	
	public int getGuestCount() {
		return this.guestCount;
	}
	
	/*
	public void setTable(Table table) {
		if (table.getCapacity()< this.getGuestCount()) {
			throw new IllegalStateException("Bordet har ikke plass til"+ this.getGuestCount() +" personer");
		}
		else {
			if(this.getTable() != null) {
				Table OldTable = this.getTable();
				OldTable.removeGroup(this);
				this.table = table;
				table.setGroup(this);
			}
			else {
				this.table = table;
			}
		}
	} */
	
	public void setTable(Table table) {
		if(table != null) {
			if (table.getCapacity()< this.getGuestCount()) {
				throw new IllegalStateException("Bordet har ikke plass til"+ this.getGuestCount() +" personer");
			}
			else {
				Table OldTable = this.getTable();
				this.table = table;
				if(OldTable != null && OldTable.getGroup() == this) {
					OldTable.removeGroup(this);
				}
				if(table.getGroup() != this) {
					table.setGroup(this);
				}
			}
		}
	}
	
	protected void removeTable(Table table){
		this.table = null;
	}
	
	
	public Table getTable() {
		return this.table;
	}

}
