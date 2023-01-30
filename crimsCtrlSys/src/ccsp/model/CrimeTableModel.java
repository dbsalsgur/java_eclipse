package models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CrimeTableModel extends AbstractTableModel {
	Object[][] data;
	Object[] columnName;

	CrimeSysDAO crDAO = new CrimeSysDAO(); // CrimeRead에 정의된 메서드를 쓰기 위해
	CrimeRecordVO crVO;
	ArrayList<String> title;
	ArrayList<CrimeRecordVO> list;

	public CrimeTableModel() {
		title = crDAO.getColumnName();
		columnName = title.toArray();
		int columnCount = title.size();

		list = crDAO.getCrimeRecordtotal();
		int rowCount = list.size();

		data = new Object[rowCount][columnCount];
		System.out.println(rowCount);
		System.out.println(columnCount);
		for (int index = 0; index < rowCount; index++) { // 행(가로)의 반복
			crVO = list.get(index);
			data[index][0] = crVO.getCrimNo();
			data[index][1] = crVO.getRegion();
			data[index][2] = crVO.getSex();
			data[index][3] = crVO.getcRecord();
			data[index][4] = crVO.getName();
			data[index][5] = crVO.getRegionName();
			data[index][6] = crVO.getDate();
			data[index][7] = crVO.getCrimDivNo();
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

	public Object getValueAt(int rowIndex, int columnIndex) { // 행과 열에 들어갈 인트형 내용
		return data[rowIndex][columnIndex]; // 알아서 값이 들어감
	}

	public String getColumnName(int column) { // 열에 들어갈 내용을 문자열로
		return (String) columnName[column];
	}
}
