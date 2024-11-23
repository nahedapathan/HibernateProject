package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int bid;
	String bname;
	String bauthor;
	String category;
	int price;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book( String bname, String bauthor, String category, int price) {
		super();
		
		this.bname = bname;
		this.bauthor = bauthor;
		this.category = category;
		this.price = price;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", bauthor=" + bauthor + ", category=" + category + ", price="
				+ price + "]";
	}
	
	
	
	
}
