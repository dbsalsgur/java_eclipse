package project.ScoreEvaluation;

import java.util.Comparator;

class TotalDescending implements Comparator {
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Student2 && o2 instanceof Student2) {
			Student2 s1 = (Student2)o1;
			Student2 s2 = (Student2)o2;
			
			return (s1.total < s2.total)? 1 : (s1.total == s2.total ?  0 : -1);
		}
		return -1;
	}	
}	