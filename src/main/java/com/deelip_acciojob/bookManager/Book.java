package com.deelip_acciojob.bookManager;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Book {
	
	
	private Integer id;
	private String title;
	private String author;
	private Integer pages;
	
	public Book() {
		
		// TODO Auto-generated constructor stub
	}
	public Book(Integer id, String title, String author, Integer pages) {
		
		this.id = id;
		this.title = title;
		this.author = author;
		this.pages = pages;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
}
