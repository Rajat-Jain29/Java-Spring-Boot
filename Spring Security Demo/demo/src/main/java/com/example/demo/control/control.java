package com.example.demo.control;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class control {
	
	@Autowired
	private RestTemplate rest;
	
	@GetMapping("/")
	public String all() {
		return "Hello India";
	}
	
	// Get Method se get api call kr rha hu
	@GetMapping("/user/{id}")
	public String user(@PathVariable("id") int id) {
		
		//Through Simple Method
		String p=rest.getForObject("http://localhost:101/username/"+id, String.class);
		
		//Through Template
		org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
		headers.setAccept( Arrays.asList(MediaType.APPLICATION_JSON) );
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    String h= rest.exchange("http://localhost:101/username/"+id, HttpMethod.GET, entity, String.class).getBody();
		return "Through Simple getForObject method : "+p+" Through Template : "+h;
	}
	
	// Get method se post api call kr rha hu 
	
	@GetMapping("/admin")
	public ResponseEntity<String> admin() {
		org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
		headers.setAccept( Arrays.asList(MediaType.APPLICATION_JSON) );
		MultiValueMap<String, String > map= new LinkedMultiValueMap<>();
		map.add("id",""+1254);
		map.add("username","Rajat Jain");
		map.add("pwd","Password");
		map.add("name","Rajat");
		map.add("email","rajatjain@gmail.com");
		map.add("institution","Albanero SDP");
		map.add("contactno",""+151244);
		map.add("roles", "ROLE_ADMIN");
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
	    ResponseEntity<String> response = rest.postForEntity("http://localhost:101/insert", request , String.class);
		return response;
	}
	
	// Get method se delete api call kr rha hu
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		rest.delete("http://localhost:101/delete/"+id);
		return "Deleted Succesfully ";
	}
	
	// Get method se put api call kr rha hu 
	
	@GetMapping("/put")
	public String put() {
		org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
		headers.setAccept( Arrays.asList(MediaType.APPLICATION_JSON) );
		MultiValueMap<String, String > map= new LinkedMultiValueMap<>();
		map.add("id",""+1);
		map.add("username","Rahul Sharma");
		map.add("pwd","Password");
		map.add("name","Rahul");
		map.add("email","asd@gmail.com");
		map.add("institution","Albaero");
		map.add("contactno",""+151244);
		map.add("roles", "ROLE_ADMIN");
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
		return rest.exchange("http://localhost:101/update", HttpMethod.PUT, request, String.class).getBody();
	}
	
	//Get method se puri list print kr rha hu that also get api 
	
	@GetMapping("/GetAll")
	public String getAll() {
		String p=rest.getForObject("http://localhost:101/get", String.class);
		return p;
	}
}