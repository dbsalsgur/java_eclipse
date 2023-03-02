package info.service;

import java.util.Map;

public class SearchRequest {

	private String carNo;

	public SearchRequest() {}
	
	public SearchRequest(String carNo) {
		super();
		this.carNo = carNo;
	}

	public String getcarNo() {
		return carNo;
	}

	public void setcarNo(String carNo) {
		this.carNo = carNo;
	}
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, carNo, "carNo");
	}
	
	public void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty()) {
			errors.put(fieldName, Boolean.TRUE);
		}
	}
}
