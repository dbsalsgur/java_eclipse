package project.ScoreEvaluation_EmployeeManage;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class EmployeeManage {

	static ArrayList record = new ArrayList();
	// record에 입력받은 이름, 학번, 국어성적, 영어성적, 수학성적을 저장한다.
	static Scanner s = new Scanner(System.in);
	// s에 입력 값을 받는다.

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
				System.out.println("�봽濡쒓렇�옩�쓣 醫낅즺�빀�땲�떎.");
				System.exit(0);
			}
		}// while(true)
	}

	static int displayMenu() {
		System.out.println("****************************************************");
		System.out.println("◆                   사원 관리 프로그램                    ◆");
		System.out.println("◆                    version 1.0                        ◆");
		System.out.println("◆            made by MinhyeokTech Co, Inc.          ◆");
		System.out.println("****************************************************");
		System.out.println();
		System.out.println();
		System.out.println(" 1. 사원성적 입력하기 ");
		System.out.println();
		System.out.println(" 2. 사원성적 삭제하기 ");
		System.out.println();
		System.out.println(" 3. 사원성적 정렬하여 보기");
		System.out.println();
		System.out.println(" 4. 프로그램 종료");
		System.out.println();
		System.out.println();
		System.out.println("원하는 메뉴를 선택하세요.(1-4) : ");
		//프로그램 실행 시 출력될 화면 -> switch문으로 호출

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
				System.out.println("메뉴를 잘못 선택하셨습니다. 다시 입력해주세요.");
				System.out.println("원하는 메뉴를 선택하세요.(1-4) : ");
			}
		} while (true);
		//s.nextLine()으로 입력받은 값을 int형으로 변환, 1, 2, 3, 4이외의 값을 입력 시 다시 메뉴를 선택하게 함

		return menu;
	}// static int displayMenu()

	static void inputRecord() {
		System.out.println("1. 사원성적 입력하기");
		System.out.println("이름,사번,중간시험,기말시험의 순서로 공백없이 ,로 구분하여 입력하세요");
		System.out.println("입력을 마치려면 q를 입력하세요. 메인화면으로 돌아갑니다.");
		while (true) {
			System.out.print(">>");
			//입력 대기
			do {
				try {
					String input = s.nextLine().trim();
					//s.nextLine()으로 받은 입력 값에 공백을 제거하고 input에 문자열로 받음

					if (!input.equalsIgnoreCase("q")) {
						Scanner s2 = new Scanner(input).useDelimiter(",");
						//input으로 받은 입력값을 useDelimiter()를 통해 ,(쉼표)를 기준으로 각각 한개의 인자로 인식
						//useDelimiter()는 공백이 없어야 하기 때문에 입력 시 쉼표와 입력값에 공백이 없어야 한다.

						record.add(new Employee(s2.next(), s2.next(), s2.nextInt(), s2.nextInt()));
						//이름, 학번 : 문자열 / 각각의 성적 : 정수형
						System.out.println("잘 입력되었습니다. 입력을 마치려면 q를 입력하세요.");
						break;
					} else {
						return;
					}
				} catch (Exception e) {
					System.out.println("입력오류입니다. 이름,학번,국어성적,영어성적,수학성적 의 순서로 입력하세요.");
					//정해진 규칙에 벗어나는 입력값 입력 시 출력
					break;
				}
			} while (true);
			//정확한 입력값을 입력할 때까지 반복
		} // do-while(true)
	}// static void inputRecord()


	
	static void displayRecord() { 
		int halfTotal = 0; 
		int finalTotal = 0; 
		int total = 0; 
		
		System.out.println(); 
		System.out.println("Name No HalfTest FinalTest Total"); 
		System.out.println("======================================"); 
		
		int length = record.size(); 
		//for문 사용을 위한 변수 선언
		
		if(length > 0) { 
			for (int i = 0; i < length ; i++) { 
				Employee emp = (Employee)record.get(i); 
				System.out.println(emp); 
				halfTotal += emp.halfTest; 
				finalTotal += emp.finalTest; 
				total += emp.total; 
				//각 변수에 점수를 담음.
			} 
		} else { 
			System.out.println(); 
			System.out.println(" 데이터가 없습니다."); 
			System.out.println(); 
		} 
		System.out.println("======================================"); 
		System.out.println("총점: " + "\t" + halfTotal + "\t" + finalTotal + "\t" + total); 
		System.out.println(); 
	} // static void displayRecord() { 
} // end of class 	