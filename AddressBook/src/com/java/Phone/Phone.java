package com.java.Phone;

class Phone{
	private String name;	// 이름
	private String hp;	// 휴대전화
	private String tel;		// 집전화
	
	public Phone(String name, String hp, String tel) {
		super();
		this.name = name;
		this.hp = hp;
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "[이름 : " + name + ", 휴대전화 : " + hp + ", 집전화 : " + tel + "]";
	}
	
	
}