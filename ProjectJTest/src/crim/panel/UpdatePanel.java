package crim.panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
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
	private JTextField tf[] = new JTextField[7];
	private JTextField keyF = new JTextField();
	private JTextField answerF[] = new JTextField[7];
	private JButton search;
	private JButton update;
	//ok(수정하기) 버튼
	private JButton reset;
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
		search = new JButton("찾기");
		search.addActionListener(this);
		keyP.add(search);
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
		update = new JButton("수정하기");
		update.addActionListener(this);
		reset = new JButton("다시쓰기");
		reset.addActionListener(this);
		jp[size].add(update);
		jp[size].add(reset);
		add(jp[size]);
		
	}
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand();
		CrimeRecordVO crVO = null;
		CriminalDAO crDAO = null;
		int regionInput = 0;
		int sexInput = 0;
		int regitNumInput = 0;
		int crimDivNoInput = 0;
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
				tf[0].setText(crVO.getRegion()+"");
				tf[1].setText(crVO.getSex()+"");
				tf[2].setText(crVO.getcRecord());
				tf[3].setText(crVO.getName()+"");
				tf[4].setText(crVO.getRegitNumber()+"");
				tf[5].setText(crVO.getDate()+"");
				tf[6].setText(crVO.getCrimDivNo()+"");
			} else {
				JOptionPane.showMessageDialog(this, "검색 실패");
			}
		} else if(ae_type.equals(update.getText())) {
			try {
				regionInput = Integer.parseInt(answerF[0].getText());
				sexInput = Integer.parseInt(answerF[1].getText());
				regitNumInput = Integer.parseInt(answerF[4].getText());
				crimDivNoInput = Integer.parseInt(answerF[6].getText());
				crVO = new CrimeRecordVO(0, regionInput, sexInput, answerF[2].getText(), answerF[3].getText(), regitNumInput, answerF[5].getText(), crimDivNoInput);
				crDAO = new CriminalDAO();
				crDAO.getCriminalUpdate(crVO);
			} catch (Exception e) {
				System.out.println("e=["+e+"e");
			}
			String[] input = new String[7];
			for (int i = 0; i < input.length; i++) {
				input[i] = answerF[i].getText();
			}
			JOptionPane.showMessageDialog(this, input+""+"\n"+"로 수정되었습니다!");
		} else if(ae_type.equals(reset.getText())) {
			int size = caption.length;
			for (int i = 0; i < size; i++) {
				tf[i].setText("");
			}
		}
	}
	
	public static int getInt(JTextField tf) {
		return Integer.parseInt(tf.getText());
	}

}
