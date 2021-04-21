package com.example.test.control;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.*;

@RestController
public class control {
	Connection connection;
	Statement statement;
	String query,Connection;
	ResultSet resultSet;
	FileHandler filehandler;
	Logger logger = Logger.getLogger("MyLog"); 	
	final String string="log.txt";
	
	public control() throws SecurityException, IOException {
        super();
        filehandler = new FileHandler(string);  
        logger.addHandler(filehandler);
        SimpleFormatter formatter = new SimpleFormatter();  
        filehandler.setFormatter(formatter);
        logger.setLevel(Level.ALL);
        logger.addHandler(filehandler);
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection = "jdbc:mysql://localhost:3306/hack";
        	logger.info("Connected to Database");
        	connection = DriverManager.getConnection(Connection, "root", "");
    		statement=connection.createStatement();
        }
        catch(Exception e){
	    	   logger.info("Error message : "+e.getMessage());
	       }
    }
	
	@PostMapping("/mentorRegistration")
	public void Registration(HttpServletRequest request, HttpServletResponse res) throws Exception {
		String name=request.getParameter("name");
		String username=request.getParameter("username");
		String pwd=request.getParameter("password");
		String email=request.getParameter("email");
		int contact=Integer.parseInt(request.getParameter("contactno"));
		String ins=request.getParameter("institution");
		query="insert into login values ('"+username+"','"+pwd+"', '"+name+"' , '"+email+"' ,"+contact+" ,'"+ins+"' ); ";
		statement.executeUpdate(query);
		res.getWriter().print("Registered Succesfully");
	}
	
	@PostMapping("/mentorLogin")
	public void Login(HttpServletRequest request, HttpServletResponse res) throws Exception {
		String username=request.getParameter("username");
		String pwd=request.getParameter("password");
		query="select * from login where username = '"+username+"' and pwd = '"+pwd+"'";
		resultSet= statement.executeQuery(query);
		if(resultSet.next()){
			res.getWriter().print("Login Succesfully "+resultSet.getString("name")+" --as a mentor position.");
		}
		else {
			res.getWriter().print("OOPS Try Again");
		}
	}
	
	@PostMapping("/query")
	public ArrayList<HashMap<String, String>> query(HttpServletRequest request, HttpServletResponse res) throws IOException, SQLException {
		ArrayList<HashMap<String, String>> resultList=new ArrayList<>();
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			String date=request.getParameter("date");
			query="select * from sdp where id = '"+id+"' and date = '"+date+"' and status = 'Present'";
			resultSet= statement.executeQuery(query);
			if(resultSet.next()) {	
				HashMap<String, String> map = new HashMap<>();
				map.put("Attendance",""+resultSet.getString("status") );
				map.put("Topic",""+resultSet.getString("topic") );
				map.put("Status",""+resultSet.getString("statust") );
				resultList.add(map);
			}
		}catch (Exception e) {
			logger.info("Error message : "+e.getMessage());
		}
	return resultList;
}
}
