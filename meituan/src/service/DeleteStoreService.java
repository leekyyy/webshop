package service;

import dao.RegisterDao;

public class DeleteStoreService {
	private RegisterDao rd=new RegisterDao();
    public int delete_stores(String sid){
    	String sql="delete from store where sid=?";
    	String[] params={sid};
    	int result=rd.update(sql, params);
    	return result;	
    }
}
