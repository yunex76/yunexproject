package customer.model.dao;

import customer.model.vo.CustomerVO;

/**
 * ������ �����Ͻ� ������ Database���� ������ ���
 * @author yunex
 *
 */
public class CustomerDAO {

	public void insert(CustomerVO cvo) {
		System.out.println("CustomerDAO.insert() : ������ ����");
		System.out.println(cvo);
	}

	public CustomerVO selectById(String id)	{
		System.out.println("DAO.selectById() : ������ ID�� ��ȸ - " + id);
		CustomerVO cvo = new CustomerVO("id_111", "pwd_1212", "ȫ�浿", 20);		// ��ȸ����
		return cvo;
	}
}
