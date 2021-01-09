package com.tjetc.domain;
//1.属性：id  name （1对1）Passport对象
//2.getter setter方法
//3.无参，全参，缺少主键的构造方法。toString方法
public class Peoples {
   private Integer  id;
   private String   name;
   private Passports passports;
public Peoples() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Peoples [id=" + id + ", name=" + name + ", passports=" + passports + "]";
}
public Peoples(Integer id, String name, Passports passports) {
	super();
	this.id = id;
	this.name = name;
	this.passports = passports;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Peoples(String name) {
	super();
	this.name = name;
}
public Peoples(String name, Passports passports) {
	super();
	this.name = name;
	this.passports = passports;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Passports getPassports() {
	return passports;
}
public void setPassports(Passports passports) {
	this.passports = passports;
}
}
