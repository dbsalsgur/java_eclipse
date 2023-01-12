package org.swing;

import javax.swing.table.AbstractTableModel;

class EmployeeModel extends AbstractTableModel {
	
	Object [][] data = {
			{"2009-10123", "김네이버", "차장", "10", "naver@magic.com"},
			{"2009-10124", "이다음", "부장", "20", "daum@magic.com"},
			{"2009-10125", "최엠파스", "대리", "20", "empas@magic.com"}
	};
	
	String [] columnName = {"사번", "이름", "직책", "부서", "메일"};

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return data[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	
	public String getColumnName(int column) {
		return columnName[column];
	}

}
