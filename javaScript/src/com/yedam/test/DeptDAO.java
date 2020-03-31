package com.yedam.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDAO {
	Connection conn = null;

	public DeptDAO() {
		String user = "hr";
		String pass = "hr";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Departments> getDeptList() {
		String sql = "select * from departments";
		List<Departments> deptList = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Departments emp = new Departments();
				emp.setDepartmentId(rs.getInt("Department_Id"));
				emp.setDepartmentName(rs.getString("Department_Name"));
				emp.setManagerId(rs.getInt("Manager_Id"));
				emp.setLocationId(rs.getInt("Location_Id"));
				deptList.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deptList;
	}
}
