

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class Bank
 */
@WebServlet("/Bank")
public class Bank extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	Statement st;
	ResultSet rs;
	String q;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bank() {
        super();
        try{
        	Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            st=con.createStatement();
         
	       }
	       catch(Exception e){
	    	   System.out.println(e);
	       }
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
	protected void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		String name=request.getParameter("tname");
		String un=request.getParameter("userid");
		String desc=request.getParameter("desc");
		
		String pwd=request.getParameter("type");
		
		double phone=Double.parseDouble(request.getParameter("amt"));
		double pin=Double.parseDouble(request.getParameter("bal"));

		q="insert into bk values ( '"+name+"','"+un+"','"+desc+"','"+pwd+"',"+phone+","+pin+"   ) ;";
		try{
		st.executeUpdate(q);
		res.getWriter().print("Entered Successfully");
		}
		catch(Exception e){
			res.getWriter().print("OOPS! There is some problem " + e);
		}
		
	}

}
