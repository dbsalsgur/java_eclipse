package project.ScoreEvaluation_EmployeeManage;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class ScoreEvaluation {

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
					deleteRecord();
					break;
	
				case 3:
					sortRecord();
					break;
	
				case 4:
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				}
		}// while(true)
	}

	static int displayMenu() {
		System.out.println("****************************************************");
		System.out.println("◆                   성적 관리 프로그램                     ◆");
		System.out.println("◆                   version 1.0                     ◆");
		System.out.println("◆            made by MinhyeokTech Co, Inc.          ◆");
		System.out.println("****************************************************");
		System.out.println();
		System.out.println();
		System.out.println(" 1. 학생성적 입력하기 ");
		System.out.println();
		System.out.println(" 2. 학생성적 삭제하기 ");
		System.out.println();
		System.out.println(" 3. 학생성적 정렬하여 보기(이름순, 성적순)");
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
		System.out.println("1. 학생성적 입력하기");
		System.out.println("이름,학번,국어성적,영어성적,수학성적 의 순서로 공백없이 입력하세요");
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

						record.add(new Student2(s2.next(), s2.next(), s2.nextInt(), s2.nextInt(), s2.nextInt()));
						//이름, 학번 : 문자열 / 각각의 성적 : 정수형
						//인자는 여러개이나, 저 인자들 묶음이 record의 한 저장공간에 저장됨
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

	static void deleteRecord() {
		while (true) {
			displayRecord();
			//삭제 전 입력값에 의한 이름, 학번, 점수 데이터 표시
			System.out.println("삭제하고자 하는 데이터의 학번을 입력하세요.(q:메인화면)");
			System.out.print(">>");

			do {
				try {
					String input = s.nextLine().trim();

					if (!input.equalsIgnoreCase("q")) {
						//q입력이 가능하나, q를 입력 시 메인화면으로 돌아가므로, 조건 설정
						int length = record.size();
						//ArrayList의 크기는 size()로 확인 가능, for문의 반복조건을 설정하기 위한 변수선언
						boolean found = false;

						for (int i = 0; i < length; i++) {
							Student2 student = (Student2)record.get(i);
							if (input.equals(student.studentNo)) {
								found = true;
								record.remove(i);
								break;
							//입력값이 studentNo, 즉 학번과 같을 경우 i번째에 저장된 해당 record ArrayList를 삭제
							//found가 true가 되면서 아래의 조건문을 통해 "삭제되었습니다."가 출력
							}
						}// for (int i = 0; i < length; i++) 
						if (found) {
							System.out.println("삭제되었습니다.");
						} else {
							System.out.println("일치하는 데이터가 없습니다.");
							//학번의 형식을 정확히 입력했으나, 일치하는 데이터가 없으면 출력. println부분으로 돌아감
						}
						break;
					} else {
						return;
					}

				} catch (Exception e) {
					System.out.println("입력오류입니다. 다시 입력해 주세요.");
					//입력 값이 조건에 맞지않으면, 다시 해당 메소드의 println부분으로 돌아감
					break;
				}
			} while (true);
		}// end of while
	}// static void deleteRecord()

	static void sortRecord() {
		while (true) {
			System.out.println(" 정렬기준을 선택하세요.(1:이름순 2:총점순 3:메인메뉴) : ");
			//입력값이 1,2,3중 하나여야 아래의 코드가 실행됨

			int sort = 0;

			do {
				try {
					sort = Integer.parseInt(s.nextLine());
					//입력값(문자열)을 정수형으로 바꿈

					if (sort >= 1 && sort <= 3) {
						break;
					} else {
						throw new Exception();
					}
					//입력값의 검증, 입력값이 조건에 맞지 않으면, else가 실행되면서 예외를 생성하여, catch로 넘어가게 됨
				} catch (Exception e) {
					System.out.println("유효하지 않은 입력값입니다. 다시 입력해주세요.");
					System.out.println(" 정렬기준을 선택하세요.(1:이름순 2:총점순 3:메인메뉴) : ");
				}
			} while (true);
			//입력값이 기준에 부합할때까지 반복되는 기능

			if (sort==1) {
				Collections.sort(record, new NameAscending());
				//오름차순으로 정렬
				displayRecord();
			} else if(sort==2) {
				Collections.sort(record, new TotalDescending());
				//내림차순으로 정렬
				displayRecord();
			} else {
				return;
			}
			//입력 후 정렬이 잘 되었는지를 확인하기 위해 displayRecord()호출
		}
	}

	static void displayRecord() { 
		int koreanTotal = 0; 
		int englishTotal = 0; 
		int mathTotal = 0; 
		int total = 0; 

		System.out.println(); 
		System.out.println("이름    번호    국어    영어    수학      총점 "); 
		System.out.println("======================================"); 

		int length = record.size(); 
		//for문 사용을 위한 변수 선언

		if(length > 0) { 
			for (int i = 0; i < length ; i++) { 
				Student2 student = (Student2)record.get(i); 
				System.out.println(student);
				//toString()을 오버라이딩 했기때문에, get()메소드를 통해 record에 저장된 값을 하나하나 출력함
				koreanTotal += student.koreanScore; 
				mathTotal += student.mathScore; 
				englishTotal += student.englishScore; 
				total += student.total; 
				//get(i)로 꺼낸 값을 각 토탈점수에 누적함.
			} 
		} else { 
			System.out.println(); 
			System.out.println(" 데이터가 없습니다."); 
			System.out.println(); 
			//저장된 데이터가 없을 때 출력.
		} 
		System.out.println("======================================"); 
		System.out.println("총점: " 
			+ Student2.format(koreanTotal+"", 11, Student2.RIGHT) 
			//총점:은 3칸, 이름+학번+국어점수는 14칸이므로 11칸 확보, 오른쪽 정렬로 조정 
			+ Student2.format(englishTotal+"", 6, Student2.RIGHT) 
			+ Student2.format(mathTotal+"", 6, Student2.RIGHT) 
			+ Student2.format(total+"", 8, Student2.RIGHT) 
			//누적데이터의 총점이 표시됨
		); 
		System.out.println(); 
	} // static void displayRecord() { 
} // end of class 	