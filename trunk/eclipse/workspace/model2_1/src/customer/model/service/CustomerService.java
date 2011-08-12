package customer.model.service;

import customer.model.dao.CustomerDAO;
import customer.model.vo.CustomerVO;

/**
 * ���� ���� �����Ͻ� ������ ó���ϴ� Ŭ����
 * @author yunex
 *
 */
public class CustomerService {

	/**
	 * ȸ�� ���� ó�� �޼ҵ�
	 * @param cvo
	 */
	public void registerCustomer(CustomerVO cvo) {
		CustomerDAO dao = new CustomerDAO();
		dao.insert(cvo);
	}

	/**
	 * ID�� ������ ������ �˻��ϴ� �޼ҵ�
	 * @param id
	 * @return
	 */
	public CustomerVO searchCustomerById(String id) {
		CustomerDAO dao = new CustomerDAO();
		CustomerVO cvo = dao.selectById(id);
		return cvo;
	}
}