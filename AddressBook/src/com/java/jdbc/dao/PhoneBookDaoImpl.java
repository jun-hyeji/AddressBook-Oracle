package com.java.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PhoneBookDaoImpl implements PhoneBookDao{
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dbur1 = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dbur1, "C##JHJ", "1234");
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		}
		return conn;
	}

	@Override
	public List<PhoneBookVO> getList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<PhoneBookVO> list = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "SELECT id, name, hp, tel, FROM phone_book ORDER BY id";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				PhoneBookVO vo = new PhoneBookVO(rs.getLong(1),rs.getString(2),rs.getString(3), rs.getString(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public List<PhoneBookVO> search(String key) {
		List<PhoneBookVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sq1 = "SELECT id, hp, tel FROM phone_book WHERE name LIKE ? ORDER BY id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+key+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PhoneBookVO vo = new PhoneBookVO(rs.getLong(1),rs.getString(2),rs.getString(3), rs.getString(4));
				list.add(vo);
			}
			
		}catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						rs.close();
						pstmt.close();
						conn.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
		return null;
	}

	@Override
	public boolean insert(PhoneBookVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " INSERT INTO phone_book VALUES(seq_phone_book.NEXTVAL,?,?,?)";
		int insertedCount = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.gethp());
			pstmt.setString(3, vo.gettel());
			
			insertedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

//	@Override
//	public boolean update(PhoneBookVO vo) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public boolean delete(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELET FROM phone_book WHERE id = ?";
		int deletedCount = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			deletedCount = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e ) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public void listView(List<PhoneBookVO> list) {
		Iterator<PhoneBookVO> it = list.iterator();
		
		while (it.hasNext()) {
			PhoneBookVO vo = it.next();
			System.out.println(vo);
		}
		System.out.println( );
		
	}

	@Override
	public PhoneBookVO addressInfo(Scanner sc) {
		System.out.println(">이름 : ");
		String name = sc.next();
		System.out.println(">휴대전화 : ");
		String hp = sc.next();
		System.out.println(">집전화 : ");
		String tel = sc.next();
		PhoneBookVO vo = new PhoneBookVO(name, hp , tel);
		return vo;
	}
	
}
