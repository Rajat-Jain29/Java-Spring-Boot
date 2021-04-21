import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.time.ZonedDateTime;
import java.util.logging.*;

public class test extends Thread{
	URL url;
	FileHandler fh;
	Logger logger = Logger.getLogger("MyLog"); 	
	Date d=new Date();
	final String as="log.txt";
	public void run() {
		try {
		for(int i=0;i<2;i++) {
		fh = new FileHandler(as);  
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);
        logger.setLevel(Level.ALL);
        logger.addHandler(fh);
        
		url = new URL("http://localhost:8080/Registration/Login");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		Map<String, String> parameters = new HashMap<>();
		 Random ran = new Random();
		parameters.put("email",""+ran.nextInt(30)+"@gmail.com" );
		parameters.put("password", "15");
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		
		long start = System.nanoTime();
		//long elapsed = System.nanoTime() - start;
		  //      System.out.println("Elapsed (ms): " + elapsed / 1000000);
		
		//double t1=ZonedDateTime.now().toInstant().toEpochMilli();
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
		con.setConnectTimeout(1000);
		con.setReadTimeout(1000);
		out.flush();
		out.close();
		
		long elapsed = System.nanoTime() - start;
		//double t2=ZonedDateTime.now().toInstant().toEpochMilli();
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
		}
		catch(Exception e) {
		
			logger.info(" Error Message : "+e.getMessage());
		}
		
		
		
}
public static void main(String[] args) throws IOException {
	try {
		for(int i=0;i<50;i++) {
		test object= new test();
        object.start();
        Thread.sleep(500);
	}
	}
	
	
	catch (Exception e) {
	    e.printStackTrace();
}
	}
	}