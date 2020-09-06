package Midsemester;

public class Room {
	private int floor;
	private int roomNumber;
	private boolean clean;
	private boolean available;
	

	public Room(int floor, int roomNumber, boolean clean, boolean available) {
		this.floor = floor;
		this.available = available;
		this.clean = clean;	
		this.validateRoomNumber(roomNumber);
		this.roomNumber = roomNumber;
	}
	
	private validateRoomNumber(int roomNumber) {
		String nr = Integer.toString(roomNumber);
		if (!nr.startsWith(Integer.toString(this.floor))){
			throw new IllegalArgumentException("Ugyldig rom-nummer");
		}
		
	}
	

}
