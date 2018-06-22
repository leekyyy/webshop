package service;

import service.PageBean;


public class UserInfo {
	Method method=new Method();
	public PageBean getUserList(int curPage, String sid){
		String sql="select * from product where store_id=?";
		PageBean pb=method.getPageBean(sql, new String[]{sid}, curPage);
		return pb;
	}

}
