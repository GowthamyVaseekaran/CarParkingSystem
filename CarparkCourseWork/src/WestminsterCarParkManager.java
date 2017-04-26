import java.awt.Menu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WestminsterCarParkManager implements carParkManager {
	/*
	 * Creating parking slots with 20 parking slots
	 * 
	 */
	Vehicle[] parkingLots = new Vehicle[20];

	// ArrayList to save history like cache  
	ArrayList<Vehicle> VehicleHistory = new ArrayList<Vehicle>();

	public static void main(String[] args) throws FileNotFoundException {
		WestminsterCarParkManager westminster = new WestminsterCarParkManager();

		westminster.menu();

	}

	// Menu

	public void menu() throws FileNotFoundException {
		// Creating Object
		WestminsterCarParkManager westminsterCar = new WestminsterCarParkManager();
		char choices;
		do {
			Scanner sc = new Scanner(System.in);
			// menu for add vehicle
			System.out.println("Westminster Carparking System");
			System.out.println("------------------------------");
			System.out.println("A: AddVehicle");
			System.out.println("D: Delete Vehicle");
			System.out.println("V: View Parking Lots");
			System.out.println("C: Order in chronical");
			System.out.println("P: Print Percentage");
			System.out.println("S: Print Vehicle list on specific day");
			System.out.println("X: Calculate Charge");
			System.out.println("W: Write File");
			System.out.println("L: Load File");
			System.out.println("E:Exit");

			System.out.println("Please Enter Your Option :");
			choices = sc.nextLine().charAt(0);
			choices = Character.toLowerCase(choices);
			switch (choices) {
			case 'a': {
				westminsterCar.addVehicle(westminsterCar.selectVehicle());
				westminsterCar.displayFreeLots();
				break;
			}
			case 'd': {
				westminsterCar.deleteVehicle();
				westminsterCar.displayFreeLots();
				break;
			}
			case 'v': {
				westminsterCar.printCurrentlyParkedVehicleList();
				break;
			}
			case 'c': {
				westminsterCar.determineChronologicalOrder();
				break;
			}
			case 'p': {
				westminsterCar.printPercentage();
				break;
			}
			case 's': {
				westminsterCar.printListOfVehicleOnSpecificDay();
				break;
			}
			case 'x': {
				westminsterCar.calculateCharge();

				break;
			}
			case 'w': {
				westminsterCar.writeFile();

				break;
			}
			case 'l': {
				westminsterCar.loadFile();

				break;
			}

			case 'e': {
				System.out.println("Thank You!!!");
				System.exit(0);
			}
			default: {
				System.err.println("Invalid Input");
			}
			}
		} while (choices != 'E');
	}

	/*
	 * Determine free slots and return count
	 */
	@Override
	public int determineFreeSlots() {
		// Create variable to count empty slots
		int count = 0;
		for (Vehicle freeLots : parkingLots) {
			if (freeLots == null) {
				count++;
			} else {

			}
		}
		return count;
	}

	/*
	 * Display the number of free slots
	 */
	@Override

	public void displayFreeLots() {
		if (determineFreeSlots() == 0) {
			System.err.println("Sorry we don't have enough space to park your vehicle");
		} else {
			System.out.println("We have" + " " + determineFreeSlots() + " " + "free slots");
		}
	}

	// COMMON VARIABLES
	String idPlateInput;
	String brandInput;
	Date date;
	int index = -1;

	
	/* (non-Javadoc)
	 * @see carParkManager#commonVehicleAdd()
	 * Common add method for all three vehicles
	 */
	
	@Override
	public void commonVehicleAdd() {
		// for int
		Scanner sc1 = new Scanner(System.in);
		// for string
		Scanner sc = new Scanner(System.in);

		// Check whether there is sufficient free slots to park their vehicle
		if (!(determineFreeSlots() == 0)) {
			// IdPlateInput
			System.out.println("Please enter your ID Plate Number :" + " ");
			idPlateInput = sc.nextLine();

			// Brand Input
			System.out.println("Please enter brand :" + " ");
			brandInput = sc.nextLine();

			// Date input

			int day;
			do {
				System.out.println("Please enter entry Day :");
				// String validation
				while (!sc1.hasNextInt()) {
					System.err.println("That's not a number! Please enter valid input");
					sc1.next();
				}
				day = sc1.nextInt();

				// Date range validation
			} while (!(day <= 31) || !(day > 0));

			int month;
			do {
				System.out.println("Please enter Month :");
				// String validation
				while (!sc1.hasNextInt()) {
					System.err.println("That's not a number! Please enter valid input");
					sc1.next();
				}
				month = sc1.nextInt();

				// Month range validation
			} while (!(month <= 12) || !(month > 0));

			int year;
			do {
				System.out.println("Please enter year :");
				// String validation
				while (!sc1.hasNextInt()) {
					System.err.println("That's not a number! Please enter valid input");
					sc1.next();
				}
				year = sc1.nextInt();

				// Year range validation
			} while (!(year <= 2017) || !(year > 1885));

			int hour;
			do {
				System.out.println("Please enter hour :");
				// String validation
				while (!sc1.hasNextInt()) {
					System.err.println("That's not a number! Please enter valid input");
					sc1.next();
				}
				hour = sc1.nextInt();

				// hour range validation
			} while (!(hour < 24) || !(hour > 0));

			int minutes;
			do {
				System.out.println("Please enter Minutes :");
				// String validation
				while (!sc1.hasNextInt()) {
					System.err.println("That's not a number! Please enter valid input");
					sc1.next();
				}
				minutes = sc1.nextInt();

				// minutes range validation
			} while (!(minutes < 60) || !(minutes >= 0));

			date = new Date(day, month, year, hour, minutes);

		} else {
			System.err.println("Sorry we don't have any free slots");
			//System.exit(0);
		}

	}

	/*
	 * method to select vehicle type and their specified variables
	 * 
	 */
	@Override

	public Vehicle selectVehicle() {
		// String
		Scanner sc = new Scanner(System.in);
		// int
		Scanner sc1 = new Scanner(System.in);
		char choices;

		System.out.println("----------------- ");
		System.out.println("C: Car");
		System.out.println("V: Van");
		System.out.println("M: Motorbike");
		System.out.println("E: Exit");
		System.out.println("Select ur vehicle");
		choices = sc.nextLine().charAt(0);
		choices = Character.toLowerCase(choices);
		// System.out.println("Choice : " + choices);

		// validate input
		while (!(choices == 'c' || choices == 'm' || choices == 'v' || choices == 'e')) {
			System.err.println("Invalid input please select one of the following choices");
			System.out.println("----------------- ");
			System.out.println("C: Car");
			System.out.println("V: Van");
			System.out.println("M: Motorbike");
			System.out.println("E: Exit");
			System.out.println("----------------- ");
			System.out.println("Select ur vehicle");
			choices = sc.nextLine().charAt(0);
		}

		// Switch cases for vehicle
		switch (choices) {
		case 'c': {
			// calling common methods
			commonVehicleAdd();

			// noOfDoors

			int noOfDoorsInput;
			do {
				System.out.println("Please enter no of doors");
				// Data type validation
				while (!sc1.hasNextInt()) {
					System.err.println("That's not a number! Please enter valid input");
					sc1.next();
				}
				noOfDoorsInput = sc1.nextInt();
				// Input range validation
			} while (!(noOfDoorsInput > 0));

			// color
			System.out.println("Please enter color");
			String colorInput = sc.next();

			return new Car(idPlateInput, brandInput, date, noOfDoorsInput, colorInput);

		}

		case 'v': {
			commonVehicleAdd();
			double cargoVolumeInput;
			// cargo Volume
			do {
				System.out.println("Please enter cargo volume");
				while (!sc1.hasNextDouble()) {
					System.err.println("That's not a number! Please enter valid input");
					sc1.next();
				}
				cargoVolumeInput = sc1.nextDouble();
			} while (!(cargoVolumeInput > 0));
			// index++;
			return new Van(idPlateInput, brandInput, date, cargoVolumeInput);

		}

		case 'm': {
			commonVehicleAdd();
			int engineSizeInput;
			// Engine size
			do {
				System.out.println("What is your engine size");
				while (!sc1.hasNextInt()) {
					System.err.println("That's not a number! Please enter valid input");
					sc1.next();
				}
				engineSizeInput = sc1.nextInt();
			} while (!(engineSizeInput > 0));

			return new MotorBike(idPlateInput, brandInput, date, engineSizeInput);
		}
		case 'e': {
			System.exit(0);
		}
		default: {

			return null;

		}

		}
	}

	@Override
	public void addVehicle(Vehicle vehicle) {

		// adding one index
		index++;
		if (!(index >= 0 && index <= 19)) {
			System.out.println("UNABLE TO ADD");
		} else {

			// Van occupied two slots
			for (int x = 0; x < parkingLots.length; x++) {
				boolean isFound = true;
				if (vehicle.getType().equalsIgnoreCase("Van")) {

					// A VAN

					isFound = false;

					if (parkingLots[x] == null) {
						if (parkingLots[x + 1] == null) {
							index = x;
							parkingLots[index] = vehicle;
							// add vehicle to arrayList
							VehicleHistory.add(vehicle);

							index++;
							// index = x + 1;
							parkingLots[index] = vehicle;
							isFound = true;
							break;
						}
						// do nothing. continue the next iteration

					}

					if (isFound) {
						System.out.println("Unable to add van");
					}

				} else {
					// occupy one slots for cars and van
					// for (int x = 0; x < parkingLots.length; x++) {
					// if there is any parking slot between two occupied parking
					// lots
					if (parkingLots[x] == null) {
						index = x;
						parkingLots[index] = vehicle;
						// add vehicle to arrayList
						VehicleHistory.add(vehicle);

						index = 0;
						for (int y = 0; y < parkingLots.length; y++) {
							if (parkingLots[y] != null) {
								index++;
							} else {
								break;
							}
						}
						break;
					} else {

					}

				}

			}

		}

	}

	
	//Remove vehicle from car park
	@Override
	public void deleteVehicle() {
		// Scanner for string input
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Please enter your idPlate No");
		String delidPlateNo = sc2.nextLine();
		boolean isFound = true;
		isFound = false;
		for (int x = 0; x < parkingLots.length - 1; x++) {
			if (parkingLots[x] != null) {
				// Delete two lots if the vehicle type is van
				if (parkingLots[x].getType().equalsIgnoreCase("van")) {
					if (parkingLots[x].getIdPlate().equals(delidPlateNo)) {
						isFound = true;
						// Print left vehicle type
						System.out.println("A" + " " + parkingLots[x].getType() + " " + "has left");
						parkingLots[x] = null;
						parkingLots[x + 1] = null;
						break;
					}
				} else {
					// Delete lots for car and motor bike
					if (parkingLots[x].getIdPlate().equals(delidPlateNo)) {
						isFound = true;
						// print delete vehicle type
						System.out.println("A" + " " + parkingLots[x].getType() + " " + "has left");
						parkingLots[x] = null;

						break;
					}
				}
			} else {

			}
		}

		if (!isFound) {

			System.err.println("No vehicle with this idPlate No");
		}

	}

	/* (non-Javadoc)
	 * @see carParkManager#printCurrentlyParkedVehicleList()
	 */
	
	@Override
	public void printCurrentlyParkedVehicleList() {

		for (Vehicle vehicle : parkingLots) {
			if (vehicle != null) {
				System.out.println(vehicle);
			} else {
				System.out.println("VACANT SLOT");
			}
		}

	}

	/*
	 * Vehicle[] parkingLots; ArrayList<Vehicle> sortedVehicleList = new
	 * ArrayList<Vehicle>();
	 * Arrange vehicle list according chronological order
	 */

	Vehicle[] sortedVehicleArray;
	int c;

	@Override
	public void printChronologically() {

		// calculating array length
		c = 0;
		for (Vehicle v : parkingLots) {
			if (v != null) {
				c++;
			}
		}

		// c = array length
		if (c != 0) {
			sortedVehicleArray = new Vehicle[c];
			int counter = 0;

			// assigning only parked vehicles to sorted[]
			for (Vehicle v : parkingLots) {
				if (v != null) {
					sortedVehicleArray[counter] = v;
					counter++;
				}
			}

			// sorting
			Vehicle temp;
			for (int i = 0; i < sortedVehicleArray.length; i++) {
				for (int j = 0; j < sortedVehicleArray.length - 1; j++) {
					// Arrays.toString(sortedVehicleArray);
					// if (parkingLots[j + 1] != null) {
					// check whether years are same
					if ((sortedVehicleArray[j].getEntryTime().getYear()) == (sortedVehicleArray[j + 1].getEntryTime()
							.getYear())) {
						// check whether months are same
						if ((sortedVehicleArray[j].getEntryTime().getMonth()) == (sortedVehicleArray[j + 1]
								.getEntryTime().getMonth())) {
							// check whether day is same
							if ((sortedVehicleArray[j].getEntryTime().getDay()) == (sortedVehicleArray[j + 1]
									.getEntryTime().getDay())) {
								// check whether hour is same
								if ((sortedVehicleArray[j].getEntryTime().getHours()) == (sortedVehicleArray[j + 1]
										.getEntryTime().getHours())) {
									// check whether minutes is same
									if ((sortedVehicleArray[j].getEntryTime()
											.getMinutes()) == (sortedVehicleArray[j + 1].getEntryTime().getMinutes())) {
										temp = sortedVehicleArray[j];
										sortedVehicleArray[j] = sortedVehicleArray[j + 1];
										sortedVehicleArray[j + 1] = temp;
									} else if ((sortedVehicleArray[j].getEntryTime()
											.getMinutes()) < (sortedVehicleArray[j + 1].getEntryTime().getMinutes())) {
										temp = sortedVehicleArray[j];
										sortedVehicleArray[j] = sortedVehicleArray[j + 1];
										sortedVehicleArray[j + 1] = temp;

									} else {

									}
								} else if ((sortedVehicleArray[j].getEntryTime()
										.getHours()) < (sortedVehicleArray[j + 1].getEntryTime().getHours())) {
									temp = sortedVehicleArray[j];
									sortedVehicleArray[j] = sortedVehicleArray[j + 1];
									sortedVehicleArray[j + 1] = temp;

								} else {

								}

							} else if ((sortedVehicleArray[j].getEntryTime().getDay()) < (sortedVehicleArray[j + 1]
									.getEntryTime().getDay())) {
								temp = sortedVehicleArray[j];
								sortedVehicleArray[j] = sortedVehicleArray[j + 1];
								sortedVehicleArray[j + 1] = temp;

							} else {

							}

						} else if ((sortedVehicleArray[j].getEntryTime().getMonth()) < (sortedVehicleArray[j + 1]
								.getEntryTime().getMonth())) {
							temp = sortedVehicleArray[j];
							sortedVehicleArray[j] = sortedVehicleArray[j + 1];
							sortedVehicleArray[j + 1] = temp;
						} else {

						}
					} else if ((sortedVehicleArray[j].getEntryTime().getYear()) < (sortedVehicleArray[j + 1]
							.getEntryTime().getYear())) {
						temp = sortedVehicleArray[j];
						sortedVehicleArray[j] = sortedVehicleArray[j + 1];
						sortedVehicleArray[j + 1] = temp;

					} else {

					}

				}
			}

		} else {
			System.err.println("Car park is empty. Please park a vehicle");
		}

	}

	@Override
	public void determineChronologicalOrder() {
		// printChronologically();

		printChronologically();

		if (sortedVehicleArray == null) {
			// System.err.println("No vehicle");
		} else {
			System.out.println("Chronologically Arranged Vehicle List");
			System.out.println(" ");
			for (Vehicle sortVehicle : sortedVehicleArray) {
				System.out.println(sortVehicle);
			}
		}
		System.out.println(" ");

	}

	/* (non-Javadoc)
	 * @see carParkManager#printPercentage()
	 */
	@Override
	public void printPercentage() {
		double carCount = 0;
		double vanCount = 0;
		double motorbikeCount = 0;
		double vehicleCount = 0;
		// determineChronologicalOrder();
		// printChronologically();
		if (parkingLots == null) {
			// System.err.println("No vehicle");
		} else {
			for (int i = 0; i < parkingLots.length; i++) {
				if (parkingLots[i] != null) {
					if (parkingLots[i].getType().equalsIgnoreCase("Car")) {
						carCount++;
						// vehicleCount++;
					} else if (parkingLots[i].getType().equalsIgnoreCase("Van")) {
						vanCount++;
						// vehicleCount++;
					} else if (parkingLots[i].getType().equalsIgnoreCase("Motorbike")) {
						motorbikeCount++;
						// vehicleCount++;
					}
				}
			}
			vehicleCount = (vanCount / 2) + carCount + motorbikeCount;
			double carStatistic;
			double vanStatistic;
			double motorbikeStatistic;
			carStatistic = ((carCount / vehicleCount) * 100);
			vanStatistic = (((vanCount / 2) / vehicleCount) * 100);
			motorbikeStatistic = ((motorbikeCount / vehicleCount) * 100);
			
			System.out.println("------statistic values-------");
			System.out.println(" ");
			System.out.println("Car statistic is:" + " " + carStatistic + "%");
			System.out.println("Van statistic is:" + " " + vanStatistic + "%");
			System.out.println("Motorbike statistic is: " + " " + motorbikeStatistic + "%");
			lastVehicleParked();
			longTimeParkedVehicle();
		}
		System.out.println(" ");
	}

	@Override
	public void longTimeParkedVehicle() {

		printChronologically();

		// determineChronologicalOrder();
		if (sortedVehicleArray == null) {
			// System.err.println("No vehicle");

		} else {
			System.out.println("The vehicle that was parked for the longest time" + " " + sortedVehicleArray[c - 1]);
		}

	}

	@Override
	public void lastVehicleParked() {
		// determineChronologicalOrder();

		printChronologically();
		if (sortedVehicleArray == null) {
			// System.err.println("No vehicle");

		} else {
			System.out.println("Last vehicle that was parked" + " " + sortedVehicleArray[0]);
		}

	}

	@Override
	public void printListOfVehicleOnSpecificDay() {
		boolean isParked = true;
		isParked = false;
		int k = 0;
		// k++;
		Vehicle[] printVehicle = new Vehicle[20];
		// Vehicle v = null;
		Scanner sc = new Scanner(System.in);
		// User input date
		System.out.println("Please enter the date :");
		int userDateInput = sc.nextInt();
		// user input month
		System.out.println("Please enter the month");
		int userMonthInput = sc.nextInt();
		System.out.println("Please enter the year:");
		int userYearInput = sc.nextInt();
		for (int i = 0; i < VehicleHistory.size(); i++) {
			if (VehicleHistory.get(i) != null) {
				if (VehicleHistory.get(i).getEntryTime().getDay() == userDateInput
						&& VehicleHistory.get(i).getEntryTime().getMonth() == userMonthInput
						&& VehicleHistory.get(i).getEntryTime().getYear() == userYearInput) {
					printVehicle[k] = VehicleHistory.get(i);
					k++;

				}
			}
		}

		for (Vehicle m : printVehicle) {
			if (m != null) {
				isParked = true;
				System.out.println(m);
				// break;
			} else {

			}
		}
		if (!isParked) {
			System.err.println("There is no vehicle parked on this specific day");
		}

	}

	@Override
	public void calculateCharge() {
		int totalMinutes = 0;
		int Money = 0;
		int userDateInput;
		int userInputHours;
		int userInputMinutes;
		Scanner sc = new Scanner(System.in);
		// User input date
		do {
			System.out.println("Please enter the date :");
			while (!sc.hasNextInt()) {
				System.err.println("That is not a number ! Please enter valid input");
				sc.next();
			}
			userDateInput = sc.nextInt();
		} while (!(userDateInput >= 1) || !(userDateInput <= 31));
		// user input hour
		do {
			System.out.println("Please enter current hours");
			while (!sc.hasNextInt()) {
				System.err.println("That is not a number ! Please enter valid input");
				sc.next();
			}
			userInputHours = sc.nextInt();
		} while (!(userInputHours >= 0) || !(userInputHours < 24));
		// userInputMinutes
		do {
			System.out.println("Please enter current mins");
			while (!sc.hasNextInt()) {
				System.err.println("That is not a number ! Please enter valid input");
				sc.next();
			}
			userInputMinutes = sc.nextInt();
		} while (!(userInputMinutes > 0) || !(userInputMinutes < 60));
		int totalInputMins;
		int parkedMinutes;

		for (int i = 0; i < VehicleHistory.size(); i++) {
			if (userDateInput == VehicleHistory.get(i).getEntryTime().getDay()) {
				if (VehicleHistory.get(i).getEntryTime().getHours() < userInputHours) {
					totalInputMins = userInputHours * 60 + userInputMinutes;
					// Calculating total minutes
					parkedMinutes = (VehicleHistory.get(i).getEntryTime().getHours() * 60
							+ VehicleHistory.get(i).getEntryTime().getMinutes());
					totalMinutes = totalInputMins - parkedMinutes;
					// see whether the parking time is less than or equal to
					// three
					// hours after estimating time 210=3.5 hours
					if (totalMinutes <= 180) {
						// check whether the parking time is greater than or
						// equal
						// to 2.5 hours
						if (totalMinutes > 120) {
							Money = 9;
							// hours
						} else if (totalMinutes <= 120 && totalMinutes > 60) {
							Money = 6;
						} else {
							Money = 3;
						}
						// check whether the parking time is greater than or
						// equal

					} else if (totalMinutes > 180 && totalMinutes < 1440) {
						int balanceMinutes = totalMinutes - 180;
						int totalHours = (int) Math.round((balanceMinutes / 60));
						Money = (totalHours * 4) + 9;
					} else if (totalMinutes == 1440) {
						Money = 30;
					} else if (totalMinutes > 1440) {
						Money = 35;
					}

				} else if (VehicleHistory.get(i).getEntryTime().getHours() > userInputHours) {
					int finalHours = userInputHours + 24;
					totalInputMins = finalHours * 60 + userInputMinutes;
					parkedMinutes = (VehicleHistory.get(i).getEntryTime().getHours() * 60
							+ VehicleHistory.get(i).getEntryTime().getMinutes());
					totalMinutes = totalInputMins - parkedMinutes;
					// see whether the parking time is less than or equal to
					// three
					// hours after estimating time 210=3.5 hours
					if (totalMinutes <= 180) {
						// check whether the parking time is greater than or

						if (totalMinutes > 120) {
							Money = 9;
							// check whether the parking time is greater than
							// 1.5
							// hours
						} else if (totalMinutes <= 120 && totalMinutes > 60) {
							Money = 6;
						} else {
							Money = 3;
						}
						// check whether the parking time is greater than or
						// equal

					} else if (totalMinutes > 180 && totalMinutes < 1440) {
						int balanceMinutes = totalMinutes - 180;
						int totalHours = (int) Math.round((balanceMinutes / 60));
						Money = (totalHours * 4) + 9;
					} else if (totalMinutes == 1440) {
						Money = 30;
					}

				} else {
					Money = 30;
				}
			} else if (userDateInput > VehicleHistory.get(i).getEntryTime().getDay()) {
				int dayDifference = (userDateInput - VehicleHistory.get(i).getEntryTime().getDay());

				if (VehicleHistory.get(i).getEntryTime().getHours() < userInputHours) {
					totalInputMins = userInputHours * 60 + userInputMinutes;
					// Calculating total minutes
					parkedMinutes = (VehicleHistory.get(i).getEntryTime().getHours() * 60
							+ VehicleHistory.get(i).getEntryTime().getMinutes());
					totalMinutes = totalInputMins - parkedMinutes;
					// see whether the parking time is less than or equal to
					// three

					if (totalMinutes <= 180) {
						// check whether the parking time is greater than or
						// equal
						// to 2.5 hours
						if (totalMinutes > 120) {
							Money = 9 + dayDifference * 30;
							// check whether the parking time is greater than
							// 1.5
							// hours
						} else if (totalMinutes <= 120 && totalMinutes > 60) {
							Money = 6 + dayDifference * 30;
						} else {
							Money = 3 + dayDifference * 30;
						}
						// check whether the parking time is greater than or
						// equal
						// to 3.5 hour and less than 23.5 hours
					} else if (totalMinutes > 180 && totalMinutes < 1440) {
						int balanceMinutes = totalMinutes - 180;
						int totalHours = (int) Math.round((balanceMinutes / 60));
						Money = (totalHours * 4) + 9 + dayDifference * 30;
					} else if (totalMinutes == 1440) {
						Money = 30 + dayDifference * 30;
					} else if (totalMinutes > 1440) {
						Money = 35;
					}

				} else if (VehicleHistory.get(i).getEntryTime().getHours() > userInputHours) {
					int finalHours = userInputHours + 24;
					totalInputMins = finalHours * 60 + userInputMinutes;
					parkedMinutes = (VehicleHistory.get(i).getEntryTime().getHours() * 60
							+ VehicleHistory.get(i).getEntryTime().getMinutes());
					totalMinutes = totalInputMins - parkedMinutes;
					// see whether the parking time is less than or equal to
					// three
					// hours after estimating time 210=3.5 hours
					if (totalMinutes <= 180) {
						// check whether the parking time is greater than or
						// equal
						// to 2.5 hours
						if (totalMinutes > 120) {
							Money = 9 + dayDifference * 30;
							// check whether the parking time is greater than
							// 1.5
							// hours
						} else if (totalMinutes <= 120 && totalMinutes > 60) {
							Money = 6 + dayDifference * 30;
						} else {
							Money = 3 + dayDifference * 30;
						}
						// check whether the parking time is greater than or
						// equal
						// to 3.5 hour and less than 23.5 hours
					} else if (totalMinutes > 180 && totalMinutes < 1440) {
						int balanceMinutes = totalMinutes - 180;
						int totalHours = (int) Math.round((balanceMinutes / 60));
						Money = (totalHours * 4) + 9;
					} else if (totalMinutes == 1440) {
						Money = 30 + dayDifference * 30;
					}

				} else {
					Money = 30 * dayDifference;
				}

			}
			System.out.println(" ");
			System.out.println(VehicleHistory.get(i).getIdPlate() + " " + Money + "" + "Euro");
		}

	}

	@Override
	public void writeFile() throws FileNotFoundException {

		PrintWriter out = null;

		try {

			out = new PrintWriter("parkingLots.txt");
			for (Vehicle vehicle : parkingLots) {
				if (vehicle != null) {
					out.println(vehicle.toStringFileWriting());
				} else {
					out.println("Vacant");
				}
			}
			System.out.println("File Writing SuccessFul");
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			out.close();
		}
	}

	@Override
	public void loadFile() throws FileNotFoundException {
		int arrayIndex = 0;
		File file = new File("parkingLots.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (!(line.equals("Vacant"))) {
					String[] loadFile = line.split("\t");
					String[] dateTime = loadFile[3].split(" ");
					String[] date = dateTime[0].split("/");
					int day = Integer.parseInt(date[0]);
					int month = Integer.parseInt(date[1]);
					int year = Integer.parseInt(date[2]);

					String[] time = dateTime[1].split(":");
					int hours = Integer.parseInt(time[0]);
					int minutes = Integer.parseInt(time[1]);

					Date fileDateTime = new Date(day, month, year, hours, minutes);

					String idPlateNumber = loadFile[1];
					String brandInput = loadFile[2];
					if (loadFile[0].equalsIgnoreCase("Car")) {
						int noOfDoors = Integer.parseInt(loadFile[4]);
						String color = loadFile[5];
						Car car = new Car(idPlateNumber, brandInput, fileDateTime, noOfDoors, color);
						parkingLots[arrayIndex] = car;
					} else if (loadFile[0].equalsIgnoreCase("MotorBike")) {
						int sizeOfEngine = Integer.parseInt(loadFile[4]);
						MotorBike motorbike = new MotorBike(idPlateNumber, brandInput, fileDateTime, sizeOfEngine);
						parkingLots[arrayIndex] = motorbike;
					} else if (loadFile[0].equalsIgnoreCase("Van")) {
						double cargoVolume = Double.parseDouble(loadFile[4]);
						Van van = new Van(idPlateNumber, brandInput, fileDateTime, cargoVolume);
						parkingLots[arrayIndex] = van;
					}
				} else {
					parkingLots[arrayIndex] = null;
				}
				arrayIndex++;
			}
			System.out.println("File reading success");
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

}
