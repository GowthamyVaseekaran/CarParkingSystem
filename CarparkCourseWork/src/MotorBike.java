
public class MotorBike extends Vehicle {
	// private variables
	private int sizeEngine;

	// constructor
	public MotorBike(String idPlate, String brand, Date entryTime, int sizeEngine) {
		super(idPlate, brand, entryTime);
		this.sizeEngine = sizeEngine;
	}

	// Getters and setters
	public int getSizeEngine() {
		return sizeEngine;
	}

	public void setSizeEngine(int sizeEngine) {
		this.sizeEngine = sizeEngine;
	}

	// get vehicle type
	public String getType() {
		return "MotorBike";
	}

	@Override
	public String toString() {
		return "MotorBike [Type=" + getType() + ", IdPlate=" + getIdPlate() + ", Brand=" + getBrand()
				+ ", EntryTime=" + getEntryTime() + ", sizeEngine=" + sizeEngine + "]";
	}

	public String toStringFileWriting() {
		return ("Motor Bike" + "\t" + super.toStringFileWriting() + "\t" + sizeEngine);
	}

}
