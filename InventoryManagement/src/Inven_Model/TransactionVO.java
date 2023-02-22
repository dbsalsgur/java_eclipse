package Inven_Model;

public class TransactionVO {

	private int transno; // 거래번호, 기본키
	private int transdate; // 거래일
	private String transname; // 품명
	private String transtype; // 종류
	private int quantity; // 수량
	private int transprice; // 판매단가
	private int totalprice; // 거래 총 금액
	private String client; // 거래처
	private String prono;

	public TransactionVO(String prono, String transname, int transprice, int quantity, String client , int transdate) {
		super();
		this.transdate = transdate;
		this.transname = transname;
		this.quantity = quantity;
		this.transprice = transprice;
		this.client = client;
		this.prono = prono;
	}
	

	public TransactionVO(int transno, String transname, String transtype, int transprice, int quantity,
			String client, int transdate) {
		super();
		this.transno = transno;
		this.transdate = transdate;
		this.transname = transname;
		this.transtype = transtype;
		this.quantity = quantity;
		this.transprice = transprice;
		this.client = client;
	}

	public TransactionVO(int transno, int transdate, String transname, String transtype, int quantity,
			int transprice, int totalprice, String client) {
		super();
		this.transno = transno;
		this.transdate = transdate;
		this.transname = transname;
		this.transtype = transtype;
		this.quantity = quantity;
		this.transprice = transprice;
		this.totalprice = totalprice;
		this.client = client;
	}

	
	public TransactionVO(int transno, int transdate, String transname,  int quantity,
			int transprice, int totalprice, String client, String prono) {
		super();
		this.transno = transno;
		this.transdate = transdate;
		this.transname = transname;
		this.quantity = quantity;
		this.transprice = transprice;
		this.totalprice=totalprice;
		this.prono = prono;
		this.client = client;
	}

	// 거래조회용
	public TransactionVO(int transno, int transdate, String transname, String transtype, String client) {
		super();
		this.transno = transno;
		this.transdate = transdate;
		this.transname = transname;
		this.transtype = transtype;
		this.client = client;
	}

	public TransactionVO() {
	}

	public int getTransno() {
		return transno;
	}

	public void setTransno(int transno) {
		this.transno = transno;
	}

	public int getTransdate() {
		return transdate;
	}

	public void setTransdate(int transdate) {
		this.transdate = transdate;
	}

	public String getTransname() {
		return transname;
	}

	public void setTransname(String transname) {
		this.transname = transname;
	}

	public String getTranstype() {
		return transtype;
	}

	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTransprice() {
		return transprice;
	}

	public void setTransprice(int transprice) {
		this.transprice = transprice;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "TransactionList [transno=" + transno + ", transdate=" + transdate + ", transname=" + transname
				+ ", transtype=" + transtype + ", quantity=" + quantity + ", transprice=" + transprice + ", totalprice="
				+ totalprice + ", client=" + client + "]";
	}

	public String getProno() {
		return prono;
	}

	public void setProno(String prono) {
		this.prono = prono;
	}

}
