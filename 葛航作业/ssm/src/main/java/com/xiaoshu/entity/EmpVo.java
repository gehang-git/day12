package com.xiaoshu.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EmpVo extends Emp{

	private String dname;
	
	private Integer age1;
	private Integer age2;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday1;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday2;
	private String sex;
	
	private Integer num;
	
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	private String cname1;
	private String cname2;
	private String cname3;
	
	
	public String getCname1() {
		return cname1;
	}
	public void setCname1(String cname1) {
		this.cname1 = cname1;
	}
	public String getCname2() {
		return cname2;
	}
	public void setCname2(String cname2) {
		this.cname2 = cname2;
	}
	public String getCname3() {
		return cname3;
	}
	public void setCname3(String cname3) {
		this.cname3 = cname3;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Integer getAge1() {
		return age1;
	}
	public void setAge1(Integer age1) {
		this.age1 = age1;
	}
	public Integer getAge2() {
		return age2;
	}
	public void setAge2(Integer age2) {
		this.age2 = age2;
	}
	public Date getBirthday1() {
		return birthday1;
	}
	public void setBirthday1(Date birthday1) {
		this.birthday1 = birthday1;
	}
	public Date getBirthday2() {
		return birthday2;
	}
	public void setBirthday2(Date birthday2) {
		this.birthday2 = birthday2;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
