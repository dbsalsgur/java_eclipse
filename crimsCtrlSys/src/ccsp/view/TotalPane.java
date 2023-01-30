package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import models.CrimeTableModel;

public class TotalPane extends JPanel {
	public TotalPane() {
		JTable table = new JTable(new CrimeTableModel());
		add(new JScrollPane(table));	//스크롤 추가
	}
}
