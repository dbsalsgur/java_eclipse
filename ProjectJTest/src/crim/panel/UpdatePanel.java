package crim.panel;

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
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import crim.models.CrimeRecordVO;
import crim.models.CriminalDAO;


public class UpdatePanel extends JPanel implements ActionListener, ItemListener {
	
	private JPanel jp[] = new JPanel[8];
	private JPanel keyP = new JPanel();
	private JLabel jl[] = new JLabel[7];
	private JLabel keyL = new JLabel();
	private JLabel arrowL = new JLabel();
	private JTextField tf[] = new JTextField[7];
	private JTextField keyF = new JTextField();
	private JTextField answerF[] = new JTextField[4];
	private JButton search;
	private JButton update;
	//ok(수정하기) 버튼
	private JButton reset;
	//reset(다시하기)버튼
	private int regionNo = 1;
	private int sexNo = 1;
	private int crimDivNo = 1;
	JComboBox rcombo = new JComboBox();
	JComboBox scombo = new JComboBox();
	JComboBox ctgycombo = new JComboBox();
	JComboBox[] comboBoxes = {rcombo, scombo, ctgycombo};
	
	String[] caption = {"분류번호 : ", "지        역 : ", "성        별 : ", "전        과 : ", "이        름 : ", "주민번호 : ", "발생일자 : "};

	
	public UpdatePanel() {
		setLayout(new GridLayout(10,1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);
		ArrayList<String> regionDataList = new ArrayList<String>();
		ArrayList<String> sexDataList = new ArrayList<String>();
		ArrayList<String> categoryDataList = new ArrayList<String>();
		CriminalDAO crDAO = new CriminalDAO();
		
		int size = caption.length;
		
		keyL = new JLabel("범죄번호 : ");
		keyF = new JTextField(10);
		keyP = new JPanel();
		keyP.add(keyL);
		keyP.add(keyF);
		search = new JButton("찾기");
		search.addActionListener(this);
		keyP.add(search);
		add(keyP);
		keyF.setEditable(true);
		
		for (int i = 0; i <= 2; i++) {
			jl[i] = new JLabel(caption[i]);
			tf[i] = new JTextField(10);
			arrowL = new JLabel(" → ");
			jp[i] = new JPanel();
			jp[i].add(jl[i]);
			jp[i].add(tf[i]);
			jp[i].add(arrowL);
			jp[i].add(comboBoxes[i]);
			add(jp[i]);
			tf[i].setEditable(false);
		}
		for (int i = 3; i < size; i++) {
			jl[i] = new JLabel(caption[i]);
			tf[i] = new JTextField(10);
			arrowL = new JLabel(" → ");
			answerF[i-3] = new JTextField(12);
			jp[i] = new JPanel();
			jp[i].add(jl[i]);
			jp[i].add(tf[i]);
			jp[i].add(arrowL);
			jp[i].add(answerF[i-3]);
			add(jp[i]);
			tf[i].setEditable(false);
			answerF[i-3].setEditable(true);
		}
		
		
		ctgycombo.addItem("번호를   선택하세요");
		for (int i = 1; i <= 15; i++) {
			ctgycombo.addItem(i);
		}
//		categoryDataList = crDAO.getCrimeCategoryTableData();
//		addCbboxItem(ctgycombo, categoryDataList);
		jp[0].add(ctgycombo);
		ctgycombo.addActionListener(this);
		ctgycombo.addItemListener(this);
		
		rcombo.addItem("지역을   선택하세요");
		for (int i = 1; i <= 17; i++) {
			rcombo.addItem(i);
		}
//		regionDataList = crDAO.getCrimeRegionTableData();
//		addCbboxItem(rcombo, regionDataList);
		jp[1].add(rcombo);
		rcombo.addActionListener(this);
		rcombo.addItemListener(this);
		
		scombo.addItem("성별을   선택하세요");
		for (int i = 1; i <= 2; i++) {
			scombo.addItem(i);
		}
//		sexDataList = crDAO.getCrimeSexTableData();
//		addCbboxItem(scombo, sexDataList);
		jp[2].add(scombo);
		scombo.addActionListener(this);
		scombo.addItemListener(this);
		
		
		jp[size] = new JPanel();
		update = new JButton("수정하기");
		update.addActionListener(this);
		reset = new JButton("다시쓰기");
		reset.addActionListener(this);
		jp[size].add(update);
		jp[size].add(reset);
		add(jp[size]);
		
	}
	
	public void addCbboxItem(JComboBox cbbox, ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			cbbox.addItem(list.get(i));
		}
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getStateChange() == ItemEvent.SELECTED) {
			if(ie.getSource().equals(rcombo.getSelectedItem())) {
				regionNo = Integer.parseInt(ie.getItem().toString());
			} else if(ie.getSource().equals(scombo.getSelectedItem())) {
				sexNo = Integer.parseInt(ie.getItem().toString());
			} else if(ie.getSource().equals(ctgycombo.getSelectedItem())) {
				crimDivNo = Integer.parseInt(ie.getItem().toString());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand();
		CrimeRecordVO crVO = null;
		CriminalDAO crDAO = null;
		int crimNo = 0;
		int regitNumInput = 0;
		if (ae_type.equals(search.getText())) {
			try {
				crDAO = new CriminalDAO();
				String sno = keyF.getText().trim();
				
				if (!sno.equals("")) {
					int no = Integer.parseInt(sno);
					crVO = crDAO.getCriminalCheck(no);
				}
			} catch (Exception e) {
				System.out.println("e=["+e+"e");
			}
			if (crVO != null) {
				tf[0].setText(crVO.getCrimDivNo()+"");
				tf[1].setText(crVO.getRegion()+"");
				tf[2].setText(crVO.getSex()+"");
				tf[3].setText(crVO.getcRecord());
				tf[4].setText(crVO.getName()+"");
				tf[5].setText(crVO.getRegitNumber()+"");
				tf[6].setText(crVO.getDate()+"");
				answerF[0].setText(crVO.getcRecord()+"");
				answerF[1].setText(crVO.getName()+"");
				answerF[2].setText(crVO.getRegitNumber()+"");
				answerF[3].setText(crVO.getDate()+"");
			} else {
				JOptionPane.showMessageDialog(this, "검색 실패");
			}
		} else if(ae_type.equals(update.getText())) {
			try {
				crimNo = Integer.parseInt(keyF.getText().trim());
				regitNumInput = Integer.parseInt(answerF[2].getText().trim());
				crVO = new CrimeRecordVO(crimNo, regionNo, sexNo, answerF[0].getText().trim(), answerF[1].getText().trim(), regitNumInput, answerF[3].getText().trim(), crimDivNo);
				crDAO = new CriminalDAO();
				crDAO.getCriminalUpdate(crVO);
			} catch (Exception e) {
				System.out.println("input error");
				System.out.println("e=["+e+"e");
			}
			if(crVO != null) {
				JOptionPane.showMessageDialog(this, "범죄자 "+answerF[0].getText()+"의"+"\n"+"신상정보가 수정되었습니다!");
			} else {
				JOptionPane.showMessageDialog(this, "잘못 입력하셨습니다"+"\n"+"입력 내용을 다시 확인해주세요.");
			}
		} else if(ae_type.equals(reset.getText())) {
			for (int i = 0; i < answerF.length; i++) {
				answerF[i].setText("");
			}
			for (int i = 0; i < comboBoxes.length; i++) {
				comboBoxes[i].setSelectedIndex(0);
			}
		}
	}


}
