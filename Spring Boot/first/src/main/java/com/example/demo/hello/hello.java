package com.example.demo.hello;



import org.apache.tomcat.util.http.fileupload.IOUtils;

import org.json.simple.*;
import org.json.simple.parser.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;



@RestController
public class hello {
	FileHandler fh;
	Logger logger = Logger.getLogger("MyLog"); 	
	Date d=new Date();
	final String as="spring.txt";
	URL url;
	@RequestMapping("/hi")
	public void a() throws ParseException, IOException {
		
		JSONParser parser = new JSONParser();
		FileReader f=new FileReader("first.json");
		Object ob=parser.parse(f);
		JSONObject obj=(JSONObject) ob;
		
		String fileName = "config/first.json";
        ClassLoader classLoader = getClass().getClassLoader();
 
        File file = new File(classLoader.getResource(fileName).getFile());
        System.out.println("File Found : " + file.exists());
		
	for(int i=0;i<100;i++) {
		try {  
			
			fh = new FileHandler(as);  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);
	        logger.setLevel(Level.ALL);
	        logger.addHandler(fh);
	        
		url = new URL( (String)obj.get("API") );
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod( (String)obj.get("Method") );
		
		Map<String, String> parameters = new HashMap<>();
		Random ran = new Random();
		
		
//		parameters.put("email",""+ran.nextInt(30)+(String)obj.get("email") );
//		parameters.put("password",(String)obj.get("pass") );
		JSONArray jsonArray = (JSONArray) obj.get("Params");
		
		
        //Iterating the contents of the array
        Iterator<String> iterator = jsonArray.iterator();
        while(iterator.hasNext()) {
        	String param[] = iterator.next().split(":");
        	parameters.put(param[0],param[1]);
        }
        
//		System.out.println(parameters);
		
        
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", (String)obj.get("Type"));
		long start = System.nanoTime();
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
		
		con.setConnectTimeout(1000);
		con.setReadTimeout(1000);
		out.flush();
		out.close();
		long elapsed = System.nanoTime() - start;
		//System.out.println(Thread.currentThread().getId());
		
		int code = con.getResponseCode();
		System.out.println(code);
		String responseLine = null;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))){
			StringBuilder response = new StringBuilder();
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			logger.info( "Current Thread no. :" +Thread.currentThread().getId() + "    Iteration no. "+i+"   Status Code :   " +code+"      API Response:  "+  response.toString() + "   Time taken by API :  "+( elapsed / 1000)+" microseconds" );  
		}
			
		}	
		catch(Exception e) {
			logger.info(" Error Message : "+e.getMessage());
		}
		
		
		}
		}
}
