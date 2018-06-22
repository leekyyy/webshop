package service;

import dao.RegisterDao;

public class DeliveryOrderService {
	private RegisterDao rd=new RegisterDao();
    public int modify_state(String oid){
    	String sql="update orders set state=2 where oid=?";
    	String[] params={oid};
    	int result=rd.update(sql, params);
    	return result;	
    }
}
