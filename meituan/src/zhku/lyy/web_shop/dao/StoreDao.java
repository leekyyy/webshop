package zhku.lyy.web_shop.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import zhku.lyy.web_shop.entity.Store;
import zhku.lyy.web_shop.utils.JDBC;

public class StoreDao {
	private Connection conn = JDBC.getConnection();
	private PreparedStatement ps = null;
	private ResultSet res = null;

	/*
	 * 
	 * ɾ��customer����
	 */
	public boolean deleteStore(Store store) {
		String sql = "delete from store where sid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, store.getSid());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("ɾ������ʧ��");
			return false;
		}
	}

	/*
	 * 
	 * �޸�customer����
	 */
	public boolean modifyStore(Store store) {
		String sql = "update store set sname=?,saddress=?,stelphone=?,startime=?,endtime=?,deliverytime=?,deliveryfee=? where sid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,store.getSname());
			ps.setString(2,store.getSaddress());
			ps.setString(3,store.getStelphone());
			ps.setString(4,store.getStartime());
			ps.setString(5,store.getEndtime());
			ps.setInt(6,store.getDeliverytime());
			ps.setInt(7,store.getDeliveryfee());
			ps.setInt(8,store.getSid());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("�޸�������Ϣʧ��");
			e.printStackTrace();
			return false;
		}
	}


	/*
	 * 
	 * ��������customer����
	 */
	public List<Store> getStoreList() {
		List<Store> tempc = new LinkedList<Store>();
		try {
			String sql = "select * from store";
			ps = conn.prepareStatement(sql);
			// 3.ִ��SQL���
			res = ps.executeQuery();
			// 4.���ʽ����
			while (res.next()) {
				Store store = new Store(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getTime(5).toString(),res.getTime(6).toString(),res.getInt(7),res.getInt(8),res.getInt(9));
				tempc.add(store);
			}
			return tempc;
		} catch (SQLException e) {
			System.out.println("��ȡ������Ϣʧ��");
			e.printStackTrace();
			return null;
		}
	}
	//����sid��ѯ������Ϣ
	public Store getStoreById(int sid){
		Store s = new Store();
		try {
			String sql = "select * from store where sid = "+sid;
			ps = conn.prepareStatement(sql);
			// 3.ִ��SQL���
			res = ps.executeQuery();
			// 4.���ʽ����
			while (res.next()) {
				s = new Store(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getTime(5).toString(),res.getTime(6).toString(),res.getInt(7),res.getInt(8),res.getInt(9));
			}
			return s;
		} catch (SQLException e) {
			System.out.println("����ID��ȡ������Ϣʧ��");
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * 
	 * ����customer�ܼ�¼��
	 */
	public int getCount() {
		int count = 0;
		String sql = "select count(*) from store";
		try {
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery();
			while (res.next()) {
				count = Integer.valueOf(res.getString(1));
			}
			return count;
		} catch (Exception e) {
			return 0;
		}
	}
}
