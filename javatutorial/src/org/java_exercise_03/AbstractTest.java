package org.java_exercise_03;

public class AbstractTest {

	public static void main(String[] args) {
		
		Shape[] shape = new Shape[2];
		shape[0] = new Circle(5);
		shape[1] = new Rectangle(5, 8);
		
		for (int i = 0;  i<shape.length; i++) {
			shape[i].calcArea();
			System.out.println("µµÇüÀÇ ³ÐÀÌ : "+shape[i].getArea());
		}
	}

}
