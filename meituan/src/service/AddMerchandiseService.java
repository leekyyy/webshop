package service;

import dao.RegisterDao;

public class AddMerchandiseService {
	private RegisterDao rd=new RegisterDao();
    public int addMerchandise(String pname,String pprice,String imgurl,String pnum,String sid ){
    	String sql="insert into product values (null,?,?,?,?,?)";
    	String[] params={pname,pprice,imgurl,pnum,sid};
    	int result=rd.update(sql, params);
    	return result;	
    }
}
