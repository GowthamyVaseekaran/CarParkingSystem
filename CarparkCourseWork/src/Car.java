
public class Car extends Vehicle {

	private int noOfDoors;
	private String color;

	// Constructors
	public Car(String idPlate, String brand, Date entryTime, int noOfDoors, String color) {
		super(idPlate, brand, entryTime);
		this.noOfDoors = noOfDoors;
		this.color = color;
	}
	// Getters and Setters

	public int getNoOfDoors() {
		return noOfDoors;
	}

	public void setNoOfDoors(int noOfDoors) {
		this.noOfDoors = noOfDoors;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// get vehicle type
	public String getType() {
		return "Car";
	}

	@Override
	public String toString() {
		return "Car [Type=" + getType() + ", IdPlate=" + getIdPlate() + ", Brand=" + getBrand() + ", EntryTime="
				+ getEntryTime() + ",noOfDoors=" + noOfDoors + ", color=" + color + "]";
	}

	public String toStringFileWriting() {
		return ("Car" + "\t" + super.toStringFileWriting() + "\t" + noOfDoors + "\t" + color);
	}

}
