package com.example.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "payment")

public class Payment {
	@Id
	private int serno;
	@Column(name="name")
	private String name;
	private String email;
	private String phno;
	private String zname;
	private String acno;
	public String getAcno() {
		return acno;
	}
	public void setAcno(String acno) {
		this.acno = acno;
	}
	private double amt;
	private String date;
	
	public int getSerno() {
		return serno;
	}
	public void setSerno(int serno) {
		this.serno = serno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getZname() {
		return zname;
	}
	public void setZname(String zname) {
		this.zname = zname;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	
	public String getDate() {
	    Date d = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    date= dateFormat.format(d);
	    return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
