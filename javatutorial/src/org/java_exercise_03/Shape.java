package org.java_exercise_03;

public abstract class Shape {
	protected double area;
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	abstract public void calcArea();
}
