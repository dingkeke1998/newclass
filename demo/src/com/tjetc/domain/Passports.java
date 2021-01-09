package com.tjetc.domain;

import org.apache.ibatis.type.Alias;

//1.属性:id serialno,expire,(1对1) people对象
//2.getter setter方法
//3.无参，全参，缺少主键和关系对象；缺少关系对象的构造方法，toString方法
@Alias("Passports")
public class Passports {
  private Integer id;
  private String serialno;
  private Integer exprie;
  private Peoples peoples;
public Passports() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Passports [id=" + id + ", serialno=" + serialno + ", exprie=" + exprie + ", peoples=" + peoples + "]";
}
public Passports(String serialno, Integer exprie) {
	super();
	this.serialno = serialno;
	this.exprie = exprie;
}
public Passports(String serialno, Integer exprie, Peoples peoples) {
	super();
	this.serialno = serialno;
	this.exprie = exprie;
	this.peoples = peoples;
}
public Passports(Integer id, String serialno, Integer exprie, Peoples peoples) {
	super();
	this.id = id;
	this.serialno = serialno;
	this.exprie = exprie;
	this.peoples = peoples;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getSerialno() {
	return serialno;
}
public void setSerialno(String serialno) {
	this.serialno = serialno;
}
public Integer getExprie() {
	return exprie;
}
public void setExprie(Integer exprie) {
	this.exprie = exprie;
}
public Peoples getPeoples() {
	return peoples;
}
public void setPeoples(Peoples peoples) {
	this.peoples = peoples;
}
}
