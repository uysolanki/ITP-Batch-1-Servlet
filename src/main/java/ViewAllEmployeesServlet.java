

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllEmployeesServlet
 */
@WebServlet("/ViewAllEmployeesServlet")
public class ViewAllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllEmployeesServlet() {
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
		
		try
		{
		Connection con=MySQLConnection1.getConnection(context);
		
		
		String query="select * from empitp";
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery(query);
		
		out.print("<table border='1'>");
		out.print("<tr>");
		out.print("<th>ENO</th>");
		out.print("<th>ENAME</th>");
		out.print("<th>SALARY</th>");
		out.print("</tr>");
		
		while(rs.next())
		{
			out.print("<tr>");
			out.print("<td>"+rs.getInt("eno")+"</td>");
			out.print("<td>"+rs.getString("ename")+"</td>");
			out.print("<td>"+rs.getInt("sal")+"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		st.close();
		con.close();
		
		}
		catch(Exception se)
		{
			out.println(se.getMessage());
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
