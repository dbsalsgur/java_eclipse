package Inven_View;//완

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Inven_Model.ProductModel;
import Inven_Model.TransactionModel;

//재고현황탭
public class ProductTotalPane extends JPanel implements ActionListener {
	private JButton rfb;
	private JPanel jp[] = new JPanel[3];
	private ProductModel pm;
	private JTable table;
	private JPanel top;

	public ProductTotalPane() {

		int i = 0;

		jp[i] = new JPanel();
		rfb = new JButton("リフレッシュ");
		rfb.addActionListener(this);
		jp[i].add(rfb);
		add(jp[i]);
		i++;
		
		jp[i] = new JPanel();
		pm = new ProductModel();
		table = new JTable(pm);
		jp[i].add(table);
		add(new JScrollPane(table));
		add(jp[i]);

	}
	
	public void actionPerformed(ActionEvent e) {
		String e_type = e.getActionCommand();

		if (e_type.equals(rfb.getText())) {
			ProductModel tm1 = new ProductModel();
			table.setModel(tm1);
		}
	}
}