package project.ScoreEvaluation;


class Student2 implements Comparable {
	final static int LEFT = 0;
	final static int RIGHT = 2;
	final static int CENTER = 1;

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

	public String toString() {
		return format(name, 4, LEFT) + format(studentNo, 4, RIGHT) + format("" + koreanScore, 6, RIGHT)
				+ format("" + mathScore, 6, RIGHT) + format("" + englishScore, 6, RIGHT) + format("" + total, 8, RIGHT);
	}

	static String format(String str, int length, int alignment) {
		int diff = length - str.length();
		if (diff < 0) {
			return str.substring(0, length);
		}

		char[] source = str.toCharArray();
		char[] result = new char[length];

		for (int i = 0; i < result.length; i++) {
			result[i] = ' ';
		}

		switch (alignment) {
		case CENTER:
			System.arraycopy(source, 0, result, diff / 2, source.length);
			break;
		case RIGHT:
			System.arraycopy(source, 0, result, diff / 2, source.length);
			break;
		case LEFT:

		default:
			System.arraycopy(source, 0, result, diff / 2, source.length);

		}
		return new String(result);
	}// static String format(String str, int length, int alignment)
	
	public int compareTo(Object obj) {
		int result = -1;
		if (obj instanceof Student2) {
			Student2 tmp = (Student2)obj;
			result = (this.name).compareTo(tmp.name);
		}
		return result;
	}

}// class Student2 implements Comparable 
