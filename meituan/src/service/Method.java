package service;
import java.util.List;
import java.util.Map;

import dao.RegisterDao;
import service.PageBean;

public class Method {
	RegisterDao db=new RegisterDao();
	private int pageSize=3;
	private int getTotalRows(String sql,String[] params){
		int totalRows=0;
		sql=sql.toLowerCase();
		String countSql="select count(*) as tempNum "+sql.substring(sql.indexOf("from"));
		String count=(String) db.getMap(countSql, params).get("tempNum");
		totalRows=Integer.parseInt(count);
		return totalRows;
	}
	public PageBean getPageBean(String sql,String[] params,int curPage){
		String newSql=sql+" limit "+(curPage-1)*pageSize+","+pageSize;
		List<Map<String, String>> data=db.getList(newSql, params);
		PageBean pb=new PageBean();
		pb.setTotalRows(getTotalRows(sql, params));
		pb.setPageSize(pageSize);
		pb.getTotalPages();
		pb.setCurPage(curPage);
		pb.setData(data);
		return pb;	
	}
}
