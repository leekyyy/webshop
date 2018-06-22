package zhku.lyy.web_shop.daoInter;

import java.util.List;

import zhku.lyy.web_shop.entity.Customer;

public interface CustomerDaoInter {
	// ����customer����
	public boolean addCustomer(Customer customer);

	// ɾ��customer����
	public boolean deleteCustomer(Customer customer);

	// �޸�customer����
	public boolean modifyCustomer(Customer customer);

	// ���ݷ��ص�customer�����cname����cphone������customer����
	public Customer getCustomer(Customer customer);

	// ��������customer����
	public List<Customer> page(int page, int pageSize);

	// ����customer�ܼ�¼��
	public int getCount();
}
