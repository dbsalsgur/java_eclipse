package bs.EmployeeModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import bs.models.EmployeeDAO;
import bs.models.EmployeeVO;

public class EmployeeModel extends AbstractTableModel {
	Object [][] data;
	Object []columnName;
	//�����ʹ� �������� �ܾ�� �����Ǿ� �־ �������迭�� ����
	//�Ӽ����� ���� �Ѱ� ���̹Ƿ� �迭�� ����
	
	EmployeeDAO emDao = new EmployeeDAO();
	EmployeeVO emVo;
	ArrayList<String> title;
	//�Ӽ��� ���� ����
	ArrayList<EmployeeVO> list;
	//���ڵ� ���� ����
	
	public EmployeeModel() {
		title = emDao.getColumnName();
		columnName = title.toArray();
		//ArrayList�� ���� �Ӽ����� ��ü �迭�� ��ȯ
		int columnCount = title.size();
		//�Ӽ��� ����(���� ����) ������ ����
		
		list = emDao.getEmployeetotal();
		//list�� ���ڵ� ���� �Է�
		int rowCount = list.size();
		//���ڵ��� ���� ������ ����
		
		data = new Object[rowCount][columnCount];
		//data�� �����ͺ��̽��� ����� �����͸� ���� ���̱� ������ �࿭ ������ ������ŭ ����
	
		for (int index = 0; index < rowCount; index++) {
			emVo = list.get(index);
			data[index][0]=emVo.getNo();
			data[index][1]=emVo.getName();
			data[index][2]=emVo.getJobGrade();
			data[index][3]=emVo.getDepartment();
			data[index][4]=emVo.getEmail();
		}
		//data�� �����ͺ��̽��� ���ڵ�� ����
	}

	@Override
	public int getRowCount() {
		if (data == null) {
			return 0;
		} else {
			return data.length;
		}
	}
	//���ڵ� ���� ��ȯ. ������ 0��ȯ.

	@Override
	public int getColumnCount() {
		if(columnName == null)
			return 0;
		else 
			return columnName.length;
	}
	//�Ӽ� ���� ��ȯ. ������ 0 ��ȯ

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	//data�� ������ ã�� ���� ������ ��ȯ.
	
	public String getColumnName(int column) {
		return (String)columnName[column];
	}
	//�Ӽ� �̸� ��ȯ. �⺻������ Object���̱� ������ String���� ����ȯ.
}
