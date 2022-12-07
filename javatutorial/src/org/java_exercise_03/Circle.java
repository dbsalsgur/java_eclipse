package org.java_exercise_03;

public class Circle extends Shape {
	
	protected int radius;
	
	
	public Circle() {
		super();
	}

	public Circle(int radius) {
		super();
		this.radius = radius;
	}


	@Override
	public void calcArea() {
		area = Math.PI * radius * radius;
	}

}
