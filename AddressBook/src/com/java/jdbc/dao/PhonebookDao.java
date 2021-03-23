package com.java.jdbc.dao;

import java.util.List;
import java.util.Scanner;

public interface PhonebookDao {
	public List<PhoneBookVO> getList();
	public List<PhoneBookVO> search(String key);
	public boolean insert(PhoneBookVO vo);
	public boolean update(PhoneBookVO vo);
	public boolean delete(Long id);
	public void listView(List<PhoneBookVo> list);
	public PhoneBookVO addressInfo(Scanner sc);
}
