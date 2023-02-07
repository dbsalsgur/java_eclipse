package ccsp.view;

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

import ccsp.models.CrimeRecordVO;
import ccsp.models.CrimeSysDAO;


public class DeletePanel extends JPanel implements ActionListener, ItemListener {
	private JPanel jp[] = new JPanel[9];
	private JLabel jl[] = new JLabel[8];
	private JTextField tf[] = new JTextField[8];
	private JButton search;
	private JButton delete;

	
	String[] caption = {"범죄번호 : ", "분류번호 : ", "지        역 : ", "성        별 : ", "전        과 : ", "이        름 : ", "주민번호 : ", "발생일자 : "};

	
	public DeletePanel() {
		setLayout(new GridLayout(10,1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);
		
		int size = caption.length;
		
	
		jl[0] = new JLabel(caption[0]);
		tf[0] = new JTextField(10);
		jp[0] = new JPanel();
		jp[0].add(jl[0]);
		jp[0].add(tf[0]);
		search = new JButton("검색");
		search.addActionListener(this);
		jp[0].add(search);
		add(jp[0]);
		tf[0].setEditable(true);
		

		for (int i = 1; i < size; i++) {
			jl[i] = new JLabel(caption[i]);
			tf[i] = new JTextField(10);
			jp[i] = new JPanel();
			jp[i].add(jl[i]);
			jp[i].add(tf[i]);
			add(jp[i]);
			tf[i].setEditable(false);
		}
		
		
		jp[size] = new JPanel();
		delete = new JButton("삭제하기");
		delete.addActionListener(this);
		jp[size].add(delete);
		add(jp[size]);
		
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand();
		CrimeRecordVO crVO = null;
		CrimeSysDAO crDAO = null;
		if (ae_type.equals(search.getText())) {
			try {
				crDAO = new CrimeSysDAO();
				String sno = tf[0].getText().trim();
				if (!sno.equals("")) {
					int no = Integer.parseInt(sno);
					crVO = crDAO.getCriminalCheck(no);
				}
			} catch (Exception e) {
				System.out.println("e=["+e+"e");
			}
			if (crVO != null) {
				tf[1].setText(crVO.getCrimDivNo()+"");
				tf[2].setText(crVO.getRegion()+"");
				tf[3].setText(crVO.getSex()+"");
				tf[4].setText(crVO.getcRecord()+"");
				tf[5].setText(crVO.getName()+"");
				tf[6].setText(crVO.getRegitNumber()+"");
				tf[7].setText(crVO.getDate()+"");
				
			} else {
				JOptionPane.showMessageDialog(this, "검색 실패");
			}
		} else if(ae_type.equals(delete.getText())) {
			try {
				String sno = tf[0].getText().trim();
				crDAO = new CrimeSysDAO();
				if (!sno.equals("")) {
					int no = Integer.parseInt(sno);
					crVO = crDAO.getCriminalDelete(no);
				}			
			} catch (Exception e) {
				System.out.println("input error");
				System.out.println("e=["+e+"e");
			}
			if(crVO != null) {
				JOptionPane.showMessageDialog(this, "잘못 입력하셨습니다"+"\n"+"범죄번호를 다시 확인해주세요.");

			} else {
				JOptionPane.showMessageDialog(this, "범죄자 "+tf[5].getText()+"의"+"\n"+"신상정보가 삭제되었습니다!");
			}
		} 
	}


}
