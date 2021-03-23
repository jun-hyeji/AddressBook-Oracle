package com.java.jdbc.dao;

import java.util.Scanner;

public class PhoneBookController {
	protected void phoneBook(){
		
		PhoneBookDao dao = new PhoneBookDaoImpl();
		PhoneBookView pbView = new PhoneBookView();
		
		pbView.phoneBookViewStart();
		Scanner sc= new Scanner (System.in);
		while (true) {
			pbView.phoneBookViewMenu();
			switch(sc.nextInt()) {
			case 1 :
					dao.listView(dao.getList());
					continue;
			case 2 :
					pbView.phoneBookViewInsert();
					if(dao.insert(dao.addressInfo(sc))) {
						System.out.println("[등록되었습니다]");
					}else {
						pbView.phoneBookViewError();
					}
					continue;
			case 3 :
					pbView.phoneBookViewDel();
					if(dao.delete(sc.nextLong())) {
						System.out.println("[삭제되었습니다]");
					}else {
						pbView.phoneBookViewError();
					}
					continue;
			case 4 : 
					pbView.phoneBookViewSearch();
					dao.listView(dao.search(sc.next()));
					continue;
			case 5 : 
					pbView.phoneBookViewEnd();
					break;
			default : 
					pbView.phoneBookViewError();
					continue;
			}
			sc.close();
			break;
		}
	}
}
