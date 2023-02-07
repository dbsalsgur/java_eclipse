package ccsp.utils;

import java.util.ArrayList;
import java.util.HashSet;

import ccsp.models.ChartDataSet;

public class Counting {

	public static ArrayList<ChartDataSet> counting(ArrayList<String> list) {
		ArrayList<String> dataCategoryArr = ArrayUtils.extractUniqueValue(list);
		ArrayList<ChartDataSet> chartdataArr = new ArrayList<ChartDataSet>();

		for (int i = 0; i < dataCategoryArr.size(); i++) {
			chartdataArr.add(new ChartDataSet(dataCategoryArr.get(i)));
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < chartdataArr.size(); j++) {
				if (list.get(i) == chartdataArr.get(j).dataKey) {
					chartdataArr.get(j).dataValue += 1;
				}
			}

		}

		return chartdataArr;

	}

}
