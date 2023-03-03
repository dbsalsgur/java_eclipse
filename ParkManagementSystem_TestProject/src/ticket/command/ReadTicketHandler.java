package ticket.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import ticket.service.ListPage;
import ticket.service.ReadTicketService;

public class ReadTicketHandler implements CommandHandler {
	
	private ReadTicketService readTicketService = new ReadTicketService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ListPage listPage = readTicketService.getDateList();
		ListPage util = new ListPage();
		req.setAttribute("listPage", listPage);
		req.setAttribute("util", util);
		return "/view/readTicketForm.jsp";
	}

}
