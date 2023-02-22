package Inven_Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Inven_Controller.ProductDAO;

public class ProductModel extends AbstractTableModel {

	Object[][] data;
	Object[] columnName;

	ProductDAO prDAO = new ProductDAO();
	ProductVO prVO;
	ArrayList<String> title;
	ArrayList<ProductVO> list;

	public ProductModel() {
		title = prDAO.getColumnName();
		columnName = title.toArray();
		int columnCount = title.size();

		list = prDAO.getProducttotal();
		int rowCount = list.size();

		data = new Object[rowCount][columnCount];

		for (int index = 0; index < rowCount; index++) {
			prVO = list.get(index);
			data[index][0] = prVO.getProcode();
			data[index][1] = prVO.getProname();
			data[index][2] = prVO.getProtype();
			data[index][3] = prVO.getProprice();
			data[index][4] = prVO.getProquan();
		}
	}
	
	public ProductModel(ArrayList<ProductVO> prVOArr) {
		title = prDAO.getColumnName();
		columnName = title.toArray();
		int columnCount = title.size();
		int rowCount = prVOArr.size();

		data = new Object[rowCount][columnCount];
		for (int index = 0; index < rowCount; index++) { // 행(가로)의 반복
			prVO = prVOArr.get(index);
			data[index][0] = prVO.getProcode();
			data[index][1] = prVO.getProname();
			data[index][2] = prVO.getProtype();
			data[index][3] = prVO.getProprice();
			data[index][4] = prVO.getProquan();
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
