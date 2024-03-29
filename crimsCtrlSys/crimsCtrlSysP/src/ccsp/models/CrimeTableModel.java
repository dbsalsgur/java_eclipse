package ccsp.models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

// TableModel　オブジェクトを入れておくclass
public class CrimeTableModel extends AbstractTableModel {
	Object[][] data;
	Object[] columnName;

	CrimeSysDAO crDAO = new CrimeSysDAO();
	CrimeRecordVO crVO;
	ArrayList<String> title;
	ArrayList<CrimeRecordVO> list;

	// 全てのテーブルデータ
	public CrimeTableModel() {
		title = crDAO.getColumnName();
		columnName = title.toArray();
		int columnCount = title.size();

		list = crDAO.getCrimeRecordtotal();
		int rowCount = list.size();

		data = new Object[rowCount][columnCount];
		System.out.println(rowCount);
		System.out.println(columnCount);
		for (int index = 0; index < rowCount; index++) {
			crVO = list.get(index);
			data[index][0] = crVO.getCrimNo();
			data[index][1] = crVO.getRegion();
			data[index][2] = crVO.getSex();
			data[index][3] = crVO.getcRecord();
			data[index][4] = crVO.getName();
			data[index][5] = crVO.getRegitNumber();
			data[index][6] = crVO.getDate();
			data[index][7] = crVO.getCrimDivNo();
		}
	}

	// ユーザーに入力うけて照会されるテーブルデータ
	public CrimeTableModel(ArrayList<CrimeRecordVO> crVOArr) {
		title = crDAO.getColumnName();
		columnName = title.toArray();
		int columnCount = title.size();

		int rowCount = crVOArr.size();

		data = new Object[rowCount][columnCount];
		System.out.println(rowCount);
		System.out.println(columnCount);
		for (int index = 0; index < rowCount; index++) {
			crVO = crVOArr.get(index);
			data[index][0] = crVO.getCrimNo();
			data[index][1] = crVO.getRegion();
			data[index][2] = crVO.getSex();
			data[index][3] = crVO.getcRecord();
			data[index][4] = crVO.getName();
			data[index][5] = crVO.getRegitNumber();
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

	public Object getValueAt(int rowIndex, int columnIndex) { 
		return data[rowIndex][columnIndex]; 
	}

	public String getColumnName(int column) { 
		return (String) columnName[column];
	}
}
