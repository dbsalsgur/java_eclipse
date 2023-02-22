package Inven_Model;

public class ProductVO {

	private String procode;
	private String proname;
	private String protype;
	private int proprice;
	private int proquan;

	public ProductVO(String procode, String proname, String protype, int proprice, int proquan) {
		super();
		this.procode = procode;
		this.proname = proname;
		this.protype = protype;
		this.proprice = proprice;
		this.proquan = proquan;
	}

	public ProductVO(String procode, String proname) {
		super();
		this.procode = procode;
		this.proname = proname;
	}

	public ProductVO() {
	}

	public String getProcode() {
		return procode;
	}

	public void setProcode(String procode) {
		this.procode = procode;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getProtype() {
		return protype;
	}

	public void setProtype(String protype) {
		this.protype = protype;
	}

	public int getProprice() {
		return proprice;
	}

	public void setProprice(int proprice) {
		this.proprice = proprice;
	}

	public int getProquan() {
		return proquan;
	}

	public void setProquan(int proquan) {
		this.proquan = proquan;
	}


}
