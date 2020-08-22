package interfaces;

import java.util.Iterator;
import java.util.function.BinaryOperator;

// Sier mye om hvordan vi kan implementere en iterator over et objekt.
public class BinaryComputingIterator implements Iterator<Double>{
	private Double default1 = null;
	private Double default2 = null;
	private Iterator<Double> iterator1;
	private Iterator<Double> iterator2;
	private BinaryOperator<Double> operator;
	
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.operator = operator;
		
	}
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.operator = operator;
		this.default1 = default1;
		this.default2 = default2;
	}
	
	
	@Override
	
	public boolean hasNext() {
		if(iterator1.hasNext() && iterator2.hasNext()) {
			return true;
		}
		else if(((!iterator1.hasNext() && (this.default1 != null)) && ((!iterator2.hasNext())&&(this.default2 !=null)))) {
			return false;
			
		}
		
		else if((iterator1.hasNext()  && this.default2 != null)){
			return true;
		}
		else if((this.default1 != null) && ((iterator2.hasNext()))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/* Eller så kan man også skrive sånn som et lamda uttrykk.
	 public Double next() {
		Double next1 = (iterator1.hasNext() ? iterator1.next() : default1);
		Double next2 = (iterator2.hasNext() ? iterator2.next() : default2);
		return operator.apply(next1, next2);
	}

	 */
	@Override
	public Double next() {
		Double tall = null;
		if(iterator1.hasNext() && iterator2.hasNext()) {
			tall = operator.apply(iterator1.next(), iterator2.next());
		}
		else if((this.default1 != null) && (this.default2 != null)) {
			Double d1 = this.default1;
			Double d2 = this.default2;
			this.default1 = null;
			this.default2 = null;
			tall = operator.apply(d1, d2);
		}
		
		else if((iterator1.hasNext()  && this.default2 != null)){
			Double d2 = this.default2;
			this.default2 = null;
			tall = operator.apply(iterator1.next(), d2);
		}
		else if((this.default1 != null) && ((iterator2.hasNext()))) {
			Double d1 = this.default1;
			this.default1 = null;
			tall = operator.apply(d1, iterator2.next());
		}
		return tall;
	}

}
