package com.example.demo.reg;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;




@RestController
public class reg {
	public static MongoClient m;
//	http://localhost:8080/Registration/Register  
	@GetMapping("/hi")
	public void a() {
		MongoClient mongo = new MongoClient(new 
				MongoClientURI("mongodb://127.0.0.1:27017"));
	
		DB db = new DB(mongo, "reg");
	
}


	
	
	
	
	
	

}
