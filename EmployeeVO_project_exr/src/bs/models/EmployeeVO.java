package bs.models;

public class EmployeeVO {
	private int no;
	private String name;
	private String jobGrade;
	private int department;
	private String email;
	private String status;
	//각각의 입력데이터를 독립시키기 위해 모든 변수를 private으로 설정, getter, setter를 구현
	
	public EmployeeVO(int no, String name, String jobGrade, int department, String email) {
		super();
		this.no = no;
		this.name = name;
		this.jobGrade = jobGrade;
		this.department = department;
		this.email = email;
	}

	public EmployeeVO(int no, String name, String jobGrade, int department, String email, String status) {
		super();
		this.no = no;
		this.name = name;
		this.jobGrade = jobGrade;
		this.department = department;
		this.email = email;
		this.status = status;
	}
	
	public EmployeeVO() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobGrade() {
		return jobGrade;
	}

	public void setJobGrade(String jobGrade) {
		this.jobGrade = jobGrade;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return getNo()+","+getName();
	}
	
	
}
