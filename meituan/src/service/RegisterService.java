package service;

import java.util.Map;

import dao.RegisterDao;

public class RegisterService {
	private RegisterDao rd=new RegisterDao();
     public Map<String, String> getMap(String name){
    	 String sql="select * from user where username=?";
    	 String[] params={name};
    	 Map<String, String> result = rd.getMap(sql, params);
    	 return result;
     }
	
}
