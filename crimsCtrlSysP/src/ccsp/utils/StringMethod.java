package ccsp.utils;

import javax.swing.JComboBox;

public class StringMethod {

	// 띄어쓰기를 기준으로 나누고 "1 서울" 형태에서 앞의 int만 반환하는 메서드
	public static int stringSplitBySpace(JComboBox[] cbboxArr, int i) {
		String str;
		str = (String) cbboxArr[i].getSelectedItem();
		String splitItem = str.split(" ")[0].toString();
		return Integer.parseInt(splitItem);
	}
}
