package project.ScoreEvaluation;


class Student2 implements Comparable {
	final static int LEFT = 0;
	final static int CENTER = 1;
	final static int RIGHT = 2;	

	String name = "";
	String studentNo = "";
	int koreanScore = 0;
	int mathScore = 0;
	int englishScore = 0;
	int total = 0;

	Student2(String name, String studentNo, int koreanScore, int mathScore, int englishScore) {
		super();
		this.name = name;
		this.studentNo = studentNo;
		this.koreanScore = koreanScore;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
		total = koreanScore + mathScore + englishScore;
	}
	//setter

	public String toString() {
		return format(name, 4, LEFT) + format(studentNo, 4, RIGHT) + format("" + koreanScore, 6, RIGHT)
				+ format("" +englishScore, 6, RIGHT) + format("" +mathScore, 6, RIGHT) + format("" + total, 8, RIGHT);
	}
	//이름 4칸, 학번 4칸, 각 점수 6칸, 총점 8칸 부여, 이름만 왼쪽정렬, 나머지 오른쪽정렬

	static String format(String str, int length, int alignment) {
		int diff = length - str.length();
		if (diff < 0) {
			return str.substring(0, length);
		}
		//str로 받은 문자열의 길이가 length로 받은 수치보다 클 때 앞에서부터 length만큼만 세어서 표시하는 기능

		char[] source = str.toCharArray();
		//str인자를 char의 배열로 변경
		char[] result = new char[length];

		for (int i = 0; i < result.length; i++) {
			result[i] = ' ';
		}
		//length 인자로 받은 길이만큼 공백 부여

		switch (alignment) {
		case CENTER:
			System.arraycopy(source, 0, result, diff / 2, source.length);
			break;
		case RIGHT:
			System.arraycopy(source, 0, result, diff, source.length);
			break;
		case LEFT:

		default:
			System.arraycopy(source, 0, result, 0, source.length);

		}
		//정렬 시스템, 디폴트가 왼쪽정렬
		//center의 경우 diff가 홀수일 경우 이쁘게 정렬되지 않으므로 무난하게 right를 쓰는게 좋다.
		return new String(result);
	}// static String format(String str, int length, int alignment)
	
	public int compareTo(Object obj) {
		int result = -1;
		if (obj instanceof Student2) {
			Student2 tmp = (Student2)obj;
			result = (this.name).compareTo(tmp.name);
			//Student2가 Comparable을 구현했기 때문에 무조건 조건은 성립한다. 단순한 검증절차.
		}
		return result;
		//Student2의 name과 compareTo의 인자로 받은 name을 비교하는 로직을 가지도록 오버라이딩
	}

}// class Student2 implements Comparable 
