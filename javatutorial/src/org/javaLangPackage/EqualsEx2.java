package org.javaLangPackage;

class EqualsEx2 {

	public static void main(String[] args) {
		Person p1 = new Person(8011081111222L);
		Person p2 = new Person(8011081111222L);
		String t = p2.getClass().getName();
		System.out.println(t);
		
		if (p1==p2) {
			System.out.println("p1�� p2�� ���� ����Դϴ�.");
		} else {
			System.out.println("p1�� p2�� �ٸ� ����Դϴ�.");
		}
		if (p1.equals(p2)) {
			System.out.println("p1�� p2�� ���� ����Դϴ�.");
		} else {
			System.out.println("p1�� p2�� �ٸ� ����Դϴ�.");
		}
	}

}

class Person {
	long id;
	
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Person) {
			return id ==((Person)obj).id;
		} else {
			return false;
		}
	}

	public Person(long id) {
		super();
		this.id = id;
	}
	
}
