package crim.main;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import crim.panel.TotalPanel;
import crim.panel.UpdatePanel;

public class MainFrame_crim extends JFrame {

	private JTabbedPane tp;
	private UpdatePanel up;
	private TotalPanel tpa;
	
	
	public MainFrame_crim() {
		tp = new JTabbedPane();
		up = new UpdatePanel();
		tpa = new TotalPanel();
		
		tp.addTab("범죄자 정보 수정", up);
		tp.addTab("범죄자 전체 보기", tpa);
		
		getContentPane().add(tp);
		setTitle("범죄자 관리 프로그램");
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MainFrame_crim();
	}

}
