package crim.CriminalModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import crim.models.CrimeRecordVO;
import crim.models.CriminalDAO;


public class CriminalModel extends AbstractTableModel {
	Object [][] data;
	Object []columnName;
	//데이터는 여러개의 단어로 구성되어 있어서 다차원배열로 선언
	//속성명은 각각 한개 씩이므로 배열로 선언
	
	CriminalDAO crDao = new CriminalDAO();
	CrimeRecordVO crVo;
	ArrayList<String> title;
	//속성명 담을 변수
	ArrayList<CrimeRecordVO> list;
	//레코드 담을 변수
	
	public CriminalModel() {
		title = crDao.getColumnName();
		columnName = title.toArray();
		//ArrayList로 만든 속성명을 객체 배열로 반환
		int columnCount = title.size();
		//속성명 개수(열의 개수) 변수에 담음
		
		list = crDao.getCriminaltotal();
		//list에 레코드 내용 입력
		int rowCount = list.size();
		//레코드의 개수 변수에 담음
		
		data = new Object[rowCount][columnCount];
		//data는 데이터베이스에 저장된 데이터를 담을 것이기 때문에 행열 각각의 개수만큼 지정
	
		for (int index = 0; index < rowCount; index++) {
			crVo = list.get(index);
			data[index][0]=crVo.getCrimNo();
			data[index][1]=crVo.getRegion();
			data[index][2]=crVo.getSex();
			data[index][3]=crVo.getcRecord();
			data[index][4]=crVo.getName();
			data[index][5]=crVo.getRegitNumber();
			data[index][6]=crVo.getDate();
			data[index][7]=crVo.getCrimDivNo();
		}
		//data에 데이터베이스의 레코드들 저장
	}

	@Override
	public int getRowCount() {
		if (data == null) {
			return 0;
		} else {
			return data.length;
		}
	}
	//레코드 개수 반환. 없으면 0반환.

	@Override
	public int getColumnCount() {
		if(columnName == null)
			return 0;
		else 
			return columnName.length;
	}
	//속성 개수 반환. 없으면 0 반환

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	//data에 저장한 찾고 싶은 데이터 반환.
	
	public String getColumnName(int column) {
		return (String)columnName[column];
	}
	//속성 이름 반환. 기본적으로 Object형이기 때문에 String으로 형변환.
}
