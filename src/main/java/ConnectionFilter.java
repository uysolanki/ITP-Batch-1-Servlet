

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class ConnectionFilter
 */
@WebFilter("/ConnectionFilter")
public class ConnectionFilter extends HttpFilter implements Filter {
       
	Connection con;
    /**
     * @see HttpFilter#HttpFilter()
     */
    public ConnectionFilter() {
        super();
        // TODO Auto-generated constructor stub
    }
    
  

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String driverName=(String)fConfig.getInitParameter("driverName");
		String dbName=(String)fConfig.getInitParameter("dbName");
		String userName=(String)fConfig.getInitParameter("userName");
		String password=(String)fConfig.getInitParameter("password");
		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		try {
			con=DriverManager.getConnection(dbName,userName,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}