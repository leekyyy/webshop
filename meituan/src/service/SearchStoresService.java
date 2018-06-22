package service;

import java.util.List;
import java.util.Map;

import dao.RegisterDao;

public class SearchStoresService {
	private RegisterDao rd=new RegisterDao();
	public List<Map<String, String>>  showStores(String name,String uid){
		List<Map<String, String>> storesMessage=null;
		String sql="select * from store where sname like ?  and user_id=?";
		String[] params={name,uid};
		storesMessage=rd.getList(sql, params);
		return storesMessage;
	}
}
