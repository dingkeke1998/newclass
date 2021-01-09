package com.tjetc.domain;
//1.属性：id,name,address (1对多)set<Book> 对象
//2.getter setter方法
//3.无参，全参，缺少主键和关系对象，缺少主键的构造方法，toString方法

import java.util.Set;

import org.apache.ibatis.type.Alias;
@Alias("Presses")
public class Presses {
  private Integer id;
  private String  name;
  private String  address;
  //为什么set 不能存重复的元素。
  private Set<Books> books;
@Override
public String toString() {
	return "Presses [id=" + id + ", name=" + name + ", address=" + address + ", books=" + books + "]";
}
public Presses(String name, String address, Set<Books> books) {
	super();
	this.name = name;
	this.address = address;
	this.books = books;
}
public Presses(String name, String address) {
	super();
	this.name = name;
	this.address = address;
}

public Presses(Integer id, String name, String address) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
}
public Presses(Integer id, String name, String address, Set<Books> books) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Set<Books> getBooks() {
	return books;
}
public void setBooks(Set<Books> books) {
	this.books = books;
}
}
