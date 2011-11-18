import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import vo.DeptVO;

import dao.DepartmentsDAO;


public class TestDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException {
		DepartmentsDAO dao = new DepartmentsDAO();

		System.out.println("Departments ���̺� ��ü ���� ---------------------");
		List list2 = dao.selectAllDept();
		for (Object obj : list2) {
			System.out.println(obj);
		}

		System.out.println("Departments ���̺��� '���ߺ�'�μ� �Ǽ� ���� ---------------------");
		int cnt = dao.selectDepartmentCountByName("���ߺ�");
		System.out.println("'���ߺ�'�μ� �Ǽ� : " + cnt);
		
		if ( cnt == 0 ) {
			
			System.out.println("Departments ���̺��� '���ߺ�2'�μ� �Ǽ� ���� ---------------------");
			int cnt2 = dao.selectDepartmentCountByName("���ߺ�2");
			System.out.println("'���ߺ�2'�μ� �Ǽ� : " + cnt2);
			
			if ( cnt2 == 0 ) {
				System.out.println("Departments ���̺��� '���ߺ�'��� ---------------------");
				HashMap map = new HashMap();
				map.put("id", "700");
				map.put("name", "���ߺ�");
				dao.insertDepartment(map);
			}
			else {
				System.out.println("Departments ���̺��� '���ߺ�'���� ---------------------");
				dao.deleteDepartment(700);
			}
		}
		else {
			System.out.println("Departments ���̺��� '���ߺ�'��Ī ���� ---------------------");
			DeptVO dvo = new DeptVO(700, "���ߺ�2");
			dao.updateDepartment(dvo);
		}

		System.out.println("Departments ���̺��� '���ߺ�'��Ī ���� ---------------------");
		List list = dao.selectDeptByName("���ߺ�");
		for (Object dvo : list) {
			System.out.println(dvo);
		}
	}
}