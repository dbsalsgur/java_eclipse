package project.EmployeeManage;

import java.util.ArrayList;
import java.util.Scanner;

class EmployeeManage {
	
	static ArrayList record = new ArrayList();
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		while (true) {
			switch (displayMenu()) {
			case 1:
				inputRecord();
				break;

			case 2:
				//deleteRecord();
				break;
			case 3:
				//sortRecord();
				break;
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
		}
	}
	
	static int displayMenu() {
		System.out.println("************************************");
		System.out.println("��");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

}
