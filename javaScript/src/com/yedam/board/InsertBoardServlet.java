package com.yedam.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dev.EmpDAO;
import com.yedam.dev.Employee;

/**
 * Servlet implementation class InsertBoardServlet
 */
@WebServlet("/InsertBoardServlet")
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertBoardServlet() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String BoardNo = request.getParameter("Board_no");
		String Content = request.getParameter("content");
		String Writer = request.getParameter("writer");
//		String Date = request.getParameter("Create_date");
		System.out.println("content:" + Content + ",writer:" + Writer);
		// 데이터베이스 입력처리
		Board brd = new Board();
//		brd.setBoardNo(Integer.parseInt(BoardNo));
		brd.setContent(Content);
		brd.setWriter(Writer);
//		brd.setDate(Date);

		BoardDAO br = new BoardDAO();
		br.insertBoard(brd);
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
