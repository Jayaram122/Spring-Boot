package com.demo.mvc.entity;

import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="book_name")
	private String bookName;
	@Column(name="authhor_name")
	private String authhorName;
	@Column(name="book_price")
	private int bookPrice;
	@Column(name="book_category")
	private String bookCategory;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthhorName() {
		return authhorName;
	}
	public void setAuthhorName(String authhorName) {
		this.authhorName = authhorName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", authhorName=" + authhorName + ", bookPrice=" + bookPrice
				+ ", bookCategory=" + bookCategory + "]";
	}
	
	
}
