package Inven_View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import Inven_Controller.ProductDAO;
import Inven_Model.ProductVO;

//입고처리 탭
public class ProductPane extends JPanel implements ActionListener, ItemListener {
	private JPanel jp[] = new JPanel[6];
	private JLabel jl[] = new JLabel[5];
	private JTextField tf[] = new JTextField[5];
	private JButton okb;
	private JButton rsb;
	private String protype;

	String[] caption = { "제품코드 : ", "품명 : ", "종류 : ", "단가 : ", "수량 : " };

	public ProductPane() {
		setLayout(new GridLayout(6, 1));
		EtchedBorder eb = new EtchedBorder(); // 경계선 만들기 : 컴포넌트 주위에 홈이 파여있는 모양의 객체
		setBorder(eb);

		int size = caption.length;
		int i;
		for (i = 0; i < 2; i++) {
			jp[i] = new JPanel();
			jl[i] = new JLabel(caption[i]);
			tf[i] = new JTextField(15);
			jp[i].add(jl[i]);
			jp[i].add(tf[i]);
			add(jp[i]);
		}

		jp[2] = new JPanel();
		jl[2] = new JLabel(caption[2]);
		jp[2].add(jl[2]);
		add(jp[2]);

		JComboBox combo = new JComboBox(); // 콤보박스 객체
		combo.addItem("제품 종류를 선택하세요.");
		combo.addItem("상의");
		combo.addItem("하의");
		combo.addItem("아우터");
		combo.addItem("악세사리");

		jp[2].add(combo);
		combo.addActionListener(this);
		combo.addItemListener(this);

		int j;
		for (j = 3; j < 5; j++) {
			jp[j] = new JPanel();
			jl[j] = new JLabel(caption[j]);
			tf[j] = new JTextField(15);
			jp[j].add(jl[j]);
			jp[j].add(tf[j]);
			add(jp[j]);
		}

		jp[size] = new JPanel();
		okb = new JButton("저장");
		okb.addActionListener(this);
		rsb = new JButton("다시쓰기");
		rsb.addActionListener(this);
		
		jp[size].add(okb);
		jp[size].add(rsb);
		add(jp[size]);

	}

	public void actionPerformed(ActionEvent ae) { // 이벤트가 발생했을 때
		// Action : 키보드를 사용해 button을 동작시켰을 때 실행
		// getActionCommand() : button에 담긴 string 값을 얻어와 반환
		String ae_type = ae.getActionCommand(); // 전달된 문자열 ae_type에 저장
		ProductVO pvo = null;
		ProductDAO pdvo = null;
		if (ae_type.equals(okb.getText())) {
			try {// 사용자가 입력한 값으로 ProductVO 객체 초기화
					// s s s i i
				pvo = new ProductVO(tf[0].getText(), tf[1].getText(), protype, Integer.parseInt(tf[3].getText()),
						Integer.parseInt(tf[4].getText()));
				pdvo = new ProductDAO();

				pdvo.InsertProduct(pvo);

			} catch (Exception e) {
				System.out.println("예외발생");
			}
			if (pdvo != null) // 객체가 성공적으로 만들어졌다면
				JOptionPane.showMessageDialog(this, tf[0].getText() + "입고 처리 완료");
		} else if (ae_type.equals(rsb.getText())) { // 다시쓰기를 눌렀다면
			int size = caption.length;
			for (int i = 0; i < size - 1; i++) {
				tf[i].setText(""); // 공백으로 세팅
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		// TODO Auto-generated method stub
		if (ie.getStateChange() == ItemEvent.SELECTED)
			protype = ie.getItem().toString();

	}

}
