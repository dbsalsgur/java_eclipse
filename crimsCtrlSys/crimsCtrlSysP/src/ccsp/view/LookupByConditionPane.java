package ccsp.view;

import java.awt.Container;
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
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import ccsp.models.CrimeRecordVO;
import ccsp.models.CrimeSysDAO;

public class LookupByConditionPane extends JPanel implements ActionListener, ItemListener {
	private String[] caption = { "범죄번호 : ", "이름 :", "주민등록번호:", "성별:", "지역:", "발생일자:", "범죄분류: " };
	private JPanel jp[] = new JPanel[8]; // 라벨, 필드, 버튼
	private JLabel jl[] = new JLabel[7]; // 툴바(단순 문자열), 이름, 직책...
	private int textFieldPanelSize = 4;
	private int cbboxPanelSize = caption.length - textFieldPanelSize;
	private JButton okb; // 저장하기
	private JButton rsb; // 다시쓰기
	private JComboBox cbbox[] = new JComboBox[cbboxPanelSize];
	private JTextField tf[] = new JTextField[textFieldPanelSize]; // 툴바(한 줄 문자열 입력받는)
	private String[] cbboxValue = new String[3];
//	private ArrayList<JTextField> tfArr;
//	private ArrayList<JComboBox> cbArr;

	public LookupByConditionPane() {

		setLayout(new GridLayout(8, 1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);
		CrimeSysDAO crDAO = new CrimeSysDAO();
		ArrayList<String> list;
		int size = caption.length;

		int i;
		int j = 0;
		int k = 0;
		for (i = 0; i < caption.length; i++) {
			jp[i] = new JPanel();
			jl[i] = new JLabel(caption[i]);
			jp[i].add(jl[i]);
			if (caption[i] == "성별:" || caption[i] == "지역:" || caption[i] == "범죄분류: ") {
				JComboBox combo = new JComboBox();
				if (caption[i] == "성별:") {
					list = crDAO.getCrimeSexTableData();
					combo.addItem("성별 선택하세요.");
					addCbboxItem(combo, list);
				} else if (caption[i] == "지역:") {
					list = crDAO.getCrimeRegionTableData();
					combo.addItem("지역 선택하세요.");
					addCbboxItem(combo, list);
				} else if (caption[i] == "범죄분류: ") {
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

	public void addCbboxItem(JComboBox cbbox, ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			cbbox.addItem(list.get(i));
		}

	}

	@Override
	public void actionPerformed(ActionEvent ae) { // 버튼눌렀을 때 실행하는 이벤트가 발생했을때 어떤일을 할지 기재하는 메서드
		// TODO Auto-generated method stub
		// getActionCommand=버튼에 담긴 string값을 얻어서 반환
		String ae_type = ae.getActionCommand();
		CrimeRecordVO crVO = null;
		CrimeSysDAO crDAO = null;


		if (ae_type == "comboBoxChanged") {
			for (int i = 0; i < cbboxPanelSize; i++) {
				if (cbbox[i].getSelectedIndex() != '0') {
					if (i == 0) {
						cbboxValue[0] = (String) cbbox[0].getSelectedItem();
					}
					if (i == 1) {
						cbboxValue[1] = (String) cbbox[1].getSelectedItem();
					}
					if (i == 2) {
						cbboxValue[2] = (String) cbbox[2].getSelectedItem();

					}
				}
			}
		}

		if (ae_type.equals(okb.getText())) {
			
			for (int i = 0; i < cbbox.length; i++) {
				System.out.println(cbboxValue[i]);
			}

		}
		if (ae_type.equals(rsb.getText())) {
			System.out.println("실행");
			for (int i = 0; i < textFieldPanelSize; i++) {
				tf[i].setText("");
			}
			for (int i = 0; i < cbboxPanelSize; i++) {
				cbbox[i].setSelectedIndex(0);
				cbboxValue[i] = "";
			}
		}


		
		try

		{ // 사용자가 입력한 변수로 초기화?
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