package zhku.lyy.web_shop.daoInter;

import zhku.lyy.web_shop.entity.User;

public interface UserDaoInter {
	// 增加管理员
	public boolean addUser(User user);

	// 删除管理员
	public boolean deleteUser(User user);

	// 修改管理员
	public boolean modifyUser(User user);
	
	//查找管理员
	public User getUser(User user);
	
}
