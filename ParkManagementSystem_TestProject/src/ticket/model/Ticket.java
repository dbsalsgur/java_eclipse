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
	public Ticket(int tno, String carno, String phone, String grade, String tstat, Date startDate) {
		super();
		this.tno = tno;
		this.carno = carno;
		this.phone = phone;
		this.grade = grade;
		this.tstat = tstat;
		this.startDate = startDate;
	}
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
	
	
}
