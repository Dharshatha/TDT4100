package Midsemester;

public class Pig implements Animal{
	private String sound;
	private String food;

	@Override
	public void setAnimalsound() {
		this.sound = "N�ff n�ff";
		
	}

	@Override
	public String getAnimalsound() {
		return this.sound;
	}

	@Override
	public void setAnimalfood() {
		this.food = "l�vetann";
		
	}
	
	public String getFood() {
		return this.food;
	}

}
