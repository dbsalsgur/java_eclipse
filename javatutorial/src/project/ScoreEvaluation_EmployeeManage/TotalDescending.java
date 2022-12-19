package project.ScoreEvaluation_EmployeeManage;

import java.util.Comparator;

class TotalDescending implements Comparator {
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Student2 && o2 instanceof Student2) {
			Student2 s1 = (Student2)o1;
			Student2 s2 = (Student2)o2;
			
			return (s1.total < s2.total)? 1 : (s1.total == s2.total ?  0 : -1);
			//s1.total이 s2.total보다 작다. true면 1반환 false면 0또는 1반환
			//s1.total이 s2.total과 같다. true면 0반환, false면 -1반환
			//s1.total이 s2.total보다 클때 1을 반환하는 것이 오름차순. 그 반대이므로 내림차순.
		}
		return -1;
	}	
}	