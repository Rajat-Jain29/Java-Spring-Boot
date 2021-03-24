package com.example.demo.entity;

public class Course {
	private long id;
	private String title;
	private String desc;
	public Course(long id, String title, String desc) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
	}
	public long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", desc=" + desc + "]";
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
