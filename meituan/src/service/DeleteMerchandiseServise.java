package service;

import dao.RegisterDao;

public class DeleteMerchandiseServise {
	private RegisterDao rd=new RegisterDao();
    public int delete_merchandise(String pid){
    	String sql="delete from product where pid=?";
    	String[] params={pid};
    	int result=rd.update(sql, params);
    	return result;	
    }
}
