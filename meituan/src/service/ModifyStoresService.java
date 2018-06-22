package service;

import dao.RegisterDao;

public class ModifyStoresService {
	private RegisterDao rd=new RegisterDao();
    public int ModifyStores(String name,String address,String telphone, String startime,String endtime, String delivertime,String deliverfess, String sid){
    	String sql="update store set sname=?,saddress=?,stelphone=?,startime=?,endtime=?,deliverytime=?,deliveryfee=? where sid=?";
    	String[] params={name,address,telphone,startime,endtime,delivertime,deliverfess,sid};
    	int result=rd.update(sql, params);
    	return result;	
    }

}
