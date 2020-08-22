package app;

public class BMIUtregning {
	//Het BMIUTREGNING før
	private double høyde;
	public String value;
	private int vekt;
	private double bmi;
	
	public BMIUtregning(double høyde, int vekt) {
		this.setHøyde(høyde);
		this.setVekt(vekt);
		
	}
	public BMIUtregning() {
		this.setHøyde(0);
		this.setVekt(0);
		}
	
	
		
	
	public double getHøyde() {
		return høyde;
	}
	public void setHøyde(double høyde) {
		this.høyde = høyde;
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
	
	
	public double utregning(double høyde, int vekt){
		double bmi = vekt/((høyde)*(høyde));
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
