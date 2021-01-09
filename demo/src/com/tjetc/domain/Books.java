package com.tjetc.domain;
//1.���ԣ�id,name,isbn, ��һ�Զࣩpresss����Զࣩset<Authors>
//2.getter setter����
//3.�޲Σ�ȫ�Σ�ȱ�������͹�ϵ����ȱ�������Ĺ��췽����toString����

import java.util.Set;

import org.apache.ibatis.type.Alias;
@Alias("Books")
public class Books {
  private Integer id;
  private String name;
  private String isbn;
  private Presses presses;
  private Set<Authors> authors;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public Presses getPresses() {
	return presses;
}
public void setPresses(Presses presses) {
	this.presses = presses;
}
public Set<Authors> getAuthors() {
	return authors;
}
public void setAuthors(Set<Authors> authors) {
	this.authors = authors;
}
public Books(Integer id, String name, String isbn, Presses presses, Set<Authors> authors) {
	super();
	this.id = id;
	this.name = name;
	this.isbn = isbn;
	this.presses = presses;
	this.authors = authors;
}
public Books() {
	super();
	// TODO Auto-generated constructor stub
}
public Books(String name, String isbn, Presses presses, Set<Authors> authors) {
	super();
	this.name = name;
	this.isbn = isbn;
	this.presses = presses;
	this.authors = authors;
}
public Books(String name, String isbn) {
	super();
	this.name = name;
	this.isbn = isbn;
}
@Override
public String toString() {
	return "Books [id=" + id + ", name=" + name + ", isbn=" + isbn + ", presses=" + presses + ", authors=" + authors
			+ "]";
}
  
}
