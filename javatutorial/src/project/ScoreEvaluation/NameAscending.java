package project.ScoreEvaluation;

import java.util.Comparator;

class NameAscending implements Comparator {
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Student2 && o2 instanceof Student2) {
			Student2 s1 = (Student2)o1;
			Student2 s2 = (Student2)o2;
			
			return (s1.name).compareTo(s2.name);
		}
		return -1;
		//o1, o2의 검증을 위해 조건문 사용. 오름차순을 위해 기존 name과 인자로 받은 name을 비교하는 형식으로 return
		//else도 return이 필요하므로 의미 없는 -1 작성.
	}
}