package org.java_exercies_02;

public class Car {
	
	private int speed;
	private String color;
	
	public Car() {
		super();
	}

	public Car(int speed, String color) {
		super();
		this.speed = speed;
		this.color = color;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	public void speedUp() {
		this.speed+=20;
	}

	@Override
	public String toString() {
		return "Car [speed=" + speed + ", color=" + color + "]";
	}
	
	
}
