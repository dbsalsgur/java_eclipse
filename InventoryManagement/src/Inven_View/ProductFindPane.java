package Inven_View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import Inven_Controller.ProductDAO;
import Inven_Model.ProductModel;
import Inven_Model.ProductVO;


//재고조회
public class ProductFindPane extends JPanel implements ActionListener, ItemListener {
	private JPanel jp[] = new JPanel[4];
	private JLabel jl[] = new JLabel[3];
	private JTextField tf[] = new JTextField[3];
	private JButton find;
	private JButton reset;
	private JButton init;
//	private String prolist;
	private JTable findTable;
	private JScrollPane scroll;
	String[] caption = { "製品コード : ", "品名 : " };
	private JPanel findPanel = new JPanel();
	private JPanel tablePanel = new JPanel();
	private JPanel btnTemp = new JPanel();
	private JPanel temp = new JPanel();	

	JComboBox ccombo = new JComboBox(); //제품코드 콤보박스 
	JComboBox ncombo = new JComboBox(); //제품명 콤보박스
	JComboBox[] comboBoxes = { ccombo, ncombo };
	
	private ProductDAO pdao = new ProductDAO();
	private ArrayList<String> product = pdao.getProcode(); //제품코드 ArrayList 선언
	private ArrayList<String> proname = pdao.getProname(); //제품명 ArrayList 선언 

	public ProductFindPane() throws Exception {
		tablePanel.setLayout(new BorderLayout());
		findPanel.setLayout(new GridLayout(3, 1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);

		int size = caption.length;

		jp[0] = new JPanel();
		jl[0] = new JLabel(caption[0]);
		jp[0].add(jl[0]);
		ccombo.addItem("코드를   선택하세요");
		product = pdao.getProcode();
		addCbboxItem(ccombo, product);
		jp[0].add(ccombo);
		ccombo.addActionListener(this);
		ccombo.addItemListener(this);
		findPanel.add(jp[0]);

		
		jp[1] = new JPanel();
		jl[1] = new JLabel(caption[1]);
		jp[1].add(jl[1]);
		ncombo.addItem("품명을   선택하세요");
		proname = pdao.getProname();
		addCbboxItem(ncombo, proname);
		jp[1].add(ncombo);
		ncombo.addActionListener(this);
		ncombo.addItemListener(this);
		findPanel.add(jp[1]);

		add(findPanel);
		
		jp[size] = new JPanel();
		find = new JButton("照会"); // 조회 버튼
		find.addActionListener(this);
		reset = new JButton("リセット"); // 리셋 버튼
		reset.addActionListener(this);
		jp[size].add(find);
		jp[size].add(reset);
		findPanel.add(jp[size]);
		
		init = new JButton("돌아가기");
		init.addActionListener(this);
		btnTemp.add(init);
		tablePanel.setVisible(false);
		add(tablePanel);
	}

	public void addCbboxItem(JComboBox combo, ArrayList<String> list) {
		for (int i = 1; i <= list.size(); i++) {
			combo.addItem(list.get(i-1));
		}
	}	

	public void actionPerformed(ActionEvent ae) { 
		String ae_type = ae.getActionCommand();
		ProductVO prVO = new ProductVO();
		ProductDAO prDAO = new ProductDAO();

		if (ae_type.equals(find.getText())) { //조회하기 버튼 관련 동작 

			try {
				
//				if (ccombo.getSelectedIndex() != 0) {
//					prVO.setProcode(ccombo.getSelectedItem().toString());
//				} else {
//					prVO.setProcode("");
//				}
//						
//					
//				
//				if (ncombo.getSelectedIndex() != 0) {
//					prVO.setProname(ncombo.getSelectedItem().toString());
//				} else {
//					prVO.setProname("");
//				}
				if (ccombo.getSelectedIndex() != 0 && ncombo.getSelectedIndex() != 0) {
					prVO.setProcode(ccombo.getSelectedItem().toString());
					prVO.setProname(ncombo.getSelectedItem().toString());
				} else if(ccombo.getSelectedIndex() != 0 && ncombo.getSelectedIndex() == 0) {
					prVO.setProcode(ccombo.getSelectedItem().toString());
					prVO.setProname("");
				} else if(ccombo.getSelectedIndex() == 0 && ncombo.getSelectedIndex() != 0) {
					prVO.setProcode("");
					prVO.setProname(ncombo.getSelectedItem().toString());
				}
				
				ArrayList<ProductVO> prVOArr = prDAO.getRecordByRandomCondition(prVO);
				tablePanel.removeAll();
				temp.removeAll();
				ProductModel tmodel = new ProductModel(prVOArr);
				
				findTable = new JTable(tmodel);
				scroll = new JScrollPane(findTable);
				temp.add(scroll);
				tablePanel.add(btnTemp, BorderLayout.NORTH);
				tablePanel.add(temp, BorderLayout.CENTER);
				findPanel.setVisible(false);
				tablePanel.setVisible(true);
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "항목에 올바른 값을 입력해주세요."); // alert로 바꾸기
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (ae_type.equals(reset.getText())) {
			
			for (int i = 0; i < comboBoxes.length; i++) {
				comboBoxes[i].setSelectedIndex(0);
			}
		} else if (ae_type.equals(init.getText())) {
			findPanel.setVisible(true);
			tablePanel.setVisible(false);
		}

		try { // 사용자가 입력한 변수로 초기화?
			prVO = new ProductVO();
			prDAO = new ProductDAO();

		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		}
	}			
			
	public void itemStateChanged(ItemEvent ie) {
//		if (ie.getStateChange() == ItemEvent.SELECTED)
//			prolist = ie.getItem().toString();
	}
	
}	
