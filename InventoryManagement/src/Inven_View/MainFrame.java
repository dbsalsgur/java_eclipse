package Inven_View;//완

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {
	private JTabbedPane jtp; 
	
	private ProductPane pp;//입고처리
	private ProductFindPane pfp;//재고조회
	private ProductTotalPane ptp;//재고현황
	
	private DeletePane dp;//제품삭제
	
	private TransactionPane tp;// 출고탭
	private TransactionFindPane tfp;//거래조회탭
	private TransactionTotalPane ttp;// 전체조회탭
	
	private ClientPane cp;

	public MainFrame() throws Exception {
		jtp = new JTabbedPane();
		
		pp = new ProductPane();
		pfp = new ProductFindPane();
		ptp = new ProductTotalPane();
		dp = new DeletePane();
		
		tp = new TransactionPane();
		tfp = new TransactionFindPane();
		ttp = new TransactionTotalPane();
		cp = new ClientPane();

		jtp.addTab("입고처리", pp);
		jtp.addTab("出庫処理", tp);
		jtp.addTab("제품삭제", dp);
		
		jtp.addTab("재고조회", pfp);
		jtp.addTab("거래조회", tfp);
		
		jtp.addTab("재고현황", ptp);
		jtp.addTab("取引現状", ttp);
		jtp.addTab("거래처", cp);

		getContentPane().add(jtp);
		setTitle("取引管理");

		pack(); //묶음, 정리
		setVisible(true); //화면상에 보여줌
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x(닫기) 버튼 활성화

	}

	public static void main(String args[]) throws Exception {
		new MainFrame(); //main frame class instance화, 생성자 호출
	}

}

