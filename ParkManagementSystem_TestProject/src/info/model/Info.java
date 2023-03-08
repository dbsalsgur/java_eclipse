package info.model;

import java.util.Date;

public class Info {

	private int parkNo;
	private String carNo;
	private String grade;
	private String tstat;
	private Date inDate;
	private Date outDate;
	private String inDateStr;
	private String outDateStr;
	
	public Info () {}
	
	public Info(int parkNo, String carNo, String grade, String tstat, String inDateStr, String outDateStr) {
		super();
		this.parkNo = parkNo;
		this.carNo = carNo;
		this.grade = grade;
		this.tstat = tstat;
		this.inDateStr = inDateStr;
		this.outDateStr = outDateStr;
	}
	
	public Info(int parkNo, String carNo, String grade, String tstat, Date inDate, Date outDate) {
		super();
		this.parkNo = parkNo;
		this.carNo = carNo;
		this.grade = grade;
		this.tstat = tstat;
		this.inDate = inDate;
		this.outDate = outDate;
	}

	public Info(String carNo, String grade, String tstat, Date inDate) {
		super();
		this.carNo = carNo;
		this.grade = grade;
		this.tstat = tstat;
		this.inDate = inDate;
	}
	public int getParkNo() {
		return parkNo;
	}
	public void setParkNo(int parkNo) {
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
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	public String getInDateStr() {
		return inDateStr;
	}
	public void setInDateStr(String inDateStr) {
		this.inDateStr = inDateStr;
	}
	public String getOutDateStr() {
		return outDateStr;
	}
	public void setOutDateStr(String outDateStr) {
		this.outDateStr = outDateStr;
	}
	
}
