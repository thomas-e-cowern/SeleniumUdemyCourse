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
		

		public void increaseSpeed() {
			System.out.println("Increasing the speed");
		}

		public void setMake(String make) {
			this.make = make;
		}
		
		public String getMake() {
			return this.make;
		}
}
