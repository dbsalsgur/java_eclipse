package project.ScoreEvaluation;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class ScoreEvaluation {

	static ArrayList record = new ArrayList();
	// record�� �Է¹��� �̸�, �й�, �����, �����, ���м����� �����Ѵ�.
	static Scanner s = new Scanner(System.in);
	// s�� �Է� ���� �޴´�.

	public static void main(String[] args) {
		while (true) {
			switch (displayMenu()) {
			case 1:
				inputRecord();
				break;

			case 2:
				deleteRecord();
				break;
				
			case 3:
				sortRecord();
				break;
				
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
		}// while(true)
	}

	static int displayMenu() {
		System.out.println("****************************************************");
		System.out.println("��                   ���� ���� ���α׷�                    ��");
		System.out.println("��                    version 1.0                        ��");
		System.out.println("��            made by MinhyeokTech Co, Inc.          ��");
		System.out.println("****************************************************");
		System.out.println();
		System.out.println();
		System.out.println(" 1. �л����� �Է��ϱ� ");
		System.out.println();
		System.out.println(" 2. �л����� �����ϱ� ");
		System.out.println();
		System.out.println(" 3. �л����� �����Ͽ� ����(�̸���, ������)");
		System.out.println();
		System.out.println(" 4. ���α׷� ����");
		System.out.println();
		System.out.println();
		System.out.println("���ϴ� �޴��� �����ϼ���.(1-4) : ");
		//���α׷� ���� �� ��µ� ȭ�� -> switch������ ȣ��

		int menu = 0;

		do {
			try {
				menu = Integer.parseInt(s.nextLine());

				if (menu >= 1 && menu <= 4) {
					break;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("�޴��� �߸� �����ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				System.out.println("���ϴ� �޴��� �����ϼ���.(1-4) : ");
			}
		} while (true);
		//s.nextLine()���� �Է¹��� ���� int������ ��ȯ, 1, 2, 3, 4�̿��� ���� �Է� �� �ٽ� �޴��� �����ϰ� ��

		return menu;
	}// static int displayMenu()

	static void inputRecord() {
		System.out.println("1. �л����� �Է��ϱ�");
		System.out.println("�̸�,�й�,�����,�����,���м��� �� ������ ������� �Է��ϼ���");
		System.out.println("�Է��� ��ġ���� q�� �Է��ϼ���. ����ȭ������ ���ư��ϴ�.");
		while (true) {
			System.out.print(">>");
			//�Է� ���
			do {
				try {
					String input = s.nextLine().trim();
					//s.nextLine()���� ���� �Է� ���� ������ �����ϰ� input�� ���ڿ��� ����

					if (!input.equalsIgnoreCase("q")) {
						Scanner s2 = new Scanner(input).useDelimiter(",");
						//input���� ���� �Է°��� useDelimiter()�� ���� ,(��ǥ)�� �������� ���� �Ѱ��� ���ڷ� �ν�
						//useDelimiter()�� ������ ����� �ϱ� ������ �Է� �� ��ǥ�� �Է°��� ������ ����� �Ѵ�.

						record.add(new Student2(s2.next(), s2.next(), s2.nextInt(), s2.nextInt(), s2.nextInt()));
						//�̸�, �й� : ���ڿ� / ������ ���� : ������
						System.out.println("�� �ԷµǾ����ϴ�. �Է��� ��ġ���� q�� �Է��ϼ���.");
						break;
					} else {
						return;
					}
				} catch (Exception e) {
					System.out.println("�Է¿����Դϴ�. �̸�,�й�,�����,�����,���м��� �� ������ �Է��ϼ���.");
					//������ ��Ģ�� ����� �Է°� �Է� �� ���
					break;
				}
			} while (true);
			//��Ȯ�� �Է°��� �Է��� ������ �ݺ�
		} // do-while(true)
	}// static void inputRecord()

	static void deleteRecord() {
		while (true) {
			displayRecord();
			//���� �� �Է°��� ���� �̸�, �й�, ���� ������ ǥ��
			System.out.println("�����ϰ��� �ϴ� �������� �й��� �Է��ϼ���.(q:����ȭ��)");
			System.out.print(">>");

			do {
				try {
					String input = s.nextLine().trim();

					if (!input.equalsIgnoreCase("q")) {
						//q�Է��� �����ϳ�, q�� �Է� �� ����ȭ������ ���ư��Ƿ�, ���� ����
						int length = record.size();
						//ArrayList�� ũ��� size()�� Ȯ�� ����, for���� �ݺ������� �����ϱ� ���� ��������
						boolean found = false;

						for (int i = 0; i < length; i++) {
							Student2 student = (Student2)record.get(i);
							if (input.equals(student.studentNo)) {
								found = true;
								record.remove(i);
								break;
							//�Է°��� studentNo, �� �й��� ���� ��� i��°�� ����� �ش� record�� ����
							//found�� true�� �Ǹ鼭 �Ʒ��� ���ǹ��� ���� "�����Ǿ����ϴ�."�� ���
							}
						}// for (int i = 0; i < length; i++) 
						if (found) {
							System.out.println("�����Ǿ����ϴ�.");
						} else {
							System.out.println("��ġ�ϴ� �����Ͱ� �����ϴ�.");
							//�й��� ������ ��Ȯ�� �Է�������, ��ġ�ϴ� �����Ͱ� ������ ���. println�κ����� ���ư�
						}
						break;
					} else {
						return;
					}
					
				} catch (Exception e) {
					System.out.println("�Է¿����Դϴ�. �ٽ� �Է��� �ּ���.");
					//�Է� ���� ���ǿ� ����������, �ٽ� �ش� �޼ҵ��� println�κ����� ���ư�
					break;
				}
			} while (true);
		}// end of while
	}// static void deleteRecord()
	
	static void sortRecord() {
		while (true) {
			System.out.println(" ���ı����� �����ϼ���.(1:�̸��� 2:������ 3:���θ޴�) : ");
			//�Է°��� 1,2,3�� �ϳ����� �Ʒ��� �ڵ尡 �����
			
			int sort = 0;
			
			do {
				try {
					sort = Integer.parseInt(s.nextLine());
					//�Է°�(���ڿ�)�� ���������� �ٲ�
					
					if (sort >= 1 && sort <= 3) {
						break;
					} else {
						throw new Exception();
					}
				} catch (Exception e) {
					System.out.println("��ȿ���� ���� �Է°��Դϴ�. �ٽ� �Է����ּ���.");
					System.out.println(" ���ı����� �����ϼ���.(1:�̸��� 2:������ 3:���θ޴�) : ");
				}
			} while (true);
			//�Է°��� ���ؿ� �����Ҷ����� �ݺ��Ǵ� ���
			
			if (sort==1) {
				Collections.sort(record, new NameAscending());
				//������������ ����
				displayRecord();
			} else if(sort==2) {
				Collections.sort(record, new TotalDescending());
				//������������ ����
				displayRecord();
			} else {
				return;
			}
			//�Է� �� ������ �� �Ǿ������� Ȯ���ϱ� ���� displayRecord()ȣ��
		}
	}
	
	static void displayRecord() { 
		int koreanTotal = 0; 
		int englishTotal = 0; 
		int mathTotal = 0; 
		int total = 0; 
		
		System.out.println(); 
		System.out.println("�̸� ��ȣ ���� ���� ���� ���� "); 
		System.out.println("======================================"); 
		
		int length = record.size(); 
		//for�� ����� ���� ���� ����
		
		if(length > 0) { 
			for (int i = 0; i < length ; i++) { 
				Student2 student = (Student2)record.get(i); 
				System.out.println(student); 
				koreanTotal += student.koreanScore; 
				mathTotal += student.mathScore; 
				englishTotal += student.englishScore; 
				total += student.total; 
				//�� ������ ������ ����.
			} 
		} else { 
			System.out.println(); 
			System.out.println(" �����Ͱ� �����ϴ�."); 
			System.out.println(); 
		} 
		System.out.println("======================================"); 
		System.out.println("����: " 
			+ Student2.format(koreanTotal+"", 11, Student2.RIGHT) 
			+ Student2.format(englishTotal+"", 6, Student2.RIGHT) 
			+ Student2.format(mathTotal+"", 6, Student2.RIGHT) 
			+ Student2.format(total+"", 8, Student2.RIGHT) 
		); 
		System.out.println(); 
	} // static void displayRecord() { 
} // end of class 	