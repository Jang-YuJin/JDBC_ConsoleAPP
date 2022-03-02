package empminiprj.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import empminiprj.model.EmpDTO;

public class EmpDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String id = "scott";
	String pw = "tiger";

	public List<EmpDTO> getList(int page){
		String sql = "select * from emp_miniprj_view where num between ? and ?";
		int start = 1 + (page - 1) * 5;
		int end = 5 * page;
		List<EmpDTO> list = new ArrayList<>();
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, id, pw);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, start);
			pst.setInt(2, end);
			ResultSet result = pst.executeQuery();
			while(result.next()) {
				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(result.getInt("empno"));
				empDTO.setEname(result.getString("ename"));
				empDTO.setJob(result.getString("job"));
				empDTO.setMgr(result.getInt("mgr"));
				empDTO.setHiredate(result.getDate("hiredate"));
				empDTO.setSal(result.getInt("sal"));
				empDTO.setComm(result.getInt("comm"));
				empDTO.setDeptno(result.getInt("deptno"));
				list.add(empDTO);
			}
			result.close();
			pst.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int insert(EmpDTO empDTO) {
		String sql = "insert into emp_miniprj values (?, ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
			try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, id, pw);
				PreparedStatement pst = con.prepareStatement(sql);
				result = pst.executeUpdate();
				pst.setInt(1, empDTO.getEmpno());
				pst.setString(2, empDTO.getEname());
				pst.setString(3, empDTO.getJob());
				pst.setInt(4, empDTO.getMgr());
				pst.setDate(5, empDTO.getHiredate());
				pst.setInt(6, empDTO.getSal());
				pst.setInt(7, empDTO.getComm());
				pst.setInt(8, empDTO.getDeptno());
				pst.executeUpdate();
				pst.close();
				con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	
	public int update(EmpDTO empDTO) {
		String sql = "update emp_miniprj set ename = ?, job = ?, mgr = ?, hiredate = ?, sal = ?, comm = ?, deptno = ? where empno = ?";
		int result = 0;
			try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, id, pw);
				PreparedStatement pst = con.prepareStatement(sql);
				result = pst.executeUpdate();
				pst.setInt(8, empDTO.getEmpno());
				pst.setString(1, empDTO.getEname());
				pst.setString(2, empDTO.getJob());
				pst.setInt(3, empDTO.getMgr());
				pst.setDate(4, empDTO.getHiredate());
				pst.setInt(5, empDTO.getSal());
				pst.setInt(6, empDTO.getComm());
				pst.setInt(7, empDTO.getDeptno());
				pst.executeUpdate();
				pst.close();
				con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	
	public int delete(int empno) {
		String sql = "delete from emp_connectpool where empno = ?";
		int result = 0;
			try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, id, pw);
				PreparedStatement pst = con.prepareStatement(sql);
				result = pst.executeUpdate();
				pst.setInt(1, empno);
				pst.executeUpdate();
				pst.close();
				con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
}
