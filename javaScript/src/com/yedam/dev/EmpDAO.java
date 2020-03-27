package com.yedam.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	Connection conn = null;

	public EmpDAO() {
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

	public void insertEmp(Employee emp) {
		String sql = "insert into emp(employee_id, last_name, email, hire_date, job_id)"
				+ "values((select max(employee_id)+1 from emp)," + "?,?,sysdate,?)";// last_name, email, job_id 순.

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getLastName());
			pstmt.setString(2, emp.getEmail());
			pstmt.setString(3, emp.getJobId());
			int iCnt = pstmt.executeUpdate();
			System.out.println(iCnt + "건 입력.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Employee> getEmpList() {
		String sql = "select * from employees";
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_Name"));
				emp.setLastName(rs.getString("last_Name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_Number"));
				emp.setHireDate(rs.getString("hire_Date"));
				emp.setJobId(rs.getString("job_Id"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCommissionPct(rs.getDouble("commission_Pct"));
				emp.setManagerId(rs.getInt("manager_Id"));
				emp.setDepartmentId(rs.getInt("department_Id"));
				list.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
