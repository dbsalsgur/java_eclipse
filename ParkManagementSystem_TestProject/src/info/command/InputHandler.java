package info.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.service.InputRequest;
import info.service.InputService;
import mvc.command.CommandHandler;
import ticket.service.DuplicateIdException;

public class InputHandler implements CommandHandler {

	private static final String FORM_VIEW =	"/view/infoForm.jsp";
	private InputService inputService = new InputService();

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
		InputRequest inputReq = new InputRequest();
		inputReq.setParkNo(req.getParameter("parkNo"));
		inputReq.setCarNo(req.getParameter("carNo"));
		inputReq.setGrade(req.getParameter("grade"));
		inputReq.setTstat(req.getParameter("tstat"));
		inputReq.setInDate(req.getParameter("inDate"));
		inputReq.setOutDate(req.getParameter("outDate"));
		
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		
		inputReq.validate(errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			inputService.input(inputReq);
			return "/view/infoForm.jsp";
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
}
