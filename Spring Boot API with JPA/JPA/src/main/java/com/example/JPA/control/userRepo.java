package com.example.JPA.control;

import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface userRepo extends JpaRepository<user,Integer> {
	
}
