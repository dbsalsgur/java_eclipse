package Inven_View;

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

import Inven_Controller.TransactionDAO;
import Inven_Model.ProductVO;
import Inven_Model.TransactionVO;

public class TransactionPane extends JPanel implements ActionListener, ItemListener {
	private JPanel jp[] = new JPanel[9];
	private JLabel jl[] = new JLabel[8];
	private JTextField tf[] = new JTextField[8];
	private JButton okb;
	private JButton rsb;
	private String procode;
	private ProductVO pi;
	private TransactionDAO tdao = new TransactionDAO();
	private ArrayList<String> prolist = tdao.getProcode();
	String[] caption = { "製品番号", "品名", "種類", "価格", "数量", "取引先", "取引日" };
	private JComboBox[] cbboxArr = new JComboBox[2];


	public TransactionPane() throws Exception {

		setLayout(new GridLayout(9, 1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);

		int size = caption.length;
		int i;

		jp[0] = new JPanel();
		jl[0] = new JLabel(caption[0]);

		jp[0].add(jl[0]);
		add(jp[0]);

		JComboBox cbbox = displayProcode();
		jp[0].add(cbbox);
		cbboxArr[0] = cbbox;

		cbbox.addActionListener(this);
		cbbox.addItemListener(this);

		for (i = 1; i < 4; i++) {// 품명~단가
			jp[i] = new JPanel();
			jl[i] = new JLabel(caption[i]);
			tf[i] = new JTextField(15);

			tf[i].setEditable(false);
			jp[i].add(jl[i]);
			jp[i].add(tf[i]);
			add(jp[i]);

		}

		jp[i] = new JPanel();
		jl[i] = new JLabel(caption[i]);
		tf[i] = new JTextField(15);
		jp[i].add(jl[i]);
		jp[i].add(tf[i]);
		add(jp[i]);
		i++;

		jp[i] = new JPanel();
		jl[i] = new JLabel(caption[i]);
		jp[i].add(jl[i]);
		add(jp[i]);
		JComboBox combo = displayClient();
		jp[i].add(combo);
		cbboxArr[1] = combo;

		combo.addActionListener(this);
		combo.addItemListener(this);

		i++;

		jp[i] = new JPanel();
		jl[i] = new JLabel(caption[i]);
		tf[i] = new JTextField(15);
		jp[i].add(jl[i]);
		jp[i].add(tf[i]);
		add(jp[i]);

		jp[i] = new JPanel();
		okb = new JButton("入力");
		okb.addActionListener(this);
		rsb = new JButton("リセット");
		rsb.addActionListener(this);
		jp[i].add(okb);
		jp[i].add(rsb);
		add(jp[i]);

	}

	public void autoInsert() throws Exception { // 제품코드 고르면 3개tf 자동입력
		TransactionDAO tdao = new TransactionDAO();
		ProductVO pi = tdao.getAutoProname((String) cbboxArr[0].getSelectedItem());

		for (int i = 1; i < 2; i++) {
			tf[i].setText(pi.getProname());
			tf[i + 1].setText(pi.getProtype());
			tf[i + 2].setText(Integer.toString(pi.getProprice()));
		}

	}

	public JComboBox displayClient() throws Exception {// 거래처리스트 불러오기

		TransactionDAO tdao = new TransactionDAO();

		ArrayList<String> list = tdao.getClient();

		JComboBox cbbox = new JComboBox();
		cbbox.addItem("거래처를 선택해주세요");
		for (int i = 0; i < list.size(); i++) {

			cbbox.addItem(list.get(i));
		}
		return cbbox;

	}

	public JComboBox displayProcode() throws Exception {// 제품코드 불러오기

		TransactionDAO tdao = new TransactionDAO();

		ArrayList<String> prolist = tdao.getProcode();

		JComboBox cbbox = new JComboBox();
		cbbox.addItem("제품번호를 선택해주세요");
		
		for (int i = 0; i < prolist.size(); i++) {

			cbbox.addItem(prolist.get(i));
		}
		return cbbox;

	}

	@Override
	public void itemStateChanged(ItemEvent ie) {// 콤보박스 내용 변경
		if (ie.getStateChange() == ItemEvent.SELECTED)
			procode = ie.getItem().toString();

		if (prolist.contains(procode)) {
			try {
				autoInsert();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent ae) {// 입력 ,리셋 버튼
		String ae_type = ae.getActionCommand();
		TransactionVO tl = null;
		TransactionDAO tdao = null;

		if (ae_type.equals(okb.getText())) {// 입력 버튼 눌렀을때 실행사항
			try {
				tl = new TransactionVO(cbboxArr[0].getSelectedItem().toString(), tf[1].getText(),
						Integer.parseInt(tf[3].getText()), Integer.parseInt(tf[4].getText()),
						cbboxArr[1].getSelectedItem().toString(), Integer.parseInt(tf[6].getText()));

				tdao = new TransactionDAO();
				tdao.getTransactionExecute(tl);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "정확히 입력 해 주세요");
			}
			if (tdao != null)
				JOptionPane.showMessageDialog(this, "거래가 성공적으로 입력됐습니다");
		} else if (ae_type.equals(rsb.getText())) {
			int size = caption.length;// 리셋버튼 눌렀을때
			for (int i = 1; i <= 4; i++) {
				tf[i].setText("");

			}
			for (int i = 6; i < 7; i++) {
				tf[i].setText("");
			}
		}
	}

}