package inheritance;

import java.util.ArrayList;

import java.util.List;

public class Train{
	List<TrainCar> Train = new ArrayList<TrainCar>();

	
	public void addTrainCar(TrainCar tc) {
		if(!Train.contains(tc)) {
			Train.add(tc);
		}
		else {
			throw new IllegalArgumentException("Denne vognen finnes allerede.");
		}
	}
	
	
	
	public boolean contains(TrainCar tc) {
		return Train.contains(tc);
	}
	
	public int getTotalWeight() {
		int count = 0;
		for(TrainCar t: Train) {
			count +=t.getTotalWeight();
		}
		return count;
	}
	
	public int getPassengerCount() {
		int count = 0;
		for(TrainCar tc: Train) {
			if(tc instanceof PassengerCar) {
				count += ((PassengerCar) tc).getPassengerCount();
			}
		}
		return count;
	}
	
	public int getCargoWeight() {
		int count = 0;
		for(TrainCar tc: Train) {
			if(tc instanceof CargoCar) {
				count += ((CargoCar) tc).getCargoWeight();
			}
		}
		return count;
	}
	
	public String toString() {
		String Type = "";
		for(TrainCar tc: Train) {
			if(tc instanceof PassengerCar) {
				int vekt = ((PassengerCar) tc).getTotalWeight();
				int antallpasasser = ((PassengerCar) tc).getPassengerCount();
				Type += "PassengerCar- Totalvekt" + vekt + "Antall passagenr:" + antallpasasser;
			}
			else if(tc instanceof CargoCar) {
				int vekt = ((CargoCar) tc).getTotalWeight();
				int vektload = ((CargoCar) tc).getCargoWeight();
				Type += "CargoCar" + vekt + " Cargovekt: " + vektload;
			}
		}
		return Type;
	}
	

}
