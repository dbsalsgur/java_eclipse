package info.command;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.service.OutputRequest;
import info.service.OutputService;
import mvc.command.CommandHandler;

public class OutputHandler implements CommandHandler {

	private static final String FORM_VIEW =	"/view/infoForm.jsp";
	private OutputService outputService = new OutputService();

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
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws ParseException {
		OutputRequest OutputReq = new OutputRequest();
		OutputReq.setCarNo(req.getParameter("carNo"));
		
		try {
			outputService.output(OutputReq);
			return "/view/infoForm.jsp";
		} catch (Exception e) {
			return FORM_VIEW;
		}
	}

}
