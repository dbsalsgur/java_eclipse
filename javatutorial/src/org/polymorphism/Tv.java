package org.polymorphism;

class Tv extends Product {
	Tv(){
		//����Ŭ������ ������ Product(int price)�� ȣ���Ѵ�.
		super(100);			//Tv�� ������ 100�������� �Ѵ�.
	}
	public String toString() {		//ObjectŬ������ toString()�� �������̵��Ѵ�.
		return "TV";
	}
}
