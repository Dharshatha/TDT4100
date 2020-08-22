package patterns.delegation.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
	List<Employee> employees;
	private int printcount;
	private int calculationcount;
	private int selectemployee = 0 ;
	
	
	public Manager(Collection<Employee> employees) {
		if(employees.isEmpty()) {
			throw new IllegalArgumentException("Employees er tom!");
		}
		else {			
			this.employees = new ArrayList<Employee>(employees);
		}
	}


	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		double number = 0;
		if (this.selectemployee < this.employees.size()) {
			this.calculationcount ++;
			Employee Ramesh = this.employees.get(selectemployee);
			this.selectemployee ++;
			number = Ramesh.doCalculations(operation, value1, value2);
		}
		else if(this.selectemployee == this.employees.size()) {
			this.calculationcount                        ++;
			this.selectemployee = 0;
			Employee Ramesh = this.employees.get(selectemployee);
			this.selectemployee ++;
			number = Ramesh.doCalculations(operation, value1, value2);
		}
		return number;
	}


	@Override
	public void printDocument(String document) {
		if (this.selectemployee < this.employees.size()) {
			this.printcount++;
			Employee Ramesh = this.employees.get(selectemployee);
			this.selectemployee ++;
			Ramesh.printDocument(document);
		}
		else if(this.selectemployee == this.employees.size()) {
			this.printcount++;
			this.selectemployee = 0;
			Employee Ramesh = this.employees.get(selectemployee);
			this.selectemployee ++;
			Ramesh.printDocument(document);			
		}
	}


	@Override
	public int getTaskCount() {
		return employees.stream().mapToInt(employee->employee.getTaskCount()).sum();
				// this.calculationcount + this.printcount;
		/*
		 * int task = 0; 
		 for(Employee e: employees) {
		 	task += e.getTaskCount(); 
		 }
		 return task;

		 */
	}


	@Override
	public int getResourceCount() {
		int sum = 1;
		//fordi en employee kan jo ha folk under seg igjen!!
		for (Employee employee : employees) {
			sum += employee.getResourceCount();
		}
		return sum;
	}

	

}
