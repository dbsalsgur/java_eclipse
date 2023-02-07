package ccsp.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import ccsp.models.CrimeRecordVO;
import ccsp.models.CrimeSysDAO;
import ccsp.models.CrimeTableModel;
import ccsp.utils.StringMethod;

public class LookupByConditionPane2 extends JPanel implements ActionListener, ItemListener {
	// caption은 범죄번호 / 이름 / 주민등록번호 / 성별 / 지역 / 발생일자 / 범죄번호 순으로 입력할 것
	private String[] caption = { "범죄번호 : ", "이름 : ", "주민등록번호 : ", "성별 : ", "지역 : ", "발생일자 : ", "전과 : ", "범죄분류 : " };
	private JPanel lookupPanel = new JPanel();
	private JPanel tablePanel = new JPanel();
	private JPanel btnTemp = new JPanel();
	private JPanel temp = new JPanel();
	private JPanel jp[] = new JPanel[9]; // 라벨, 필드, 버튼
	private JLabel jl[] = new JLabel[8]; // 툴바(단순 문자열), 이름, 직책...
	private int textFieldPanelSize = 4;
	private int cbboxPanelSize = caption.length - textFieldPanelSize;
	private JButton okb; // 저장하기
	private JButton rsb; // 다시쓰기
	private JButton initb; // 다시쓰기
	private JComboBox cbbox[] = new JComboBox[cbboxPanelSize];
	private JTextField tf[] = new JTextField[textFieldPanelSize]; // 툴바(한 줄 문자열 입력받는)
	private JTable resultTable;
	private JScrollPane pane;
	private CrimeTableModel tmodel;
	private JScrollPane scroll;
	private boolean flag = false;

	public LookupByConditionPane2() {
		tablePanel.setLayout(new BorderLayout());
		lookupPanel.setLayout(new GridLayout(10, 1));

		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);
		CrimeSysDAO crDAO = new CrimeSysDAO();
		ArrayList<String> list;
		int size = caption.length;

		int j = 0;
		int k = 0;
		for (int i = 0; i < caption.length; i++) {
			jp[i] = new JPanel();
			jl[i] = new JLabel(caption[i]);
			jp[i].add(jl[i]);
			if (caption[i] == caption[2] || caption[i] == caption[4] || caption[i] == caption[6]
					|| caption[i] == caption[7]) {
				JComboBox combo = new JComboBox();
				if (caption[i] == caption[2]) {
					list = crDAO.getCrimeSexTableData();
					combo.addItem("성별 선택하세요.");
					addCbboxItem(combo, list);
				} else if (caption[i] == caption[4]) {
					list = crDAO.getCrimeRegionTableData();
					combo.addItem("지역 선택하세요.");
					addCbboxItem(combo, list);
				} else if (caption[i] == caption[6]) {
					list = crDAO.getCRecordTableData();
					combo.addItem("전과여부 선택하세요.");
					addCbboxItem(combo, list);
				} else if (caption[i] == caption[7]) {
					list = crDAO.getCrimeCategoryTableData();
					combo.addItem("범죄분류 선택하세요.");
					addCbboxItem(combo, list);
				}
				jp[i].add(combo);
				cbbox[k] = combo;
				combo.addActionListener(this);
				combo.addItemListener(this);
				k++;
			} else {

				tf[j] = new JTextField(15); // 동일한 크기 15칸
				jp[i].add(tf[j]);
				j++;

			}
			// 패널을 패널에 추가
			lookupPanel.add(jp[i]);
			add(lookupPanel);

		}

		jp[size] = new JPanel();
		okb = new JButton("조회하기");
		okb.addActionListener(this);
		rsb = new JButton("초기화");
		rsb.addActionListener(this);
		jp[size].add(okb); // 저장1`
		jp[size].add(rsb); // 다시
		lookupPanel.add(jp[size]); // 저장, 다시쓰기를 추가

		initb = new JButton("돌아가기");
		initb.addActionListener(this);
		btnTemp.add(initb);
		tablePanel.setVisible(false);
		add(tablePanel);
	}

	// 배열을 통해 콤보박스에 자동으로 값 넣어주는 메서드
	public void addCbboxItem(JComboBox cbbox, ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			cbbox.addItem(i + 1 + " " + list.get(i));
		}

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand();
		CrimeRecordVO crVO = new CrimeRecordVO();
		CrimeSysDAO crDAO = new CrimeSysDAO();

		// 조회하기 버튼
		if (ae_type.equals(okb.getText())) {
			// 범죄번호, 이름, 주민번호, 발생일자
			// 성별, 지역, 범죄분류
			try {
				for (int i = 0; i < tf.length; i++) {
					if (i == 0) {
						if (tf[i].getText().isBlank() != true) {
							crVO.setCrimNo(Integer.parseInt(tf[i].getText()));
						} else {
							crVO.setCrimNo(0);
						}
					}

					if (i == 1) {
						if (tf[i].getText().isBlank() != true) {
							crVO.setName(tf[i].getText());
						} else {
							crVO.setName("");
						}
					}

					if (i == 2) {
						if (tf[i].getText().isBlank() != true) {
							crVO.setRegitNumber(Integer.parseInt(tf[i].getText()));
						} else {
							crVO.setRegitNumber(0);
						}
					}

					if (i == 3) {
						if (tf[i].getText().isBlank() != true) {
							crVO.setDate(tf[i].getText());
						} else {
							crVO.setDate("");
						}
					}
					if (i < 4) {
						if (cbbox[i].getSelectedIndex() != 0) {
							int selectedItem;

							if (i == 0) {
								selectedItem = StringMethod.stringSplitBySpace(cbbox, i);
								crVO.setSex(selectedItem);
							}
							if (i == 1) {
								selectedItem = StringMethod.stringSplitBySpace(cbbox, i);
								crVO.setRegion(selectedItem);
							}
							if (i == 2) {
								selectedItem = StringMethod.stringSplitBySpace(cbbox, i);
								crVO.setcRecord(selectedItem);
							}
							if (i == 3) {
								selectedItem = StringMethod.stringSplitBySpace(cbbox, i);
								crVO.setCrimDivNo(selectedItem);
							}
						} else {
							if (i == 0) {
								crVO.setSex(0);
							}
							if (i == 1) {
								crVO.setRegion(0);
							}
							if (i == 2) {
								crVO.setcRecord(0);
							}
							if (i == 3) {
								crVO.setCrimDivNo(0);
							}
						}
					}
				}
				ArrayList<CrimeRecordVO> crVOArr = crDAO.getRecordByRandomCondition(crVO);
				tablePanel.removeAll();
				temp.removeAll();
				tmodel = new CrimeTableModel(crVOArr);
				resultTable = new JTable(tmodel);
				scroll = new JScrollPane(resultTable);
				temp.add(scroll);
				tablePanel.add(btnTemp, BorderLayout.NORTH);
				tablePanel.add(temp, BorderLayout.CENTER);
				lookupPanel.setVisible(false);
				tablePanel.setVisible(true);
			} catch (

			NumberFormatException e) {
				e.printStackTrace();

				System.out.println("항목에 올바른 값을 입력해주세요."); // alert로 바꾸기
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 초기화 버튼
		if (ae_type.equals(rsb.getText()))

		{
			for (int i = 0; i < textFieldPanelSize; i++) {
				tf[i].setText("");
			}
			for (int i = 0; i < cbboxPanelSize; i++) {
				cbbox[i].setSelectedIndex(0);
			}
		}

		if (ae_type.equals(initb.getText())) {
			lookupPanel.setVisible(true);
			tablePanel.setVisible(false);
		}

		try { // 사용자가 입력한 변수로 초기화?
			crVO = new CrimeRecordVO();
			crDAO = new CrimeSysDAO();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("e=[" + e + "]");
		}

	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		if (ie.getStateChange() == ItemEvent.SELECTED) {
//			department = Integer.parseInt(ie.getItem().toString());
			// TODO Auto-generated method stub
		}
	}

}
