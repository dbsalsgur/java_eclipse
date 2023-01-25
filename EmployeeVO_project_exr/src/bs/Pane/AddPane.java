package bs.Pane;

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

import bs.models.EmployeeDAO;
import bs.models.EmployeeVO;

public class AddPane extends JPanel implements ActionListener, ItemListener {
	
	private JPanel jp[] = new JPanel[6];
	private JLabel jl[] = new JLabel[5];
	private JTextField tf[] = new JTextField[5];
	private JButton okb;
	//ok버튼
	private JButton rsb;
	//reset(다시하기)버튼
	private int department = 10;
	//부서번호 기본값 10 설정
	
	String[] caption = {"이 름 :", "직 책 :", "메 일 :", "부 서 :"};
	
	public AddPane() {
		setLayout(new GridLayout(6,1));
		//페이지에 6행 1열의 공간 생성
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);
		//컴포넌트에 홈을 판다고 하나 하나도 안보임
		
		int size = caption.length;
		int i;
		for (i = 0; i < size-1; i++) {
			jp[i] = new JPanel();
			//Panel 객체 생성
			jl[i] = new JLabel(caption[i]);
			// caption의 i번째의 텍스트 담음, 이름 직책 메일 부서 순
			tf[i] = new JTextField(15);
			//TextField, 즉, 입력칸 생성. 인자는 크기
			jp[i].add(jl[i]);
			//패널에 caption 텍스트 붙이기
			jp[i].add(tf[i]);
			//패널에 입력칸 붙이기
			add(jp[i]);
			//완성된 패널 추가하기
		}
		jp[i] = new JPanel();
		jl[i] = new JLabel(caption[i]);
		jp[i].add(jl[i]);
		add(jp[i]);
		
		JComboBox combo = new JComboBox();
		combo.addItem("부서번호를 선택하세요");
		for (int c = 1; c <= 5; c++) {
			combo.addItem(c*10);
		}
		//부서번호 선택 가능하도록 콤보박스 생성, 내용은 10부터 50까지 
		jp[i].add(combo);
		combo.addActionListener(this);
		combo.addItemListener(this);
		
		jp[size] = new JPanel();
		okb = new JButton("저장하기");
		okb.addActionListener(this);
		rsb = new JButton("다시쓰기");
		rsb.addActionListener(this);
		jp[size].add(okb);
		jp[size].add(rsb);
		add(jp[size]);
		//버튼모양의 누르면 동작하는 컴포넌트 추가
	}

	
	@Override
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getStateChange() == ItemEvent.SELECTED)
			department = Integer.parseInt(ie.getItem().toString());
	}
	
	//선택된 부서번호가 이벤트 발생으로 선택된 부서번호와 같다면 
	//department에 선택한 부서번호 담음

	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand();
		EmployeeVO evo = null;
		EmployeeDAO edvo = null;
		if (ae_type.equals(okb.getText())) {
			//저장하기 누르면 실행
			try {
				evo = new EmployeeVO(0, tf[0].getText(), tf[1].getText(), department, tf[2].getText());
				//입력칸에 입력된 문자를 모두 evo객체에 담음
				edvo = new EmployeeDAO();
				edvo.getEmployeeregiste(evo);
				//데이터 저장하는 메소드 실행
			} catch (Exception e) {
				System.out.println("e=["+e+"e");
			}
			if(edvo != null)
				JOptionPane.showMessageDialog(this, tf[0].getText()+"님이 성공적으로 추가됨");
			//edvo가 잘 처리되면 입력한 이름+님이 성공적으로 추가됨 출력
		} else if(ae_type.equals(rsb.getText())){
			//다시쓰기 누르면 실행
			int size = caption.length;
			for (int i = 0; i < size-1; i++) {
				tf[i].setText("");
			}
			//모든 입력칸을 공백으로 만듬
		}
	}
	//이벤트 발생시 실행됨.
}
