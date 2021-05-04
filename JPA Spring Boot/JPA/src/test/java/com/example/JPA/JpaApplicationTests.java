package com.example.JPA;



import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNull;


import java.util.List;
import java.util.Optional;




import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.JPA.control.user;
import com.example.JPA.control.*;

@SpringBootTest
class JpaApplicationTests {
	
	@Autowired
	userrepo UserRepo;
	
//	@MockBean
//	control repo;
	
	@Test
	void createTest() {
		user u=new user(13,12445,"abc@##gmail.comm","asuv","Names Full Name","A Password","Harry Bhai","ROLE_USER");
		user use=UserRepo.save(u);
		assertThat(use);

	}
	
	@Test
	void testByid() {
		int id=11;
		Optional<user>u=UserRepo.findById(id);
		assertEquals(11,u.get().getId());
		
	}
	
	@Test
	void testByUsername() {
		String username="Harry Code";
		user u=UserRepo.findByUsername(username);
		//assertThat(u.getUsername()).isEqualTo(username);
		assertEquals("Harry Code", u.getUsername());
	}
	
	@Test
	void testByUsernameNotExist() {
		String username="XEDm";
		user u=UserRepo.findByUsername(username);
		assertNull(u);
	}
	
//	@Test
//	void testByDelete() {
//		int id=29;
//		UserRepo.deleteById(id);
//	}
	
	@Test
	void findall() {
		List<user> users=UserRepo.findAll();
		for(user u:users) {
			System.out.println(u);
		}
		assertThat(users).size().isGreaterThan(0);
		
//	 ((Stream) when(repo.getAll()).thenReturn((List<user>) Stream.of(new user(1,12445,"abc@##gmail.comm","asuv","Names Full Name","A Password","Harry Bhai")))).collect(Collectors.toList());
//	 assertEquals(3,UserRepo.findAll().size());
	}

}