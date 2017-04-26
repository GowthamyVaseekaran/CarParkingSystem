import java.io.FileNotFoundException;

public interface carParkManager {

	// Determine free slots
	public int determineFreeSlots();

	// Display No of free slots
	public void displayFreeLots();

	// abstract method for select Vehicle
	public Vehicle selectVehicle();

	// abstract method for common add method
	public void commonVehicleAdd();

	// abstract method for adding vehicle
	public void addVehicle(Vehicle vehicle);

	// abstract method for delete vehicle
	public void deleteVehicle();

	// abstract method to print currently parked vehicle list
	public void printCurrentlyParkedVehicleList();

	public void determineChronologicalOrder();

	// abstract method to print Currently parked vehicle list in chronologically
	public void printChronologically();

	// abstract method to percentage of vehicle
	public void printPercentage();

	// abstract method to determine the vehicle that parked for the long time
	public void longTimeParkedVehicle();

	// To determine the last vehicle that parked
	public void lastVehicleParked();

	// abstract method to print the list of vehicle that entered in the specific
	// day
	public void printListOfVehicleOnSpecificDay();

	// abstract method to calculate car park charge
	public void calculateCharge();

	// public void loadFile();

	void writeFile() throws FileNotFoundException;

	void loadFile() throws FileNotFoundException;

}
