package service;

import java.util.List;
import java.util.Map;

public class PageBean {
	private int curPage;
	private int totalPages;
	private int totalRows;
	private int pageSize;
	private List<Map<String, String>> data;
	public int getCurPage() {
		if(curPage>totalPages){
			curPage=totalPages;
		}
		else if(curPage<1){
			curPage=1;
		}
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTotalPages() {
		if(totalRows % pageSize==0){
			totalPages=totalRows/pageSize;
		}
		else{
			totalPages=totalRows/pageSize+1;
		}
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<Map<String, String>> getData() {
		return data;
	}
	public void setData(List<Map<String, String>> data) {
		this.data = data;
	}
	

}
