package zhku.lyy.web_shop.daoInter;

import zhku.lyy.web_shop.entity.User;

public interface UserDaoInter {
	// ���ӹ���Ա
	public boolean addUser(User user);

	// ɾ������Ա
	public boolean deleteUser(User user);

	// �޸Ĺ���Ա
	public boolean modifyUser(User user);
	
	//���ҹ���Ա
	public User getUser(User user);
	
}
