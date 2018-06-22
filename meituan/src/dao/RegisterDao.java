package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class RegisterDao {
	private String driver;
	private String url;
	private String username;
	private String password;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RegisterDao() {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/meituan?useSSL=true";
		username = "root";
		password = "root";
	}
	private Connection getConnection(){
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	private PreparedStatement getPreparedStatement(String sql){
		try {
			pstmt=getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	private void setParams(String sql,String [] params){
		pstmt=this.getPreparedStatement(sql);
		if(params!=null)
		for(int i=0;i<params.length;i++){
			try {
				pstmt.setString(i+1, params[i]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Map<String, String>> getList(String sql,String[] params){
		List<Map<String, String>> list=new ArrayList<Map<String, String>>();
		this.setParams(sql, params);
		try {
			ResultSet rs=pstmt.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			while(rs.next()){
				Map<String, String> m=new HashMap<String, String>();
				for(int i=1;i<=rsmd.getColumnCount();i++){
					String colName=rsmd.getColumnName(i);
					m.put(colName, rs.getString(colName));
				}
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	
	
	
	public Map<String, String> getMap(String sql,String[] params){
		List<Map<String, String>> list=getList(sql, params);
		if(list.isEmpty()){
			return null;
		}else{
			return (Map<String, String>) list.get(0);
		}
	}

	public int update(String sql,String[] params){
		int recNo=0;
		try {
			setParams(sql, params);
			recNo=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return recNo;
				
	}
	private void close() {
		try {
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}


}
