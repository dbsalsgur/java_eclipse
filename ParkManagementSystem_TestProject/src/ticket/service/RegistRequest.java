package ticket.service;

import java.util.Map;

public class RegistRequest {
	
	private String tno;
	private String carno;
	private String phone;
	private String grade;
	private String tstat;
	private String startDate;
	private String endDate;
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, tno, "tno");
		checkEmpty(errors, carno, "carno");
		checkEmpty(errors, phone, "phone");
		checkEmpty(errors, grade, "grade");
		checkEmpty(errors, tstat, "tstat");
		checkEmpty(errors, startDate, "startDate");
		checkEmpty(errors, endDate, "endDate");
	}
	
	public void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty()) {
			errors.put(fieldName, Boolean.TRUE);
		}
	}
}
