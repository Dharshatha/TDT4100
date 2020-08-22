package restaurant;



public abstract class Table implements Comparable<Table>{
	
	private Group group = null;
	
	protected abstract int getCapacity();
	
	public Group getGroup() {
		return this.group;
	}
	
	
	/*
	public void setGroup(Group group) {
		if(group.getGuestCount() > this.getCapacity()) {
			throw new IllegalArgumentException("Gruppen er for stor for bordet");
		}
		else {
			if(this.getGroup()!= null) {
				Group OldGroup = this.getGroup();
				OldGroup.removeTable(this);
				this.group = group;
				group.setTable(this);
			}
			else {
				this.group = group;
			}
		}
	}
	*/
	
	public void setGroup(Group group) {
		if(group != null) {
			if(group.getGuestCount() > this.getCapacity()) {
				throw new IllegalArgumentException("Gruppen er for stor for bordet");
			}
			else {
				Group OldGroup = this.getGroup();
				this.group = group;
				
				if(OldGroup != null &&  OldGroup.getTable() == this) {
					OldGroup.removeTable(this);
				}
				if(group.getTable() != this) {
					group.setTable(this);		
				}
			}
		}
	}
	
	
	
	protected void removeGroup(Group group) {
		this.group = null;
	}
	
	
	public int compareTo(Table t) {
		return this.getCapacity() - t.getCapacity();
	}
	
	/*

	public int compareTo(Table t) {
		Integer number = null;
		if(this.getCapacity() == t.getCapacity() ) {
			number = 0;
		}
		else if(this.getCapacity() > t.getCapacity()) {
			number = 1;
		}
		else if(this.getCapacity() < t.getCapacity()) {
			number = -1;
		}
		return number;
	}*/
	
	
}
