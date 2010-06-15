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

		System.out.println("Departments 테이블 전체 쿼리 ---------------------");
		List list2 = dao.selectAllDept();
		for (Object obj : list2) {
			System.out.println(obj);
		}

		System.out.println("Departments 테이블에 '개발부'부서 건수 쿼리 ---------------------");
		int cnt = dao.selectDepartmentCountByName("개발부");
		System.out.println("'개발부'부서 건수 : " + cnt);
		
		if ( cnt == 0 ) {
			
			System.out.println("Departments 테이블에 '개발부2'부서 건수 쿼리 ---------------------");
			int cnt2 = dao.selectDepartmentCountByName("개발부2");
			System.out.println("'개발부2'부서 건수 : " + cnt2);
			
			if ( cnt2 == 0 ) {
				System.out.println("Departments 테이블에 '개발부'등록 ---------------------");
				HashMap map = new HashMap();
				map.put("id", "700");
				map.put("name", "개발부");
				dao.insertDepartment(map);
			}
			else {
				System.out.println("Departments 테이블에 '개발부'삭제 ---------------------");
				dao.deleteDepartment(700);
			}
		}
		else {
			System.out.println("Departments 테이블에 '개발부'명칭 변경 ---------------------");
			DeptVO dvo = new DeptVO(700, "개발부2");
			dao.updateDepartment(dvo);
		}

		System.out.println("Departments 테이블에 '개발부'명칭 쿼리 ---------------------");
		List list = dao.selectDeptByName("개발부");
		for (Object dvo : list) {
			System.out.println(dvo);
		}
	}
}
