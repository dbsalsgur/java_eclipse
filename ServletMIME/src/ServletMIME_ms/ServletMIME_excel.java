package ServletMIME_ms;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class ServletMIME_excel extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File dir = new File(this.getServletContext().getRealPath("/upload"));
		if (!dir.exists()) {
			dir.mkdir();
		}
		String fileName = "";
		
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(10 *1024);
				factory.setRepository(dir);
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setSizeMax(10 * 1024 * 1024);
				upload.setHeaderEncoding("utf-8");
				ArrayList items = (ArrayList)upload.parseRequest(request);
				FileItem item = (FileItem)items.get(0);
				if (!item.isFormField() && item.getFieldName().equals("attach_file")) {
					fileName = item.getName();
					if (fileName != null && fileName.trim().length() != 0) {
						fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
						File file = new File(dir, fileName);
						item.write(file);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String exten = fileName.substring(fileName.lastIndexOf("."));
		String mime = "";
		if (exten.equalsIgnoreCase(".doc")) {
			mime = "application/msword";
		} else if(exten.equalsIgnoreCase(".xlsx")) {
			mime = "application/vnd.ms-excel";
		} else if(exten.equalsIgnoreCase(".ppt")) {
			mime = "application/vnd.ms-powerpoint";
		} else {
			mime = "application/octet-stream";
		}
		response.setContentType(mime);
		
		ServletOutputStream out = response.getOutputStream();
		
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(dir, fileName))));
		
		byte[] data = new byte[1024];
		
		while (true) {
			int len = in.read(data, 0, data.length);
			if(len == -1) break;
			out.write(data, 0 , len);
			out.flush();
		}
		in.close();
		out.close();
	}

}
