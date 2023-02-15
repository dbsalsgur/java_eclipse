package guestbook.service;

public class InvalidPasswordException extends ServiceException {

	//Exception을 수동구현
	public InvalidPasswordException(String message) {
		super(message);
	}
	
}
