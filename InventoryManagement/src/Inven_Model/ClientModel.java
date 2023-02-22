package Inven_Model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Inven_Controller.ClientDAO;

public class ClientModel extends AbstractTableModel{
	Object[][] data;//전체조회 하기위한 모델
	Object[] columnName;

	ClientDAO cdao = new ClientDAO();
	ClientVO cl;
	ArrayList<String> title;
	ArrayList<ClientVO> list;

	public ClientModel() {
		title = cdao.getColumnName();
		columnName = title.toArray();
		int columnCount = title.size();

		list = cdao.getClientTotal();
		int rowCount = list.size();

		data = new Object[rowCount][columnCount];
		for (int index = 0; index < rowCount; index++) {
			
			cl = list.get(index);
			data[index][0] = cl.getComname();
			data[index][1] = cl.getRepname();
			data[index][2] = cl.getLocation();
			data[index][3] = cl.getTel();
			data[index][4] = cl.getEmail();
			data[index][5] = cl.getCorno();
		}
	}

	public int getRowCount() {
		if (data == null)
			return 0;
		else
			return data.length;
	}

	public int getColumnCount() {
		if (columnName == null)
			return 0;
		else
			return columnName.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

	public String getColumnName(int column) {
		return (String) columnName[column];
	}

}
