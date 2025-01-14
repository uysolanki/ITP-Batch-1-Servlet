

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OddEven
 */
@WebServlet("/OddEven")
public class OddEven extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OddEven() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		ServletContext context=getServletContext();
		String appName=(String)context.getInitParameter("applicationName");
		out.print(appName);
		
		ServletConfig config=getServletConfig();
		String devName=(String)config.getInitParameter("developerName");
		out.print(devName);
		
		int n1 = Integer.parseInt(request.getParameter("t1"));
		if(n1%2==0)
			out.print("<font color='red'><b><u>NUMBER IS EVEN</u></b></font>");
		else
			out.print("<font color='green'><b><u>NUMBER IS EVEN</u></b></font>");
		
//		String name=request.getParameter("t1");
//		response.sendRedirect("https://www.google.co.in/search?q="+name);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
