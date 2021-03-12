package com.java.Phone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
	private Scanner scan;
	private  Map<String, Phone> PhoneBook;
	
	public PhoneBook() {
		scan = new Scanner(System.in);
		PhoneBook = new HashMap<>();
	}
	
	public void displayMenu(){
		System.out.print(" 1. 리스트");
		System.out.print(" 2. 등록");
		System.out.print(" 3. 삭제");
		System.out.print(" 4. 검색");
		System.out.println(" 5. 종료");
		System.out.println("-----------------------------------------------");
		System.out.print(" > 메뉴번호 :  ");
		
	}
	
	public void phoneBookStart(){
		System.out.println("***********************************************");
		System.out.println("*                전화번호 관리 프로그램             *");
		System.out.println("***********************************************");
		
		while(true){
			
			displayMenu();  // 메뉴 출력
			
			int menuNum = scan.nextInt();   // 메뉴 번호 입력
			
			switch(menuNum){
				case 1 : displayAll();	// 리스트 전체
					break;
				case 2 : insert();		// 등록
					break;
				case 3 : delete();		// 삭제
					break;
				case 4 : search();		// 검색
					break;
				case 5 : 
					System.out.println("***********************************************");
					System.out.println("                   감사합니다                     ");
					System.out.println("***********************************************");
					return;
				default :
					System.out.println("[다시입력하세요]");
			} 
		} 
	}
	
	/*
	 * 전체
	 */
	private void displayAll(){
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("D:\\junhyeji_workspace\\AddressBook\\PhoneDB.txt"));
		}	catch(FileNotFoundException e) {
			e.printStackTrace();
		}String input = null;
		try {
			input = br.readLine();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	

	/*
	 * 등록
	 */
	private void insert() {
		System.out.println("<2.등록>");
		System.out.println();
		System.out.print("이름 >> ");
		String name = scan.next();
		
		if(PhoneBook.get(name) != null) {
			System.out.println("[이미 등록된 사람입니다.]");
			return;
		}
		
		System.out.print("휴대전화 >> ");
		String hp = scan.next();
		
		System.out.print("집전화 >> ");
		scan.nextLine();
		String tel = scan.nextLine();
		
		PhoneBook.put(name, new Phone(name, hp, tel));
		System.out.println("[등록되었습니다.]");
	}

	/*
	 * 삭제
	 */
	private void delete() {
		System.out.println();
		System.out.println("<3.삭제>");
		System.out.print(">> 이름 : ");
		String name = scan.next();
		
		if(PhoneBook.remove(name) == null) {
			System.out.println("[등록된 사람이 아닙니다.]");
		} else {
			System.out.println( "[삭제되었습니다.]");
		}
		System.out.println();
	}

	/*
	 * 검색
	 */
	private void search() {
		System.out.println();
		System.out.println("<4.검색>");
		System.out.print(">> 이름 : ");
		String name = scan.next();
		
		Phone p = PhoneBook.get(name);
		
		if(p == null) {
			System.out.println(name + " 의 전화번호 정보가 없습니다.");
		} else {
			System.out.print("이름 : " + p.getName());
			System.out.print(" 휴대전화 : " + p.getHp());
			System.out.println(" 집전화 : " + p.getTel());
		}
		System.out.println("[검색완료]");
	}
	
	public static void main(String[] args) {
		new PhoneBook().phoneBookStart();
	}
	


}
