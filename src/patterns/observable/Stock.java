package patterns.observable;

import java.util.ArrayList;
import java.util.Collection;

public class Stock {
	private String ticker;
	private double price =0.0;
	Collection<StockListener> StockListener = new ArrayList<StockListener>();
	
	public Stock(String ticker, double price) {
		this.ticker = ticker;
		this.setPrice(price);
	}
	
	public void setPrice(double price) {
		if(price < 0) {
			throw new IllegalArgumentException("Du kan ikke ha et negativt tall.");
		}
		else {
			double OldPrice = this.price;
			double newPrice = price;
			if(OldPrice != newPrice) {
				this.price = newPrice;
				this.alertTheOthers(OldPrice, newPrice);
			}
		}
	}
	
	public String getTicker() {
		return this.ticker;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void addStockListener(StockListener listener) {
		if(!StockListener.contains(listener)) {
			this.StockListener.add(listener);
		}
		else {
			throw new IllegalArgumentException("Du kan ikke legge til en listener som allerede eksisterer.");
		}
		
	}
	
	public void removeStockListener(StockListener listener) {
		if(StockListener.contains(listener) && !StockListener.isEmpty()) {
			this.StockListener.remove(listener);
		}
		else {
			throw new IllegalArgumentException("Du kan ikke fjerne en listener som ikke eksisterer");
		}
	}
	
	public void alertTheOthers(double OldValue, double newValue) {
		for(StockListener s: this.StockListener) {
			s.stockPriceChanged(this, OldValue, newValue);
		}
	}
}
