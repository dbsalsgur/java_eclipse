package org.polymorphism;

class InstanceofTest {

	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		
		if (fe instanceof FireEngine) {
			System.out.println("This is a FireEngine instance.");
		}
		if (fe instanceof Car) {
			System.out.println("This is a Car instance.");
		}
		if (fe instanceof Object) {
			System.out.println("This is an Object instance.");
		}
		System.out.println(fe.getClass().getName());
		//getClass() : 클래스명 반환
		//getName() : 객체를 문자열로 반환
	}
}
class Car{}
class FireEngine extends Car {} 
