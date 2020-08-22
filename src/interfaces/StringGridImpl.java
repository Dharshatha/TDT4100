package interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Her lager vi 2 dimensjonal matrise, basically bare � f�lge denne metoden her!

public class StringGridImpl implements StringGrid, Iterable<String>{
	private List<String> StringGrid = new ArrayList<String>();
	private int rowCount;
	private int columnCount;
	
	public StringGridImpl(int rowCount, int columnCount) {
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		
        for(int i = 0; i < (rowCount * columnCount); i++){
            this.StringGrid.add(null);
        }
	}
	

	@Override
	public int getRowCount() {
		return this.rowCount;
	}

	@Override
	public int getColumnCount() {
		return this.columnCount;
	}
	
    private int calcIndex(int x, int y){
        return y*rowCount + x;
    }
	@Override
	public String getElement(int row, int column) {
        int index = calcIndex(row, column);
        return this.StringGrid.get(index);
	}

	@Override
	public void setElement(int row, int column, String element) {
        int index = calcIndex(row, column);
        this.StringGrid.set(index, element);
		
	}
	@Override
	//Skyldes av at interfacet v�r implementerer Iterable<String>
	public Iterator<String> iterator() {
		return this.StringGrid.iterator();
	}
	
	/* SIDEN VI HAR BRUKT ITERABLE KAN VI GJ�RE DETTE. Vi lagde iteratoren, for � kunne iterere p� v�r m�te!
	 StringGrid stringGrid = ... // her initialiseres stringGrid
	 // g� gjennom alle elementene i stringGrid
	  * for (String s: stringGrid) {
	  * 	// gj�r noe med s her
}

	 */
	

}
