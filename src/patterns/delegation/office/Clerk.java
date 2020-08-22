package patterns.delegation.office;

import java.util.function.BinaryOperator;

public class Clerk implements Employee{
	private int printcount;
	private int calculationcount;
	private Printer printer;
	
	
	
	
	public Clerk(Printer printer) {
		this.printer = printer;
		
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		this.calculationcount++;
		return operation.apply(value1, value2);
	}

	@Override
	public void printDocument(String document) {
		this.printer.printDocument(document, this);
		this.printcount ++;
	}

	@Override
	public int getTaskCount() {
		return printcount + calculationcount;
	}

	@Override
	public int getResourceCount() {
		// Siden Clerk ikke har noen andre ansatte å delegere til, vil denne alltid være 1. 
		return 1;
	}

}
