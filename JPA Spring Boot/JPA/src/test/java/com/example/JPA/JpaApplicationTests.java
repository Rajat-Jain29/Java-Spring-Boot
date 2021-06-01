package com.example.JPA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.JPA.control.control;
import com.example.JPA.control.user;
import com.example.JPA.control.userrepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
class JpaApplicationTests {

	@InjectMocks
	private user User = new user();

	@InjectMocks
	control mockedController = new control();

	userrepo mockedRepo = Mockito.mock(userrepo.class);

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(mockedController).build();
	}

//	@Test
//	void findallUsers() throws Exception {
//		user u1 = new user(50, 7894, "qwe@gmail.com", "microsoft", "zxxc", "zxxc", "zxxc", "ROLE_ADMIN");
//
//		user u2 = new user(60, 417894, "qasdds@gmail.com", "google", "lkj", "lkj", "lkj", "ROLE_ADMIN");
//
//		user u3 = new user(70, 97123, "ragggq@gmail.com", "amazon", "qwee", "qwee", "qwee", "ROLE_USER");
//
//		List<user> userList = new ArrayList<>();
//		userList.add(u3);
//		userList.add(u1);
//		userList.add(u2);
//
//		when(mockedController.getAll()).thenReturn(userList);
//		String expectedJson = this.mapToJson(userList);
//
//		String URI = "/get";
//		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI);
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		String outputJson = result.getResponse().getContentAsString();
//		assertEquals(expectedJson, outputJson);
//
//	}

	@Test
	public void getParticularUser() throws Exception {
		user u2 = new user(60, 417894, "qasdds@gmail.com", "google", "lkj", "lkj", "lkj", "ROLE_ADMIN");

		System.out.println(u2.getId());
		
		when(mockedRepo.findById( Mockito.anyInt() )).thenReturn(u2);
		user result=mockedController.getOne( 66450 );

//		String expectedJson = this.mapToJson(result);
//		System.out.println(expectedJson);
//
//		String URI = "/get/" + u2.getId();
//		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI);
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		String outputJson = result.getResponse().getContentAsString();
//		System.out.println(outputJson);
		assertEquals( u2, result);
	}
	@Test
	public void getParticularUser_FAilure() throws Exception {
		user u1 = new user( );
		when(mockedRepo.findById(Mockito.anyInt())).thenReturn(u1);
		user result=mockedController.getOne( u1.getId() );
//		String expectedJson = this.mapToJson(result);
//		System.out.println(expectedJson);
//
//		String URI = "/get/" + u2.getId();
//		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI);
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		String outputJson = result.getResponse().getContentAsString();
//		System.out.println(outputJson);
		assertEquals( u1, result);
	}
	

	@Test
	public void InsertUser() throws Exception {
		user u2 = new user(60, 417894, "qasdds@gmail.com", "google", "lkj", "lkj", "lkj", "ROLE_ADMIN");
		
		when(mockedRepo.save(Mockito.any(user.class))).thenReturn(u2);
		String result=mockedController.users(u2);
		
		assertEquals("Inserted Succesfully",result);
	}
//	
//	@Test
//	public void DeleteUser() throws Exception {
//		user u2 = new user(60, 417894, "qasdds@gmail.com", "google", "lkj", "lkj", "lkj", "ROLE_ADMIN");
//
//		assertEquals("Deleted Successfully", mockedController.getOneDelete( u2.getId()));
//	}

//	@Test
//	public void getParticularUserName() throws Exception {
//		user u2 = new user(60, 417894, "qasdds@gmail.com", "google", "lkj", "lkj", "lkj", "ROLE_ADMIN");
//
//		when(mockedController.getUserName( u2.getId() )).thenReturn(u2.getUsername());
//		
//		String expectedJson = this.mapToJson(u2.getUsername());
//		System.out.println(expectedJson);
//		
//		String URI = "/username/"+u2.getId();
//		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI);
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		String outputJson = result.getResponse().getContentAsString();
//		System.out.println(outputJson);
//		assertEquals(expectedJson, outputJson);
//	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}