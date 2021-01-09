package com.tjetc.domain;
//1.���� id,name,gender,(��Զ�)set<Book>����
//2.getter setter����
//3.�޲Σ�ȫ�Σ�ȱ�������͹�ϵ����ȱ�������Ĺ��췽����toString����

import java.util.Set;

import org.apache.ibatis.type.Alias;
@Alias("Authors")
public class Authors {
 @Override
	public String toString() {
		return "Authors [id=" + id + ", name=" + name + ", gender=" + gender + ", books=" + books + "]";
	}
private Integer id;
 private String  name;
 private String  gender;
 private Set<Books> books;
public Authors(Integer id, String name, String gender) {
	super();
	this.id = id;
	this.name = name;
	this.gender = gender;
}
public Authors(String name, String gender, Set<Books> books) {
	super();
	this.name = name;
	this.gender = gender;
	this.books = books;
}
public Authors() {
	super();
	// TODO Auto-generated constructor stub
}
public Authors(Integer id, String name, String gender, Set<Books> books) {
	super();
	this.id = id;
	this.name = name;
	this.gender = gender;
	this.books = books;
}
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
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Set<Books> getBooks() {
	return books;
}
public void setBooks(Set<Books> books) {
	this.books = books;
}
}
