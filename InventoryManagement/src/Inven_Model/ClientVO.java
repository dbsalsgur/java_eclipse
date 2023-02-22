package Inven_Model;

public class ClientVO {
	private String comname; //회사명
	private String repname; //대표명
	private String location; //위치
	private String tel; //전화번호
	private String email; //email
	private String corno; //법인번호, 기본키
	
	public ClientVO(String comname, String repname, String location, String tel, String email, String corno) {
		super();
		this.comname = comname;
		this.repname = repname;
		this.location = location;
		this.tel = tel;
		this.email = email;
		this.corno = corno;
	}

	public ClientVO() {
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public String getRepname() {
		return repname;
	}

	public void setRepname(String repname) {
		this.repname = repname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCorno() {
		return corno;
	}

	public void setCorno(String corno) {
		this.corno = corno;
	}

	@Override
	public String toString() {
		return "ClientInfo [comname=" + comname + ", repname=" + repname + ", location=" + location + ", tel=" + tel
				+ ", email=" + email + ", corno=" + corno + "]";
	}
	

}
