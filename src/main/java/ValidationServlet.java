

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/ValidationServlet")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidationServlet() {
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
		
		int n1 = Integer.parseInt(request.getParameter("t1"));
		int n2 = Integer.parseInt(request.getParameter("t2"));
		
		if(n1>0 && n2>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("myadd");
			rd.forward(request, response);
		}
		else
		{
			out.print("<font color='red'><b><u>Please enter Valid Numbers</u></b></font>");
			RequestDispatcher rd1=request.getRequestDispatcher("/add.html");
			rd1.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
