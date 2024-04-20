package com.epay.encdata.entity;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*@Setter
@Getter
@ToString*/
public class Book {

	
	@Column(name ="bookName")
	protected String bookName;
	
	@Column(name ="writer")
	protected String writer;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", writer=" + writer + "]";
	}
	
	
}
