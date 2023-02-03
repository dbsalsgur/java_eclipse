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

public class AddPanel extends JPanel implements ItemListener, ActionListener {

	private JPanel jp[] = new JPanel[8];
	private JLabel jl[] = new JLabel[7];
	private JTextField tf[] = new JTextField[7];
	private JButton insert;
	//ok(추가하기) 버튼
	private JButton reset;
	//reset(다시하기)버튼
	JComboBox rcombo = new JComboBox();
	JComboBox scombo = new JComboBox();
	JComboBox ctgycombo = new JComboBox();
	JComboBox crcombo = new JComboBox();
	JComboBox[] comboBoxes = {rcombo, scombo, ctgycombo, crcombo};
	
	String[] caption = {"분류번호 : ", "지        역 : ", "성        별 : ", "전        과 : ", "이        름 : ", "주민번호 : ", "발생일자 : "};

	
	public AddPanel() {
		setLayout(new GridLayout(9,1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);
		ArrayList<String> regionDataList = new ArrayList<String>();
		ArrayList<String> sexDataList = new ArrayList<String>();
		ArrayList<String> categoryDataList = new ArrayList<String>();
		ArrayList<String> cRecordDataList = new ArrayList<String>();
		CriminalDAO crDAO = new CriminalDAO();
		
		int size = caption.length;

		for (int i = 0; i <= 3; i++) {
			jl[i] = new JLabel(caption[i]);
			jp[i] = new JPanel();
			jp[i].add(jl[i]);
//			jp[i].add(comboBoxes[i]);
			add(jp[i]);
		}
		for (int i = 4; i < size; i++) {
			jl[i] = new JLabel(caption[i]);
			tf[i] = new JTextField(10);
			jp[i] = new JPanel();
			jp[i].add(jl[i]);
			jp[i].add(tf[i]);
			add(jp[i]);
			tf[i].setEditable(true);
		}
		
		
		
		ctgycombo.addItem("번호를   선택하세요");
		categoryDataList = crDAO.getCrimeCategoryTableData();
		addCbboxItem(ctgycombo, categoryDataList);
		jp[0].add(ctgycombo);
		ctgycombo.addActionListener(this);
		ctgycombo.addItemListener(this);
		
		rcombo.addItem("지역을   선택하세요");
		regionDataList = crDAO.getCrimeRegionTableData();
		addCbboxItem(rcombo, regionDataList);
		jp[1].add(rcombo);
		rcombo.addActionListener(this);
		rcombo.addItemListener(this);
		
		scombo.addItem("성별을   선택하세요");
		sexDataList = crDAO.getCrimeSexTableData();
		addCbboxItem(scombo, sexDataList);
		jp[2].add(scombo);
		scombo.addActionListener(this);
		scombo.addItemListener(this);
		
		crcombo.addItem("전과를   선택하세요");
		cRecordDataList = crDAO.getCrimeRecordTableData();
		addCbboxItem(crcombo, cRecordDataList);
		jp[3].add(crcombo);
		crcombo.addActionListener(this);
		crcombo.addItemListener(this);
		
		
		jp[size] = new JPanel();
		insert = new JButton("추가하기");
		insert.addActionListener(this);
		reset = new JButton("다시쓰기");
		reset.addActionListener(this);
		jp[size].add(insert);
		jp[size].add(reset);
		add(jp[size]);
		
	}
	
	public void addCbboxItem(JComboBox cbbox, ArrayList<String> list) {
		for (int i = 1; i <= list.size(); i++) {
			cbbox.addItem(i+". "+list.get(i-1));
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand();
		CrimeRecordVO crVO = null;
		CriminalDAO crDAO = null;
		int crimNo = 0;
		int regitNumInput = 0;
		if (ae_type.equals(insert.getText())) {
			try {
				regitNumInput = Integer.parseInt(tf[5].getText().trim());
				crVO = new CrimeRecordVO(0, rcombo.getSelectedIndex(), scombo.getSelectedIndex(), crcombo.getSelectedIndex(), tf[4].getText().trim(), regitNumInput, tf[6].getText().trim(), ctgycombo.getSelectedIndex());
				
			} catch (Exception e) {
				System.out.println("input error");
				System.out.println("e=["+e+"e");
			}
			if (crVO != null) {
				JOptionPane.showMessageDialog(this, tf[4].getText()+"님이 성공적으로 추가됨");
			}
		} else if(ae_type.equals(reset.getText())) {
			for (int i = 0; i < tf.length; i++) {
				tf[i].setText("");
			}
			for (int i = 0; i < comboBoxes.length; i++) {
				comboBoxes[i].setSelectedIndex(0);
			}
		}
	}



}
