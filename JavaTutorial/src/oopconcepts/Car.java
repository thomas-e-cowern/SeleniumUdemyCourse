package oopconcepts;

public class Car {

	public static void main(String[] args) {

	}
	
	// color
		private String color;
		// make
		private String make;
		// model
		private String model;
		// year
		private int year;
		
		int speed;
		
		int gear;
		

		public void increaseSpeed() {
			System.out.println("Increasing the speed");
		}

		public void setMake(String make) {
			this.make = make;
		}
		
		public String getMake() {
			return this.make;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			if (year > 1900) {
				this.year = year;
			} else {
				System.out.println("This year is not valid");
			}
		}
		
		public Car () {
			this.speed = 0;
			this.gear = 0;
			System.out.println("Executing constructor without arguments");
		}
		
		public Car (int speed, int gear) {
			this.speed = speed;
			this.gear = gear;
		}
}
