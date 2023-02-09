package ccsp.models;

// 統計データを画面に出力するためにデータの属性名とレコードの合計を入れておくためのオブジェクト
public class ChartDataSet {
	public String dataKey = "";
	public int dataValue = 0;

	public ChartDataSet() {
	}

	public ChartDataSet(String key) {
		dataKey = key;
	}

	public ChartDataSet(String key, int value) {
		dataKey = key;
		dataValue = value;
	}

}
