package info.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.service.SearchTicketRequest;
import info.service.SearchTicketService;
import mvc.command.CommandHandler;
import ticket.service.DuplicateIdException;

public class SearchTicketHandler implements CommandHandler {

	private static final String FORM_VIEW =	"/view/infoForm.jsp";
	private SearchTicketService searchTicService = new SearchTicketService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}


	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		SearchTicketRequest searchTicReq = new SearchTicketRequest();
		searchTicReq.setcarNo(req.getParameter("carNo"));
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		
		searchTicReq.validate(errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			searchTicService.searchTicket(searchTicReq);
			return "/view/inputForm.jsp";
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
}
