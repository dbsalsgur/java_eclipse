package ticket.service;

import java.util.List;

import ticket.model.Ticket;

public class ListPage {

	private List<Ticket> content;
	
	public ListPage() {
		super();
	}

	public ListPage(List<Ticket> content) {
		super();
		this.content = content;
	}

	public List<Ticket> getContent() {
		return content;
	}

	public void setContent(List<Ticket> content) {
		this.content = content;
	}
	
	public String stringFormat(String str) {
			if (str.equals("Y"))
				return "연회원";
			if (str.equals("M"))
				return "월회원";
			else
				return "";
	}
}
