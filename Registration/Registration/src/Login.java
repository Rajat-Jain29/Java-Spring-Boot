
import java.sql.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	Statement st;
	String q;
	ResultSet rs;
	
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        try{
        	
        	
//        	Class.forName("com.mysql.jdbc.Driver");
//            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","");
//            st=con.createStatement();
         
        	
        	MongoClient mc=new MongoClient("localhost",27017);
        	//DB db=(DB) mc.getDatabase("reg");
        	
        	System.out.println("Connected to Database");
//        	
            
            
            
            
	       }	       catch(Exception e){
	    	   System.out.println(e);
	       }
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse res)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String pwd=request.getParameter("password");
//		String email=request.getParameter("email");
//		System.out.println(email+"  "+pwd);
//		q="select * from regi where email = '"+email +"' and pwd = '"+pwd+"'";
//		try {
//			rs=st.executeQuery(q);
//			if(rs.next()){
//			res.getWriter().print("Login Sucessfully");
//			}
//			else{
//				res.getWriter().print("Invalid Credentials");
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}
	
}
