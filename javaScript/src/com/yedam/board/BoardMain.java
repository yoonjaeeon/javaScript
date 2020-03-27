package com.yedam.board;

import java.util.List;

public class BoardMain {

	public static void main(String[] args) {
		// 전체 조회

		/*
		 * BoardDAO b = new BoardDAO(); List<Board> blist = b.getBoardList(); for (Board
		 * brd : blist) { System.out.println(brd); }
		 */
		// 한 건 조회

		BoardDAO b = new BoardDAO();
		Board brd = b.getBoardInfo(3);
		System.out.println(brd);

		// INSERT

		/*
		 * Board board = new Board(); board.setContent("JAVA TEST");
		 * board.setWriter("user1");
		 * 
		 * b.insertBoard(board);
		 */
	}
}