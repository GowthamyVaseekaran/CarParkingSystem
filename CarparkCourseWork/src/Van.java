
public class Van extends Vehicle {
	// private variable
	private double cargoVolume;

	// Constructor

	public Van(String idPlate, String brand, Date entryTime, double cargoVolume) {
		super(idPlate, brand, entryTime);
		this.cargoVolume = cargoVolume;
	}
	// Getters and setters

	public double getCargoVolume() {
		return cargoVolume;
	}

	public void setCargoVolume(double cargoVolume) {
		this.cargoVolume = cargoVolume;
	}

	// get vehicle type
	public String getType() {
		return "Van";
	}

	@Override
	public String toString() {
		return "Van [Type=" + getType() + ", IdPlate=" + getIdPlate() + ",Brand=" + getBrand() + ", EntryTime="
				+ getEntryTime() + ", cargoVolume=" + cargoVolume + "]";
	}

	public String toStringFileWriting() {
		return ("Van" + "\t" + super.toStringFileWriting() + "\t" + cargoVolume);
	}

}
