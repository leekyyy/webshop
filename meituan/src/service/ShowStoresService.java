package service;

import java.util.List;
import java.util.Map;

import dao.RegisterDao;

public class ShowStoresService {
	private RegisterDao rd=new RegisterDao();
	public List<Map<String, String>>  showStores(String uid){
		List<Map<String, String>> storesMessage=null;
		String sql="select * from store where user_id=?";
		String[] params={uid};
		storesMessage=rd.getList(sql, params);
		return storesMessage;
	}

}
