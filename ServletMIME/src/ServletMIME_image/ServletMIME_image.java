package ServletMIME_image;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ServletMIME_image
 */
public class ServletMIME_image extends HttpServlet {
	private File image;
	
	public void init() {
		ServletContext context = this.getServletContext();
		String path = context.getRealPath("/images_servlet");
		image = new File(path, "naruto1.jpg");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMIME_image() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpg");
		
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(image)));
		
		ServletOutputStream out = response.getOutputStream();
		
		byte[] data = new byte[512];
		
		while (true) {
			int x = in.read(data, 0, data.length);
			if (x == -1) {
				break;
			}
			out.write(data, 0, x);
			out.flush();
		}
		
		in.close();
		out.close();
	}


}
