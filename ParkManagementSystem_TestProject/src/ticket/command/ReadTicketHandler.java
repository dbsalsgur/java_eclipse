package ticket.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import ticket.model.Ticket;
import ticket.service.ReadTicketService;

public class ReadTicketHandler implements CommandHandler {
	
	private ReadTicketService readTicketService = new ReadTicketService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Ticket> tlistPage = readTicketService.getDateList();
		req.setAttribute("tlistPage", tlistPage);
		return "/view/readTicketForm.jsp";
	}

}
