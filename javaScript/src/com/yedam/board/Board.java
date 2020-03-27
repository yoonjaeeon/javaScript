package com.yedam.board;

public class Board {
	int boardNo;
	String content;
	String writer;
	String date;

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Board [게시물 번호=" + boardNo + ", 내용=" + content + ", 작성자=" + writer + ", 작성일=" + date + "]";
	}

}