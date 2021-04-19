package com.example.API.control;
import java.io.IOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class control {
	Connection con;
	Statement st;
	String q,conn;
	ResultSet rs;
	public control() {
        super();
        try{
        	Class.forName("com.mysql.jdbc.Driver");
    		conn = "jdbc:mysql://localhost:3306/note";
        	System.out.println("Connected to Database");
	       }	       catch(Exception e){
	    	   System.out.println(e);
	       }   
    }
	@GetMapping("/")
	public ArrayList<HashMap<String, String>>  h(HttpServletRequest request, HttpServletResponse res) throws IOException, SQLException {
		con = DriverManager.getConnection(conn, "root", "");
		st=con.createStatement();
		ArrayList<HashMap<String, String>> a=new ArrayList<>();
		try {
			
			q="select * from notes where isdeleted = "+0+" ";
			rs=st.executeQuery(q);
			while(rs.next()) {
				HashMap<String, String> map = new HashMap<>();
				map.put("noteId",""+rs.getInt("noteId") );
				map.put("title",""+rs.getString("title") );
				map.put("note",""+rs.getString("note") );	
				a.add(map);				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	} 
	@DeleteMapping("/{id}")
	public void g(@PathVariable("id") int id , HttpServletRequest request, HttpServletResponse res) throws Exception {
		con = DriverManager.getConnection(conn, "root", "");
		st=con.createStatement();
		q="update notes set isdeleted = "+1+"  where noteId = "+id+"";
		st.executeUpdate(q);
		res.getWriter().print("Deleted SuccessFully");
	}
	@PostMapping("/create")
	public void p(HttpServletRequest request, HttpServletResponse res) throws Exception {
		int id= Integer.parseInt(request.getParameter("noteId"));
		String title=request.getParameter("title");
		String note=request.getParameter("note");
		con = DriverManager.getConnection(conn, "root", "");
		st=con.createStatement();
		q="insert into notes values ( "+id+",'"+title+"','"+note+"' )";
		st.executeUpdate(q);
		
		res.getWriter().print("Inserted Succesfully");
	}
	@PutMapping("/edit/{id}")
	public void edit(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse res) throws Exception {
		String title=request.getParameter("title");
		con = DriverManager.getConnection(conn, "root", "");
		st=con.createStatement();
		q="update notes set title = '"+title+"' where noteId = "+id+"  ";
		st.executeUpdate(q);
		res.getWriter().print("Updated Succesfully");
	}
	@PutMapping("/restore/{id}")
	public void restore(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse res) throws Exception {
		con = DriverManager.getConnection(conn, "root", "");
		st=con.createStatement();
		q="update notes set isdeleted = '"+0+"' where noteId = "+id+"  ";
		st.executeUpdate(q);
		res.getWriter().print("Restored Succesfully");
	}
	
	

}
