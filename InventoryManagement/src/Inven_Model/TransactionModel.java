package Inven_Model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Inven_Controller.TransactionDAO;


public class TransactionModel extends AbstractTableModel {
	Object[][] data;//전체조회 하기위한 모델
	Object[] columnName;

	TransactionDAO tdao = new TransactionDAO();
	TransactionVO tl;
	ArrayList<String> title;
	ArrayList<TransactionVO> list;

	public TransactionModel() {
		title = tdao.getColumnName();
		columnName = title.toArray();
		int columnCount = title.size();

		list = tdao.getTransactionTotal();
		int rowCount = list.size();

		data = new Object[rowCount][columnCount];
		for (int index = 0; index < rowCount; index++) {
			
			tl = list.get(index);
			data[index][0] = tl.getTransno();
			data[index][1] = tl.getTransdate();
			data[index][2] = tl.getTransname();
			data[index][3] = tl.getQuantity();
			data[index][4] = tl.getTransprice();
			data[index][5] = tl.getTotalprice();
			data[index][6]=tl.getClient();
			data[index][7]=tl.getProno();
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