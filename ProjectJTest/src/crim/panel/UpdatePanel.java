package crim.panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;


public class UpdatePanel extends JPanel implements ActionListener, ItemListener {
	
	private JPanel jp[] = new JPanel[8];
	private JPanel keyP = new JPanel();
	private JLabel jl[] = new JLabel[7];
	private JLabel keyL = new JLabel();
	private JTextField tf[] = new JTextField[7];
	private JTextField keyF = new JTextField();
	private JTextField answerF[] = new JTextField[7];
	private JButton okb;
	//ok(수정하기) 버튼
	private JButton rsb;
	//reset(다시하기)버튼
	
	String[] caption = {"지        역 : ", "성        별 : ", "전        과 : ", "이        름 : ", "주민번호 : ", "발생일자 : ", "분류번호 : "};

	
	public UpdatePanel() {
		setLayout(new GridLayout(10,1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);
		
		int size = caption.length;
		
		keyL = new JLabel("범죄번호 : ");
		keyF = new JTextField(10);
		keyP = new JPanel();
		keyP.add(keyL);
		keyP.add(keyF);
		add(keyP);
		keyF.setEditable(true);
		
		for (int i = 0; i < size; i++) {
			jl[i] = new JLabel(caption[i]);
			tf[i] = new JTextField(10);
			answerF[i] = new JTextField(10);
			jp[i] = new JPanel();
			jp[i].add(jl[i]);
			jp[i].add(tf[i]);
			jp[i].add(answerF[i]);
			add(jp[i]);
			tf[i].setEditable(false);
			answerF[i].setEditable(true);
		}
		jp[size] = new JPanel();
		okb = new JButton("수정하기");
		okb.addActionListener(this);
		rsb = new JButton("다시쓰기");
		rsb.addActionListener(this);
		jp[size].add(okb);
		jp[size].add(rsb);
		add(jp[size]);
		
	}
	

	@Override
	public void itemStateChanged(ItemEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
