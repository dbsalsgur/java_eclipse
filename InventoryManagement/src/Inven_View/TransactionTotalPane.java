package Inven_View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Inven_Model.TransactionModel;

public class TransactionTotalPane extends JPanel implements ActionListener {
	private JButton rfb;
	private JPanel jp[] = new JPanel[3];
	private TransactionModel tm;
	private JTable table;
	private JPanel top;

	public TransactionTotalPane() {

		int i = 0;

		jp[i] = new JPanel();
		rfb = new JButton("リフレッシュ");
		rfb.addActionListener(this);
		jp[i].add(rfb);
		add(jp[i]);
		i++;
		
		jp[i] = new JPanel();
		tm = new TransactionModel();// 데이터를 갖고있는놈
		table = new JTable(tm);// 표시형식
		jp[i].add(table);
		add(new JScrollPane(table));
		add(jp[i]);

	}
	
	public void actionPerformed(ActionEvent e) {
		String e_type = e.getActionCommand();

		if (e_type.equals(rfb.getText())) {
			TransactionModel tm1 = new TransactionModel();// 데이터를 갖고있는놈
			table.setModel(tm1);
		}
	}
}
