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
	//ok��ư
	private JButton rsb;
	//reset(�ٽ��ϱ�)��ư
	private int department = 10;
	//�μ���ȣ �⺻�� 10 ����
	
	String[] caption = {"�� �� :", "�� å :", "�� �� :", "�� �� :"};
	
	public AddPane() {
		setLayout(new GridLayout(6,1));
		//�������� 6�� 1���� ���� ����
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);
		//������Ʈ�� Ȩ�� �Ǵٰ� �ϳ� �ϳ��� �Ⱥ���
		
		int size = caption.length;
		int i;
		for (i = 0; i < size-1; i++) {
			jp[i] = new JPanel();
			//Panel ��ü ����
			jl[i] = new JLabel(caption[i]);
			// caption�� i��°�� �ؽ�Ʈ ����, �̸� ��å ���� �μ� ��
			tf[i] = new JTextField(15);
			//TextField, ��, �Է�ĭ ����. ���ڴ� ũ��
			jp[i].add(jl[i]);
			//�гο� caption �ؽ�Ʈ ���̱�
			jp[i].add(tf[i]);
			//�гο� �Է�ĭ ���̱�
			add(jp[i]);
			//�ϼ��� �г� �߰��ϱ�
		}
		jp[i] = new JPanel();
		jl[i] = new JLabel(caption[i]);
		jp[i].add(jl[i]);
		add(jp[i]);
		
		JComboBox combo = new JComboBox();
		combo.addItem("�μ���ȣ�� �����ϼ���");
		for (int c = 1; c <= 5; c++) {
			combo.addItem(c*10);
		}
		//�μ���ȣ ���� �����ϵ��� �޺��ڽ� ����, ������ 10���� 50���� 
		jp[i].add(combo);
		combo.addActionListener(this);
		
		jp[size] = new JPanel();
		okb = new JButton("�����ϱ�");
		okb.addActionListener(this);
		rsb = new JButton("�ٽþ���");
		rsb.addActionListener(this);
		jp[size].add(okb);
		jp[size].add(rsb);
		add(jp[size]);
		//��ư����� ������ �����ϴ� ������Ʈ �߰�
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getStateChange() == ItemEvent.SELECTED)
			department = Integer.parseInt(ie.getItem().toString());
	}
	//���õ� �μ���ȣ�� �̺�Ʈ �߻����� ���õ� �μ���ȣ�� ���ٸ� 
	//department�� ������ �μ���ȣ ����

	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand();
		EmployeeVO evo = null;
		EmployeeDAO edvo = null;
		if (ae_type.equals(okb.getText())) {
			//�����ϱ� ������ ����
			try {
				evo = new EmployeeVO(0, tf[0].getText(), tf[1].getText(), department, tf[2].getText());
				//�Է�ĭ�� �Էµ� ���ڸ� ��� evo��ü�� ����
				edvo = new EmployeeDAO();
				edvo.getEmployeeregiste(evo);
				//������ �����ϴ� �޼ҵ� ����
			} catch (Exception e) {
				System.out.println("e=["+e+"e");
			}
			if(edvo != null)
				JOptionPane.showMessageDialog(this, tf[0].getText()+"���� ���������� �߰���");
			//edvo�� �� ó���Ǹ� �Է��� �̸�+���� ���������� �߰��� ���
		} else if(ae_type.equals(rsb.getText())){
			//�ٽþ��� ������ ����
			int size = caption.length;
			for (int i = 0; i < size-1; i++) {
				tf[i].setText("");
			}
			//��� �Է�ĭ�� �������� ����
		}
	}
	//�̺�Ʈ �߻��� �����.
}
