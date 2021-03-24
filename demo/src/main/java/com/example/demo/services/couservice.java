package com.example.demo.services;




import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
@Service
public class couservice implements services {
	
	List<Course> list;
	public couservice(){
		list =new ArrayList<Course>();
		list.add(new Course(145,"Harry","Beautiful"));
		list.add(new Course(15,"Java","Rajat Jain"));
	}
	
	
	
	public List<Course> getCourses() {
		
		// TODO Auto-generated method stub
		return list;
	}



	public Course getCourse(long cid) {
		Course c=null;
		for(Course co:list){
			if(co.getId()==cid){
				c=co;
				break;
			}
		}
		return c;
	}



	public Course addc(Course cr) {
		// TODO Auto-generated method stub
		list.add(cr);
		return cr;
	}



	



		
		
			}



	
