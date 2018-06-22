package zhku.lyy.web_shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import zhku.lyy.web_shop.daoInter.CustomerDaoInter;
import zhku.lyy.web_shop.entity.Customer;
import zhku.lyy.web_shop.utils.JDBC;

public class CustomerDao implements CustomerDaoInter {
	private Connection conn = JDBC.getConnection();
	private PreparedStatement ps = null;
	private ResultSet res = null;

	/*
	 * 
	 * ����customer����
	 */
	@Override
	public boolean addCustomer(Customer customer) {
		try {
			String sql = "select * from user where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getUsername());
			res = ps.executeQuery();
			if (res.next()) { // ������ͬ�û�����
				return false;
			}
				String sql1 = "insert into user values(null,?,?,?)";
				ps = conn.prepareStatement(sql1);
				ps.setString(1, customer.getUsername());
				ps.setString(2, customer.getPassword());
				ps.setInt(3, customer.getuTypeid());
				ps.executeUpdate();
				return true;
		} catch (SQLException e) {
			System.out.println("�����û�ʧ��");
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * 
	 * ɾ��customer����
	 */
	@Override
	public boolean deleteCustomer(Customer customer) {
		String sql = "delete from user where username=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getUsername());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 
	 * �޸�customer����
	 */
	@Override
	public boolean modifyCustomer(Customer customer) {
		String sql = "update user set username=?,upassword=?,uTypeid=? where uid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getUsername());
			ps.setString(2, customer.getPassword());
			ps.setInt(3, customer.getuTypeid());
			ps.setInt(4, customer.getId());
			System.out.println(customer.getUsername()+":"+customer.getPassword()+":"+customer.getuTypeid()+":"+customer.getId());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("�޸��û�ʧ��");
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * 
	 * ���ݷ��ص�customer�����cname����cphone������customer����
	 */
	@Override
	public Customer getCustomer(Customer customer) {
		Customer tempC = null;
		String index = "";
		String sql = "";
		boolean flag = false;
		if (customer.getUsername() != null && !customer.getUsername().equals("")) {// ������߶�������cname����
			index = customer.getUsername();
			flag = true; // ���ڱ��index��������cname
		}
		if (!index.equals("") && flag) {
			sql = "select * from user where username=?";
		}else {
			return null;
		}
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, index);
			res = ps.executeQuery();
			while (res.next()) {
				tempC = new Customer(res.getInt(1), res.getString(2),
						res.getString(3), res.getInt(4));
			}
			return tempC;
		} catch (Exception e) {
			System.out.println("��ȡ�û���Ϣʧ��");
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * 
	 * ��������customer����
	 */
	@Override
	public List<Customer> page(int page, int pageSize) {
		List<Customer> tempc = new LinkedList<Customer>();
		try {
			String sql = "select * from user limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, page);
			ps.setInt(2, pageSize);
			// 3.ִ��SQL���
			res = ps.executeQuery();
			// 4.���ʽ����
			while (res.next()) {
				tempc.add(new Customer(res.getInt(1), res.getString(2),
						res.getString(3), res.getInt(4)));
			}
			return tempc;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * 
	 * ����customer�ܼ�¼��
	 */
	@Override
	public int getCount() {
		int count = 0;
		String sql = "select count(*) from user";
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
