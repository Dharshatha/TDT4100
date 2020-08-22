package restaurant;

/**
 * A table that consists of other tables.
 */
public class CompositeTable extends Table{
	private Table table1;
	private Table table2;
	private int lostCapacity;
	
	
	public CompositeTable(Table table1, Table table2, int lostCapacity) {
		this.table1 = table1;
		this.table2 = table2;	
		this.lostCapacity = lostCapacity;
	}
	
	@Override
	protected int getCapacity() {
		return table1.getCapacity() + table2.getCapacity() - lostCapacity;
	}
	
	public Table GetTable1() {
		return table1;
	}
	
	public Table GetTable2() {
		return table2;
	}
	
	public int getLostCapacity() {
		return this.lostCapacity;
	}
	
}
