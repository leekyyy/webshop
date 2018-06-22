package service;

import java.util.List;
import java.util.Map;

import dao.RegisterDao;

public class ChangeStoresService {
	private RegisterDao rd=new RegisterDao();
	public List<Map<String, String>>  changeStores(String sid){
		List<Map<String, String>> storesMessage=null;
		String sql="select * from store where sid=?";
		String[] params={sid};
		storesMessage=rd.getList(sql, params);
		return storesMessage;
	}
}
