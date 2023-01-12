package org.swing;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class JFrameEx extends JFrame {
	EmployeeModel model = new EmployeeModel();
	JTable table = new JTable(model);
	public JFrameEx() {
		add(new JScrollPane(table), BorderLayout.CENTER);
		setSize(500, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
