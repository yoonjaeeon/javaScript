package com.yedam.dev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetEmpListServlet
 */
@WebServlet("/GetEmpListServlet")
public class GetEmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetEmpListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath()).append("YJE");
		EmpDAO dao = new EmpDAO();
		List<Employee> empList = dao.getEmpList();
//		[{"id":1,"first_name":"Megan","last_name":"Edgington","email":"medgington0@purevolume.com","gender":"Female","ip_address":"111.215.29.33"},
//		 {"id":2,"first_name":"Frederigo","last_name":"Tysack","email":"ftysack1@abc.net.au","gender":"Male","ip_address":"140.96.228.239"},
//		 {"id":3,"first_name":"Bone","last_name":"McNeachtain","email":"bmcneachtain2@tiny.cc","gender":"Male","ip_address":"87.82.24.231"}]
		// {"empId":101,"firstName":"scott","lastName":"tiger"}
		String empJson = "[";
		int rCnt = 0;
		int totalCnt = empList.size();
		for (Employee e : empList) {
			empJson += "{\"empId\":" + e.getEmployeeId() 
					+ ",\"firstName\":\"" + e.getFirstName() 
					+ "\",\"lastName\":\"" + e.getLastName()
					+ "\",\"salary\":\"" + e.getSalary()
					+ "\"}";
			if (++rCnt != totalCnt)
				empJson += ",";
		}
		empJson += "]";
		PrintWriter out = response.getWriter();
		out.print(empJson.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
