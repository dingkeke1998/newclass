package com.tjetc.domain;

import org.apache.ibatis.type.Alias;

//1.����:id serialno,expire,(1��1) people����
//2.getter setter����
//3.�޲Σ�ȫ�Σ�ȱ�������͹�ϵ����ȱ�ٹ�ϵ����Ĺ��췽����toString����
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
