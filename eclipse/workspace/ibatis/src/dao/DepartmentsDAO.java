package dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vo.DeptVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class DepartmentsDAO {
	private SqlMapClient client;	// 쿼리를 호출하는 메소드를 가진 객체
	
	public DepartmentsDAO() {
		// SqlMapClient 객체 생성
		// 1. SqlMapConfig와 연결된 Reader객체를 생성한다.
		// 2. SqlMapClientBuilder.buildSqlMapClient() 메소드의 argument로 1의 reader 객체를 넣어
		//    sqlMapClient객체를 생성한다.
		String config = "config/SqlMapConfig.xml";		// sqlMapConfig가 있는 경로
		try {
			Reader reader = Resources.getResourceAsReader(config);	// 설정파일과 연결
			client = SqlMapClientBuilder.buildSqlMapClient(reader);	// 설정파일을 통해 SqlMapClient생성
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 특정 부서명의 부서가 몇개가 있는지 조회하는 메소드 
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public int selectDepartmentCountByName(String name) throws SQLException {
		Object obj = client.queryForObject("dept_id_count", name);
		return (Integer)obj;
	}
	
	public void insertDepartment(HashMap map) throws SQLException {
		client.insert("insert_dept", map);
	}
	
	public void updateDepartment(DeptVO dvo) throws SQLException {
		int cnt = client.update("update_dept", dvo);
		System.out.println("변경된 개수 : " + cnt);
	}
	
	public void deleteDepartment(int deptId) throws SQLException {
		int cnt = client.delete("delete_dept", deptId);
		System.out.println("삭제된 개수 : " + cnt);
	}
	
	public List selectDeptByName(String name) throws SQLException {
		List list = client.queryForList("selectByName", name);
		return list;
	}
	
	public List selectAllDept() throws SQLException {
		List list = client.queryForList("select_all_dept", null);
		return list;
	}
}
