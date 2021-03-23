package com.java.jdbc.dao;

public class PhoneBookVO {

	private Long id;
	private String name;
	private String hp;
	private String tel;
	
	public PhoneBookVO() {
			//	기본 생성자
	}
	//getters/setters
	public PhoneBookVO(String name, String hp, String tel) {
		this.name = name;
		this.hp = hp;
		this.tel = tel;
	}
	public PhoneBookVO(Long id, String name, String hp, String tel) {
		this(name, hp, tel);
		this.id = id;
	}
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String gethp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String gettel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "AddressBookVo [ id =" + id + ", name =" + name + ", hp=" + hp + ", tel =" + tel +"]";
	}
}
