package guestbook.service;

//Exception을 필요한 것만 가져와서 수동으로 구현
public class ServiceException extends RuntimeException {

	public ServiceException(String message, Exception cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}
	
}
