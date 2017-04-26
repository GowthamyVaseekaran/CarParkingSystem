public abstract class Vehicle {
	// private variables
	private String idPlate;
	private String brand;
	// private String parkingLotNo;
	private Date entryTime;

	// Constructors
	public Vehicle(String idPlate, String brand, Date entryTime) {
		super();
		this.idPlate = idPlate;
		this.brand = brand;
		// this.parkingLotNo = parkingLotNo;
		this.entryTime = entryTime;
	}

	// getters and setters
	public String getIdPlate() {
		return idPlate;
	}

	public void setIdPlate(String idPlate) {
		this.idPlate = idPlate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public abstract String getType();

	public String toStringFileWriting() {
		return (idPlate + "\t" + brand + "\t" + entryTime);
	}

	@Override
	public String toString() {
		return "Vehicle [idPlate=" + idPlate + ", brand=" + brand + ", entryTime=" + entryTime + ", getIdPlate()="
				+ getIdPlate() + ", getBrand()=" + getBrand() + ", getEntryTime()=" + getEntryTime() + ", getType()="
				+ getType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	/*
	 * public String getParkingLotNo() { return parkingLotNo; }
	 * 
	 * public void setParkingLotNo(String parkingLotNo) { this.parkingLotNo =
	 * parkingLotNo; }
	 */

}
