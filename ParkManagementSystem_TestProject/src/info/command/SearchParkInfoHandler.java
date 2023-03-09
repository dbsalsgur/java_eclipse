package info.command;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.model.Info;
import info.service.SearchParkInfoService;
import info.service.SearchRequest;
import mvc.command.CommandHandler;
import ticket.service.DuplicateIdException;

public class SearchParkInfoHandler implements CommandHandler {

	private static final String FORM_VIEW =	"/view/infoForm.jsp";
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
		SearchRequest searchReq = new SearchRequest();
		searchReq.setcarNo(req.getParameter("carNo"));
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		
		searchReq.validate(errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			Info info =  searchParkInfoService.searchParkInfo(searchReq);
			
			//입, 출차 여부를 javascript 변수 oid로 전달
			int ocheck = 3;
			if(info == null) {
				ocheck = 2;
			} else if(info.getTstat().equals("I")) {
				ocheck = 0;
			} else if(info.getTstat().equals("O")) {
				ocheck = 1;
			}
			
			//비고에 출력할 문구
			String note = "";
			if(ocheck == 2) {
				note = "입차가 완료되지 않은 차량입니다";
			} else if(info.getTstat().equals("I")) {
				note = "출차 준비중입니다.";
			} else if(info.getTstat().equals("O")) {
				note = "출차가 완료된 차량입니다";
			}
			
			//DB에서 가져온 날짜 값 변환
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String inDate = format.format(info.getInDate());
			
			req.setAttribute("info", info);
			req.setAttribute("inDate", inDate);
			req.setAttribute("note", note);
			req.setAttribute("ocheck", ocheck);
			
			return "/view/outputForm.jsp";
		} catch (Exception e) {
			return FORM_VIEW;
		}
	}

}
