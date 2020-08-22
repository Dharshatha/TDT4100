package restaurant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Restaurant {

	private Collection<Table> tables = new ArrayList<Table>();
	private Collection<CapacityListener> Lyttere = new ArrayList<CapacityListener>();
	
	
	public void AddListener(CapacityListener lytter) {
		if(!Lyttere.contains(lytter) && lytter != null) {
			Lyttere.add(lytter);
		}
		else {
			throw new IllegalArgumentException("Denne lytteren finnes allerede.");
		}
	}
	
	public void removeListener(CapacityListener lytter) {
		if(Lyttere.contains(lytter) && lytter != null) {
			Lyttere.remove(lytter);
		}
		else {
			throw new IllegalArgumentException("Denne lytteren finnes ikke og kan dermed ikke fjernes.");
		}
	}
	
	public void alertListeners() {
		for(CapacityListener l: Lyttere) {
			l.capacityChanged(this);
		}
	}

	// to support testing
	int getTableCount() {
		return tables.size();
	}

	// to support testing
	Table getTable(int n) {
		Iterator<Table> it = tables.iterator();
		while (n > 0) {
			it.next();
		}
		return it.next();
	}

	
	public boolean isOccupied(Table table) {
		if(table.getGroup() != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public int getCapacity(boolean includeOccupied) {
		List<Integer> count = new ArrayList<Integer>();
		if(includeOccupied) {
			for(Table t: tables) {
				count.add(t.getCapacity());
			}
		}
		else {
			for(Table t: tables) {
				if(t.getGroup() == null) {
					count.add(t.getCapacity());
				}
			}
		}
		int sum = count.stream().mapToInt(Integer::intValue).sum(); 
		return sum;
	}


	public void addTable(Table table) {
		if(tables.contains(table)) {
			throw new IllegalArgumentException("Dette bordet finnes allerede");
		}
		else{
			if(table != null) {
				tables.add(table);
				this.alertListeners();
			}
		}	
	}


	public void removeTable(Table table) {
		if(tables.contains(table) && table != null) {
			if(this.isOccupied(table)) {
				throw new IllegalArgumentException("Du kan ikke fjerne et bord det sitter folk på");
			}
			else {
				tables.remove(table);
				}
		}
		else if(!tables.contains(table)) {
			throw new IllegalArgumentException("Dette bordet finnes ikke");
			}
	}


	public void mergeTables(Table table1, Table table2, int lostCapacity) {
		if(!tables.contains(table1) || !tables.contains(table2)) {
			throw new IllegalArgumentException("At least one table does not belong to this restaurant");
		}

		if(this.isOccupied(table1) || this.isOccupied(table2)) {
			throw new IllegalArgumentException("Bordene er okkuperte. Vennligst finn et nytt bord");
		}
		else {
			Table t3 = new CompositeTable(table1, table2, lostCapacity);
			tables.remove(table1);
			tables.remove(table2);
			tables.add(t3);
			this.alertListeners();
		}
	}

	
	public void splitTable(CompositeTable table) {
		if(this.isOccupied(table)) {
			throw new IllegalArgumentException("Bordet er okkupert.");
		}
		else {
			Table t1 = table.GetTable1();
			Table t2 = table.GetTable2();
			tables.remove(table);
			tables.add(t1);
			tables.add(t2);
			this.alertListeners();
		}
	}


	public boolean hasCapacity(Table table, int capacity) {
		if(!this.isOccupied(table) && table.getCapacity()>= capacity) {
			return true;
		}
		else {
			return false;
		}
	}


	public List<Table> findAvailableTables(int capacity) {
		List<Table> hasCapacity = new ArrayList<Table>();
		for(Table t: tables) {
			if(t.getCapacity() >= capacity) {
				if(!this.isOccupied(t)) {
					hasCapacity.add(t);	
				}		
			}
		}
		 // This will use the `compareTo()` method of the `Table` class to compare two tables and sort them.
		Collections.sort(hasCapacity);
		return hasCapacity;
	}


	public boolean seatGroup(Group group) {
		if (group.getTable() != null) {
			throw new IllegalArgumentException("Group is already seated");
		}
		List<Table> availableTables = findAvailableTables(group.getGuestCount());
		if (availableTables.isEmpty()) {
			return false;
		}
		else {
			Table t1 = availableTables.iterator().next();
			t1.setGroup(group);
			//group.setTable(t1); dette trenger jeg ikke å gjøre siden jeg allerede har skrivd dette i koden, og det skjer automatisk
			return true;
		}
	}


	public void removeGroupFromTable(int tableID) {
		Table table = findTable(tableID);
		if(table == null) {
			System.out.println("Et slikt bord finnes ikke");
		}
		else {
			if(table.getGroup() != null) {
				Group g = table.getGroup();
				table.removeGroup(g);
				g.removeTable(table);
				this.alertListeners();
				}
		}
	}


	private Table findTable(int tableID){
		for (Table table : tables) {
			if (isTable(table, tableID)) {
				return table;
			}
		}
		return null;
	}


	private boolean isTable(Table table, int tableID) {
		if (table instanceof SimpleTable) {
			return (((SimpleTable) table).getID() == tableID);
		} else if (table instanceof CompositeTable) {
			CompositeTable comp = (CompositeTable) table;
			Table t1 = comp.GetTable1();
			Table t2 = comp.GetTable2();
			if (isTable(t1,tableID) || isTable(t2, tableID)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Table table = new SimpleTable(5);
		Table table1 = new SimpleTable(6);
		Table table2= new SimpleTable(7);
		Table table3 = new SimpleTable(8);
		Table table4 = new SimpleTable(4);
		Group g = new Group(2);
		Group g1 = new Group(3);
		Group g2 = new Group(4);
		Group g3 = new Group(5);
		Restaurant r = new Restaurant();
		r.tables.add(table);
		r.tables.add(table1);
		r.tables.add(table2);
		r.tables.add(table3);
		r.tables.add(table4);
		for(Table t: r.findAvailableTables(7)) {
			System.out.println(t.getCapacity());
		}
	}

}
