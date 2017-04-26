public class Date {
	// Declaring Variables
	private int day;
	private int month;
	private int year;
	private int hours;
	private int minutes;
	// Constructor

	public Date(int day, int month, int year, int hours, int minutes) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.hours = hours;
		this.minutes = minutes;
	}

	// Getters and setters
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getDate() {

		return String.format("%02d/%02d/%4d", day, month, year);
	}

	public String getTime() {
		return String.format("%02d:%02d", hours, minutes);
	}

	@Override
	public String toString() {
		return day + "/" + month + "/" + year + " " + +hours + ":" + minutes;
	}

}
