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

public class Login {
	public static void main(String[] args) throws IOException {
		URL url;
		try {
			for(int i=0;i<100;i++) {
				url = new URL("http://localhost:8080/Registration/Login");
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("POST");
				Map<String, String> parameters = new HashMap<>();
				parameters.put("email", "22@gmail.com");
				parameters.put("password", "15");
				con.setDoOutput(true);
				con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			DataOutputStream out = new DataOutputStream(con.getOutputStream());
			out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
			
			con.setConnectTimeout(1000);
			con.setReadTimeout(1000);
			out.flush();
			out.close();
			int code = con.getResponseCode();
//			System.out.println(con.getInputStream());
//			System.out.println(con.getInputStream());
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
		}
		catch (MalformedURLException e) {
		    e.printStackTrace();
		}
	}
}