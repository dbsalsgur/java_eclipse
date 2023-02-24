package info.service;

import java.util.Map;

public class InputRequest {

	private String parkNo;
	private String carNo;
	private String grade;
	private String tstat;
	private String inDate;
	private String outDate;
	public InputRequest() {}
	public InputRequest(String parkNo, String carNo, String grade, String tstat, String inDate, String outDate) {
		super();
		this.parkNo = parkNo;
		this.carNo = carNo;
		this.grade = grade;
		this.tstat = tstat;
		this.inDate = inDate;
		this.outDate = outDate;
	}
	public String getParkNo() {
		return parkNo;
	}
	public void setParkNo(String parkNo) {
		this.parkNo = parkNo;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getTstat() {
		return tstat;
	}
	public void setTstat(String tstat) {
		this.tstat = tstat;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, parkNo, "parkNo");
		checkEmpty(errors, carNo, "carNo");
		checkEmpty(errors, grade, "grade");
		checkEmpty(errors, tstat, "tstat");
		checkEmpty(errors, inDate, "inDate");
		checkEmpty(errors, outDate, "outDate");
	}
	
	public void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty()) {
			errors.put(fieldName, Boolean.TRUE);
		}
	}
}
