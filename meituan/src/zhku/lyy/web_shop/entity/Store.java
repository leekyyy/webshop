package zhku.lyy.web_shop.entity;

import java.util.Date;

public class Store {
	private int user_id;	//
	private int sid;
	private String sname;
	private String saddress;
	private String stelphone;
	private String startime;
	private String endtime;
	private int deliverytime;
	private int deliveryfee;
	
	public Store(){}
	public Store(String sname,String saddress,String stelphone,String startime,String endtime,int deliverytime,int deliveryfee){
		this.sname=sname;
		this.saddress=saddress;
		this.stelphone=stelphone;
		this.startime=startime;
		this.endtime=endtime;
		this.deliverytime=deliverytime;
		this.deliveryfee=deliveryfee;
	}
	public Store(int user_id,String sname,String saddress,String stelphone,String startime,String endtime,int deliverytime,int deliveryfee,int sid){
		this.user_id=user_id;
		this.sid=sid;
		this.sname=sname;
		this.saddress=saddress;
		this.stelphone=stelphone;
		this.startime=startime;
		this.endtime=endtime;
		this.deliverytime=deliverytime;
		this.deliveryfee=deliveryfee;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getStelphone() {
		return stelphone;
	}
	public void setStelphone(String stelphone) {
		this.stelphone = stelphone;
	}
	public String getStartime() {
		return startime;
	}
	public void setStartime(String startime) {
		this.startime = startime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public int getDeliverytime() {
		return deliverytime;
	}
	public void setDeliverytime(int deliverytime) {
		this.deliverytime = deliverytime;
	}
	public int getDeliveryfee() {
		return deliveryfee;
	}
	public void setDeliveryfee(int deliveryfee) {
		this.deliveryfee = deliveryfee;
	}
	
}
