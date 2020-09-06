package Midsemester;

public class Pig implements Animal{
	private String sound;
	private String food;

	@Override
	public void setAnimalsound() {
		this.sound = "Nøff nøff";
		
	}

	@Override
	public String getAnimalsound() {
		return this.sound;
	}

	@Override
	public void setAnimalfood() {
		this.food = "løvetann";
		
	}
	
	public String getFood() {
		return this.food;
	}

}
