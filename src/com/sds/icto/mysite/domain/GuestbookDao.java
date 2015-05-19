package com.sds.icto.mysite.domain;

import java.sql.*;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.sds.icto.Exception.GuestbookDaoException;
import com.sds.icto.mysite.repository.GuestbookVo;
@Repository
public class GuestbookDao {
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dbURL, "webdb", "webdb");
		

		return conn;
	}

	public void insert(GuestbookVo vo) {
	
		try {
			Connection conn = getConnection();
			String sql = "insert into guestbook values (guestbook_seq.nextval, ?, ?, ?, SYSDATE)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMessage());

			pstmt.executeUpdate();

			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}  catch (ClassNotFoundException | SQLException ex) {
			throw new GuestbookDaoException(ex.getMessage());
		}

	}

	public void delete() {
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();

			String sql = "delete from guestbook";
			stmt.executeUpdate(sql);

			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException ex) {
			throw new GuestbookDaoException(ex.getMessage());
		}
	}

	public void delete(GuestbookVo vo) {
		try {
			Connection conn = getConnection();

			String sql = "delete from guestbook where no = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getPassword());

			pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException ex) {
			throw new GuestbookDaoException(ex.getMessage());
		}

	}

	public List<GuestbookVo> fetchList() {
		List<GuestbookVo> list = new ArrayList<GuestbookVo>();

		try {
			// 1 connection 생성
			Connection conn = getConnection();

			Statement stmt = conn.createStatement();

			String sql = "select * from guestbook";
			ResultSet rs = stmt.executeQuery(sql);

			// 4 결과처리
			while (rs.next()) {
				int no = rs.getInt(1);
				String Name = rs.getString(2);
				String Password = rs.getString(3);
				String Message = rs.getString(4);
				String Date = rs.getString(5);

				GuestbookVo vo = new GuestbookVo();
				vo.setNo(no);
				vo.setName(Name);
				vo.setPassword(Password);
				vo.setMessage(Message);
				vo.setregDate(Date);
				list.add(vo);
			}
			// 5 자원정리
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}  catch (ClassNotFoundException | SQLException ex) {
			throw new GuestbookDaoException(ex.getMessage());
		}

		return list;

	}

}
