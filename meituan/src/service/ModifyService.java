package service;
import dao.RegisterDao;

public class ModifyService {
	private RegisterDao rd=new RegisterDao();
    public int modify(String username,String password,String id){
    	String sql="update user set username=?,upassword=? where uid=?";
    	String[] params={username,password,id};
    	int result=rd.update(sql, params);
    	return result;	
    }

}
