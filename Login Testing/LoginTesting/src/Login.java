import java.io.BufferedReader;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Login extends Thread {
	URL url;

	public void run() {
		for(int i=0;i<10;i++) {
		try {
		url = new URL("http://localhost:8080/Registration/Login");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		Map<String, String> parameters = new HashMap<>();
		 Random ran = new Random();
		parameters.put("email",""+ran.nextInt(30)+"@gmail.com" );
		parameters.put("password", "15");
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
		
		con.setConnectTimeout(1000);
		con.setReadTimeout(1000);
		out.flush();
		out.close();
		
		//System.out.println(Thread.currentThread().getId());
		
		int code = con.getResponseCode();
		System.out.println(code);
	
		String responseLine = null;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))){
			StringBuilder response = new StringBuilder();
	
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
		}
			}
		catch(Exception e) {
			
		}
		}
		}
	public static void main(String[] args) throws IOException {
		
		try {
			for(int i=0;i<20;i++) {
			Login object= new Login();
            object.start();
            Thread.sleep(2000);
		}
		}
		
		
		catch (Exception e) {
		    e.printStackTrace();
	}
	}
}