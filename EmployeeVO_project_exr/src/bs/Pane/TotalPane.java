package bs.Pane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import bs.EmployeeModel.EmployeeModel;

public class TotalPane extends JPanel {
	public TotalPane() {
		JTable table = new JTable(new EmployeeModel());
		add(new JScrollPane(table));
	}
}
