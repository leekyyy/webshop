package service;

import java.util.List;
import java.util.Map;

import dao.RegisterDao;

public class NewOrderService {
	private RegisterDao rd=new RegisterDao();
	public List<Map<String, String>> newOrder(String sid,String state){
		List<Map<String, String>> storesMessage=null;
		String sql="select * from orders where store_id=? and state=?";
		String[] params={sid,state};
		storesMessage=rd.getList(sql, params);
		return storesMessage;
	}
}
