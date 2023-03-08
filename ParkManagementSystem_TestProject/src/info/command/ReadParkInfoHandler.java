package info.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.model.Info;
import info.service.ReadParkInfoService;
import mvc.command.CommandHandler;

public class ReadParkInfoHandler implements CommandHandler {
	
	private ReadParkInfoService readParkInfoService = new ReadParkInfoService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Info> plistPage = readParkInfoService.getDateList();
		req.setAttribute("plistPage", plistPage);
		return "/view/readParkInfoForm.jsp";
	}

}
