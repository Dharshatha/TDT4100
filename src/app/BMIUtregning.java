package app;

public class BMIUtregning {
	//Het BMIUTREGNING f�r
	private double h�yde;
	public String value;
	private int vekt;
	private double bmi;
	
	public BMIUtregning(double h�yde, int vekt) {
		this.setH�yde(h�yde);
		this.setVekt(vekt);
		
	}
	public BMIUtregning() {
		this.setH�yde(0);
		this.setVekt(0);
		}
	
	
		
	
	public double getH�yde() {
		return h�yde;
	}
	public void setH�yde(double h�yde) {
		this.h�yde = h�yde;
	}
	public int getVekt() {
		return vekt;
	}
	public void setVekt(int vekt) {
		this.vekt = vekt;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi(int bmi) {
		this.bmi = bmi;
	}
	
	
	public double utregning(double h�yde, int vekt){
		double bmi = vekt/((h�yde)*(h�yde));
		this.bmi = bmi;
		return bmi;
		
	}
	
	public String resultat(double bmi) {
		if (bmi < 18.5) {
			value = "er undervektig.";
		}
		
		else if(bmi>=18.5 && bmi<=23.9)
		{
			value = "er Normal.";
		}
		else if(bmi>=25.0 && bmi<=29.9)
		{
			value =("er overvektig.");
		}
		else if(bmi>=30.0)
		{
			value =("har fedme.");
		
		}
		return value;
		}
		
	
	
	}
