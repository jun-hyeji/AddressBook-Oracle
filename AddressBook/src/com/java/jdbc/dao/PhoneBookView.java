package com.java.jdbc.dao;

public class PhoneBookView {
	
	public void phoneBookViewStart() {
		System.out.println("*********************************");
		System.out.println("        전화번호부 관리 프로그램        ");
		System.out.println("*********************************");
	}
	
	public void phoneBookViewMenu() {
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
		System.out.println("---------------------------------");
		System.out.println(">메뉴번호 : ");
	}
	public void phoneBookViewEnd() {
		System.out.println("*********************************");
		System.out.println("             감사합니다             ");
		System.out.println("*********************************");
	}
	public void phoneBookViewError() {
		System.out.println("[다시 입력해주세요.]");
	}
	public void phoneBookViewList() {
		System.out.println("<1.리스트>");
	}
	public void phoneBookViewInsert() {
		System.out.println("<2.등록>");
		System.out.println("> 이름 :");
		System.out.println(">휴대전화 :");
		System.out.println(">집전화 : ");
	}
	public void phoneBookViewDel() {
		System.out.println("<3.삭제>");
		System.out.println(">번호 : ");
	}
	public void phoneBookViewSearch() {
		System.out.println("<4.검색>");
		System.out.println(">이름 : ");
	}
}
