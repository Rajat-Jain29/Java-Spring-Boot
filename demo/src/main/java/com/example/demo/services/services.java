package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Course;

public interface services {
	public List<Course> getCourses();
	public Course getCourse(long cid);
	public  Course addc (Course c) ;
			
}
