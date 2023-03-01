package info.command;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.model.Info;
import info.service.SearchParkInfoService;
import info.service.SearchTicketRequest;
import info.service.SearchTicketService;
import mvc.command.CommandHandler;
import ticket.model.Ticket;
import ticket.service.DuplicateIdException;

public class SearchTicketHandler implements CommandHandler {

	private static final String FORM_VIEW =	"/view/infoForm.jsp";
	private SearchTicketService searchTicService = new SearchTicketService();
	private SearchParkInfoService searchParkInfoService = new SearchParkInfoService();

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
		
		Info info = null;
		
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		
		searchTicReq.validate(errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			Ticket ticket =  searchTicService.searchTicket(searchTicReq);
			Info infoParkNoValue = searchParkInfoService.searchParkInfo(info);
			
			//등급에 따라 비고에 출력할 문구 설정
			String note = "";
			if (ticket.getGrade().equals("Y")) {
				note = "연회원입니다.";
			} else if(ticket.getGrade().equals("M")) {
				note = "월회원입니다.";
			}
			
			//다음주차번호 판단
			int nextParkNo = 1;
			if (infoParkNoValue != null) {
				nextParkNo = infoParkNoValue.getParkNo() + 1;
			}
			
			//DB에서 가져온 날짜 값 변환
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String startDate = format.format(ticket.getStartDate());
			String endDate = format.format(ticket.getEndDate());
			
			req.setAttribute("ticket", ticket);
			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate", endDate);
			req.setAttribute("note", note);
			req.setAttribute("nextParkNo", nextParkNo);
			
			return "/view/inputForm.jsp";
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
}
