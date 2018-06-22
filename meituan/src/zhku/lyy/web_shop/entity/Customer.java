package zhku.lyy.web_shop.entity;

public class Customer {
	private int id;
	private String username;
	private String password;
	private int uTypeid;
	
	public Customer() {
		super();
	}

	public Customer(int id,String username, String password, int uTypeid) {
		super();
		this.id=id;
		this.username=username;
		this.password=password;
		this.uTypeid=uTypeid;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getuTypeid() {
		return uTypeid;
	}

	public void setuTypeid(int uTypeid) {
		this.uTypeid = uTypeid;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", cpassword="
				+ password + ", uTypeid=" + uTypeid + "]";
	}

}
