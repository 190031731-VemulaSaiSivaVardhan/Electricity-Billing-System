package com.example.demo;

public class Calculator {
	public int a,b;
	public long getSerno() {
		return serno;
	}
	public void setSerno(long serno) {
		this.serno = serno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZname() {
		return zname;
	}
	public void setZname(String zname) {
		this.zname = zname;
	}
	public long serno;
	public String name,zname;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public double getRes() {
		return res;
	}
	public void setRes(double res) {
		this.res = res;
	}
	public double res;
	
	public double getResult()
	{
		double r=0.0;
		int units=b-a;
		int runits=units-100;

		if (runits > 100){
		        if (runits >= 200){
		             r=r+(100.0*2.00);
		        }
		        else{
		              r=r+(runits*2.00);

		}}
		         
		if (runits > 201){
		          if (runits > 400){
		              r=r+(200.0*4.00);
		          }else{
		             runits=runits-100;
		             r=r+(runits*4.00);
		             }   
		}
		             
		if (runits > 400){
		        if(runits > 600){
		            r=r+(runits*6.00);
		        } else{
		           runits=runits-400;
		           r=r+(runits*6.00);
		          }
		}
		return r;
	}
	public double getUnits()
	{
		return b-a;
	}
}
