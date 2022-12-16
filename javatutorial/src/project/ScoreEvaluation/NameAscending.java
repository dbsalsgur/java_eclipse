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
	}
}