package Inven_View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Inven_Model.ClientModel;

public class ClientPane extends JPanel{
	private JPanel jp[] = new JPanel[2];
	private ClientModel cm;
	private JTable table;
	
	public ClientPane() {
		
		jp[0] = new JPanel();
		cm = new ClientModel();// 데이터를 갖고있는놈
		table = new JTable(cm);// 표시형식
		jp[0].add(table);
		add(new JScrollPane(table));
		add(jp[0]);
	}

}