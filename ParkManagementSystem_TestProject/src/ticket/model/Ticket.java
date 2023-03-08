package ticket.model;

import java.util.Date;

public class Ticket {

	private int tno;
	private String carno;
	private String phone;
	private String grade;
	private String tstat;
	private Date startDate;
	private Date endDate;
	private String startDateStr;
	private String endDateStr;
	public Ticket(int tno, String carno, String phone, String grade, String tstat, String startDateStr, String endDateStr) {
		super();
		this.tno = tno;
		this.carno = carno;
		this.phone = phone;
		this.grade = grade;
		this.tstat = tstat;
		this.startDateStr = startDateStr;
		this.endDateStr = endDateStr;
	}
	
	
	public Ticket(int tno, String carno, String phone, String grade, String tstat, Date startDate, Date endDate) {
		super();
		this.tno = tno;
		this.carno = carno;
		this.phone = phone;
		this.grade = grade;
		this.tstat = tstat;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Ticket() {}


	public int getTno() {
		return tno;
	}
	public String getCarno() {
		return carno;
	}
	public String getPhone() {
		return phone;
	}
	public String getGrade() {
		return grade;
	}
	public String getTstat() {
		return tstat;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setTstat(String tstat) {
		this.tstat = tstat;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStartDateStr() {
		return startDateStr;
	}
	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}
	public String getEndDateStr() {
		return endDateStr;
	}
	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}
	

}
