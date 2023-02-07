package ccsp.utils;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayUtils {
	static ArrayList<String> extractUniqueValue(ArrayList<String> list) {
		HashSet<String> hashSet = new HashSet<>();
		for (String item : list) {
			hashSet.add(item);
		}
		ArrayList<String> chart = new ArrayList<>(hashSet);
		return chart;
	}

}
