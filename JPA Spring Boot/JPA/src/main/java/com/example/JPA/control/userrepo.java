package com.example.JPA.control;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface userrepo extends JpaRepository<user,Integer> {
	
	 public user findByUsername(String username);
	 public user findById(int id);
	 
}
