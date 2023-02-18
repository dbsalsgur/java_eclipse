package ccsp.view;

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

import ccsp.models.CrimeRecordVO;
import ccsp.models.CrimeSysDAO;
import ccsp.models.CrimeTableModel;
import ccsp.utils.StringMethod;

public class LookupByConditionPane extends JPanel implements ActionListener, ItemListener {
	// caption은 범죄번호 / 이름 / 주민등록번호 / 성별 / 지역 / 발생일자 / 범죄번호 순으로 입력할 것
	private String[] caption = { "범죄번호 : ", "이름 : ", "성별 : ", "주민등록번호 : ", "지역 : ", "발생일자 : ", "전과 : ", "범죄분류 : " };
	private JPanel jp[] = new JPanel[9]; // 라벨, 필드, 버튼
	private JLabel jl[] = new JLabel[8]; // 툴바(단순 문자열), 이름, 직책...
	private int textFieldPanelSize = 4;
	private int cbboxPanelSize = caption.length - textFieldPanelSize;
	private JButton okb; // 저장하기
	private JButton rsb; // 다시쓰기
	private JComboBox cbbox[] = new JComboBox[cbboxPanelSize];
	private JTextField tf[] = new JTextField[textFieldPanelSize]; // 툴바(한 줄 문자열 입력받는)
	private JTable lookupTable;
	private JScrollPane lookupPane;
	private JTable table;
	private JScrollPane pane;
//	private int[] cbboxValue = new int[3];

	public LookupByConditionPane() {

		setLayout(new GridLayout(10, 1));
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
			add(jp[i]);

		}

		jp[size] = new JPanel();
		okb = new JButton("조회하기");
		okb.addActionListener(this);
		rsb = new JButton("초기화");
		rsb.addActionListener(this);
		jp[size].add(okb); // 저장
		jp[size].add(rsb); // 다시
		add(jp[size]); // 저장, 다시쓰기를 추가

	}

	// 배열을 통해 콤보박스에 자동으로 값 넣어주는 메서드
	public void addCbboxItem(JComboBox cbbox, ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			cbbox.addItem(i + 1 + " " + list.get(i));
		}

	}

	@Override
	public void actionPerformed(ActionEvent ae) { // 버튼눌렀을 때 실행하는 이벤트가 발생했을때 어떤일을 할지 기재하는 메서드
		// TODO Auto-generated method stub
		// getActionCommand=버튼에 담긴 string값을 얻어서 반환
		String ae_type = ae.getActionCommand();
		CrimeRecordVO crVO = new CrimeRecordVO();
		CrimeSysDAO crDAO = new CrimeSysDAO();

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
					// cbbox에 넣어진 값을 확인하여 값이 있으면 crVO에 넣고 없으면 0으로 넣기
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
				CrimeTableModel tmodel = new CrimeTableModel(crVOArr);
				lookupTable = new JTable(tmodel);
				lookupPane = new JScrollPane(lookupTable);
				add(lookupPane, 0);

			} catch (NumberFormatException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "항목에 올바른 값을 입력해주세요."); // alert로 바꾸기
			} catch (Exception e) {
				e.printStackTrace();
			}

//			System.out.println("---------------");
//			System.out.println(crVO.getCrimNo());
//			System.out.println(crVO.getName());
//			System.out.println(crVO.getRegitNumber());
//			System.out.println(crVO.getDate());
//			System.out.println(crVO.getSex());
//			System.out.println(crVO.getRegion());
//			System.out.println(crVO.getcRecord());
//			System.out.println(crVO.getCrimDivNo());
		}

		if (ae_type.equals(rsb.getText())) {
			for (int i = 0; i < textFieldPanelSize; i++) {
				tf[i].setText("");
			}
			for (int i = 0; i < cbboxPanelSize; i++) {
				cbbox[i].setSelectedIndex(0);
			}
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
