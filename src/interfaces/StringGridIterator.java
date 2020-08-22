package interfaces;

import java.util.Iterator;


public class StringGridIterator implements Iterator<String> {
	private StringGrid Stringgrid;
	private boolean rowmajor; //hvis true bortover først, hvis false nedover først.
	private int rowcount;
	private int columncount;
	private int grid;
	
	
	public StringGridIterator(StringGrid stringgrid, boolean rowmajor) {
		this.Stringgrid = stringgrid;
		this.rowmajor = rowmajor;
		//Må ha disse count int'ene med, siden iteratoren må huske hvor han er hen. 
		this.columncount = 0;
		this.rowcount = 0;
		this.grid = 0;
	}

	@Override
	public boolean hasNext() {
		int h1 = this.Stringgrid.getColumnCount()*this.Stringgrid.getRowCount();
		int h2 = this.grid;
		return (h1 != h2);
	}

	@Override
	public String next() {
		String hei =  null;
		if(rowmajor) {
			if(this.columncount == this.Stringgrid.getColumnCount()) {
				this.columncount=0;
				this.rowcount ++;
			}
			int r1 = this.rowcount;
			int r2 = this.columncount;
			this.columncount ++;			
			hei = Stringgrid.getElement(r1, r2);
			this.grid ++;
		}
		else {
			if(this.rowcount == this.Stringgrid.getRowCount()) {
				this.columncount++;
				this.rowcount=0;
			}
			int r1 = this.rowcount;
			int r2 = this.columncount;
			this.rowcount ++;			
			hei = Stringgrid.getElement(r1, r2);
			this.grid ++;
			
		}
		return hei;
	}
	
	public void remove() {
		throw new UnsupportedOperationException("En slik opperasjon finnes ikke");		
	}

}
