package project.ScoreEvaluation_EmployeeManage;

class Employee implements Comparable {
	
	String name = "";
	String eNo = "";
	int halfTest = 0;
	int finalTest = 0;
	int total;
	
	Employee(String name, String eNo, int halfTest, int finalTest) {
		this.name = name;
		this.eNo = eNo;
		this.halfTest = halfTest;
		this.finalTest = finalTest;
		total = halfTest + finalTest;
	}
	
	public String toString() {
		return name+ "\t" + eNo + "\t" + halfTest + "\t" + finalTest + "\t" + total;
	}
	
	public int compareTo(Object obj) {
		int result = -1;
		if (obj instanceof Employee) {
			Employee tmp = (Employee)obj;
			result = (this.name).compareTo(tmp.name);
		}
		return result;
	}
}
