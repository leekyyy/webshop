package service;


import dao.RegisterDao;

public class AddStoresService {
	private RegisterDao rd=new RegisterDao();
    public int addStores(String name,String address,String telphone, String startime,String endtime, String delivertime,String deliverfess, String uid){
    	String sql="insert into store values(null,?,?,?,?,?,?,?,?)";
    	String[] params={name,address,telphone,startime,endtime,delivertime,deliverfess,uid};
    	int result=rd.update(sql, params);
    	return result;	
    }
}
