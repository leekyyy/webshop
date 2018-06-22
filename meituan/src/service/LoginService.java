package service;

import java.util.Map;

import dao.RegisterDao;

public class LoginService {
	private RegisterDao rd=new RegisterDao();
    public Map<String, String> getMap(String name,String password){
   	 String sql="select * from user where username=? and upassword=? and uTypeid=1";
   	 String[] params={name,password};
   	 Map<String, String> result = rd.getMap(sql, params);
   	 return result;
    }
    
    
    public Map<String, String> getmanage(String name,String password){
      	 String sql="select * from user where username=? and upassword=? and uTypeid=2";
      	 String[] params={name,password};
      	 Map<String, String> result = rd.getMap(sql, params);
      	 return result;
       }
    
    
}
