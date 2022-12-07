package org.java_exercise_03;

public class Rectangle extends Shape {
	
	protected int width;
	protected int height;
	
	
	public Rectangle() {
		super();
	}

	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public void calcArea() {
		area = width * height;
	}

}
