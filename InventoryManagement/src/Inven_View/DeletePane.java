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
import javax.swing.border.EtchedBorder;

import Inven_Controller.ProductDAO;
import Inven_Controller.TransactionDAO;
import Inven_Model.ProductVO;

public class DeletePane extends JPanel implements ActionListener, ItemListener {
	private JPanel jp[] = new JPanel[6];
	private JLabel jl[] = new JLabel[5];
	private JButton dlb;

	private String procode;

	String[] caption = { "제품코드 : " };
	private JComboBox cbbox = new JComboBox();

	public DeletePane() throws Exception {
		setLayout(new GridLayout(6, 1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);

		int size = caption.length;

		jp[0] = new JPanel();
		jl[0] = new JLabel(caption[0]);
		jp[0].add(jl[0]);
		add(jp[0]);

		cbbox = displayProcode();
		jp[0].add(cbbox);

		cbbox.addActionListener(this);
		cbbox.addItemListener(this);

		jp[0] = new JPanel();
		dlb = new JButton("삭제");
		dlb.addActionListener(this);
		jp[0].add(dlb);
		add(jp[0]);
	}

	public JComboBox displayProcode() throws Exception {// 제품코드 불러오기

		TransactionDAO tdao = new TransactionDAO();
		ArrayList<String> prolist = tdao.getProcode();

		cbbox.addItem("제품코드를 선택해주세요.");

		for (int i = 0; i < prolist.size(); i++) {
			cbbox.addItem(prolist.get(i));
		}
		return cbbox;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand(); // 전달된 문자열 ae_type에 저장
		ProductVO pvo = null;
		ProductDAO pdvo = null;

		if (ae_type.equals(dlb.getText())) {

			try {
				pvo = new ProductVO();
				pdvo = new ProductDAO();
				pvo.setProcode((String) cbbox.getSelectedItem());

				pdvo.DeleteProduct(pvo);

			} catch (Exception e) {
				System.out.println("재고삭제 예외발생");
			}

			if (pvo.getProcode() == "제품코드를 선택해주세요.")
				JOptionPane.showMessageDialog(this, "제품코드를 선택해주세요.");
			else if (pdvo != null) // 객체가 성공적으로 만들어졌다면
				JOptionPane.showMessageDialog(this, pvo.getProcode() + " 제품 삭제 완료");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {// 콤보박스 내용 변경
		if (ie.getStateChange() == ItemEvent.SELECTED)
			procode = ie.getItem().toString();
		System.out.println(procode);
	}

}
