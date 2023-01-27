package crim.panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import crim.CriminalModel.CriminalModel;

public class TotalPanel extends JPanel {
	public TotalPanel() {
		JTable table = new JTable(new CriminalModel());
		add(new JScrollPane(table));
	}

}
