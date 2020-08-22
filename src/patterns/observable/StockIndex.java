package patterns.observable;


import java.util.ArrayList;
import java.util.Collection;

public class StockIndex implements StockListener{
	private String name;
	Collection<Stock> Stock = new ArrayList<Stock>();
	private double index;
	
	public StockIndex(String name, Stock ...stocks) {
		this.name = name;
		for(Stock s: stocks) {
			this.addStock(s);
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addStock(Stock stock) {
		if(!this.Stock.contains(stock)) {
			double prisatm = this.index;
			double ny = stock.getPrice();
			this.index = prisatm + ny;
			this.Stock.add(stock); //legg merke til denne
			stock.addStockListener(this);
		}	
	}
	
	
	public void removeStock(Stock stock) {
		if(this.Stock.contains(stock)) {
			double gammelpris = this.index;
			double removepris = stock.getPrice();
			this.index = gammelpris - removepris;
			this.Stock.remove(stock); //legg merke til denne
			stock.removeStockListener(this);
		}
	}
	
	public double getIndex() {
		return this.index;
	
	}

	@Override
	public void stockPriceChanged(Stock stock, double oldValue, double newValue) {
			double indexatm = this.index;
			double removeold = indexatm - oldValue;
			double addnew = removeold + newValue;
			this.index = addnew;
	}
	

}
