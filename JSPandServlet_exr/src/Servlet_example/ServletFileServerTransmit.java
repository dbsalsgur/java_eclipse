package Servlet_example;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.naming.SizeLimitExceededException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class ServletFileServerTransmit
 */
public class ServletFileServerTransmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFileServerTransmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "";
		String id = "";
		String pw = "";
		String fileName = "";
		boolean check = ServletFileUpload.isMultipartContent(request);
		
		if (check) {
			ServletContext context = this.getServletContext();
			String path = context.getRealPath("/upload");
			File dir = new File(path);
			if (!dir.exists()) dir.mkdir();
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(10 * 1024);
				factory.setRepository(dir);
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setSizeMax(10 * 1024 * 1024);
				upload.setHeaderEncoding("utf-8");
				
				ArrayList items = (ArrayList)upload.parseRequest(request);
				for (int i = 0; i < items.size(); ++i) {
					FileItem item = (FileItem)items.get(i);
					String value = item.getString("utf-8");
					
					if (item.isFormField()) {
						if(item.getFieldName().equals("name"))
							name = value;
						if(item.getFieldName().equals("id"))
							id = value;
						if(item.getFieldName().equals("pw"))
							pw = value;
					} else {
						if(item.getFieldName().equals("picture")) {
							fileName = item.getName();
							if(fileName == null || fileName.trim().length() == 0)
								continue;
							fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
							File file = new File(dir, fileName);
							item.write(file);
						}
					}
				}
			} catch(SizeLimitExceededException e) {
				e.printStackTrace();
			} catch(FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<html><body>");
			out.println("회원 가입할 이름 : "+name + "<br/>");
			out.println("회원 가입할 아이디 : "+id + "<br/>");
			out.println("회원 가입할 비밀번호 : "+pw + "<br/>");
			out.println("회원 가입할 사진 저장 경로 : "+ dir + "<br/>");
			out.println("회원 가입할 사진 파일 이름 : "+ fileName + "<br/>");
			out.println("</body></html>");
		}
	}
}
