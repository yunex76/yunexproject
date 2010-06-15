package customer.model.dao;

import customer.model.vo.CustomerVO;

/**
 * 고객관리 비지니스 로직중 Database관련 로직을 담당
 * @author yunex
 *
 */
public class CustomerDAO {

	public void insert(CustomerVO cvo) {
		System.out.println("CustomerDAO.insert() : 고객정보 삽입");
		System.out.println(cvo);
	}

	public CustomerVO selectById(String id)	{
		System.out.println("DAO.selectById() : 고객정보 ID로 조회 - " + id);
		CustomerVO cvo = new CustomerVO("id_111", "pwd_1212", "홍길동", 20);		// 조회정보
		return cvo;
	}
}
