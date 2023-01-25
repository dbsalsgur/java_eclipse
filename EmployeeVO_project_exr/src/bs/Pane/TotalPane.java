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
	//EmployeeModel 크기의 표 생성, 스크롤바도 추가
}
