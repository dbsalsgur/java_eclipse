package ccsp.models;

public class ChartDataSet {
	public String dataKey="";
	public int dataValue=0;

	public ChartDataSet() {
		// TODO Auto-generated constructor stub
	}
	
	public ChartDataSet(String key) {
		dataKey=key;
	}
	
	public ChartDataSet(String key, int value) {
		dataKey = key;
		dataValue = value;
	}

}
