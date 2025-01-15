

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.MySQLConnection;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
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
		int a =  Integer.parseInt(request.getParameter("t1"));
		String b = request.getParameter("t2");
		int c = Integer.parseInt(request.getParameter("t3"));
		
		String query="insert into empitp values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		
		
		ps.setInt(1, a);
		ps.setString(2, b);
		ps.setInt(3, c);
		
		int n=ps.executeUpdate();
		
		if(n>0)
			out.println("Record Inserted");
		else
			out.println("Record Not Inserted");
		
		ps.close();
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
