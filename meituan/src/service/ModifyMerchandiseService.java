package service;

import dao.RegisterDao;

public class ModifyMerchandiseService {
	private RegisterDao rd=new RegisterDao();
    public int ModifyMerchandise(String pname,String pprice,String imgurl,String pnum,String pid){
    	String sql="update product set pname=?,pprice=?,imgurl=?,pnum=? where pid=?";
    	String[] params={pname,pprice,imgurl,pnum,pid};
    	int result=rd.update(sql, params);
    	return result;	
    }
}
