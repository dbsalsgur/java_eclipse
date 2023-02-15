package guestbook.model;

//사용자의 입력 값을 MessageDao클래스에 전달
public class Message {

	private int id;
	private String guestName;
	private String password;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	//등록한 메시지에 패스워드 유무 확인
	public boolean hasPassword() {
		return password != null && !password.isEmpty();	//패스워드 값이 존재하고, 패스워드 값의 개수가 0이 아니어야한다.
	}
	
	//패스워드 매치 확인. 메시지 삭제 시 입력한 값과 작성 시 설정한 패스워드 값을 비교한 결과를 리턴한다.
	public boolean matchPassword(String pwd) {
		return password != null && password.equals(pwd);	
	}
}
