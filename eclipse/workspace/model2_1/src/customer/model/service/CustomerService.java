package customer.model.service;

import customer.model.dao.CustomerDAO;
import customer.model.vo.CustomerVO;

/**
 * 고객 관리 비지니스 로직을 처리하는 클래스
 * @author yunex
 *
 */
public class CustomerService {

	/**
	 * 회원 가입 처리 메소드
	 * @param cvo
	 */
	public void registerCustomer(CustomerVO cvo) {
		CustomerDAO dao = new CustomerDAO();
		dao.insert(cvo);
	}

	/**
	 * ID를 가지고 고객을 검색하는 메소드
	 * @param id
	 * @return
	 */
	public CustomerVO searchCustomerById(String id) {
		CustomerDAO dao = new CustomerDAO();
		CustomerVO cvo = dao.selectById(id);
		return cvo;
	}
}
