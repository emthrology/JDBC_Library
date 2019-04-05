package library.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.common.JDBCTemplate;
import library.model.vo.Customer;

public class CustmDao {
	public ArrayList<Customer> setCustmList(Connection conn) {
		ArrayList<Customer> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from customer";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<Customer>();
			while(rset.next()) {
				Customer c = new Customer();
				c.setUserNo(rset.getInt("user_no"));
				c.setUserId(rset.getString("user_id"));
				c.setUserName(rset.getString("user_name"));
				c.setUserAge(rset.getInt("user_age"));
				c.setAddr(rset.getString("addr"));
				c.setGender(rset.getString("gender"));
				c.setEnrollDate(rset.getDate("enroll_date"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return list;
	}
	
	public ArrayList<Customer> setCustmoerByName(Connection conn,String name) {
		ArrayList<Customer> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from customer where user_name like ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+name+"%");
			rset = pstmt.executeQuery();
			list = new ArrayList<Customer>();
			while(rset.next()) {
				Customer c = new Customer();
				c.setUserNo(rset.getInt("user_no"));
				c.setUserId(rset.getString("user_id"));
				c.setUserName(rset.getString("user_name"));
				c.setUserAge(rset.getInt("user_age"));
				c.setAddr(rset.getString("addr"));
				c.setGender(rset.getString("gender"));
				c.setEnrollDate(rset.getDate("enroll_date"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public Customer setCustomerById(Connection conn,String id) {
		Customer c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from customer where user_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				c = new Customer();
				c.setUserNo(rset.getInt("user_no"));
				c.setUserId(rset.getString("user_id"));
				c.setUserName(rset.getString("user_name"));
				c.setUserAge(rset.getInt("user_age"));
				c.setAddr(rset.getString("addr"));
				c.setGender(rset.getString("gender"));
				c.setEnrollDate(rset.getDate("enroll_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return c;
	}
	
	public int setInsert(Connection conn,Customer c) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into customer values(?,?,?,?,?,?,default)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, c.getUserNo());
			pstmt.setString(2, c.getUserId());
			pstmt.setString(3, c.getUserName());
			pstmt.setInt(4, c.getUserAge());
			pstmt.setString(5, c.getAddr());
			pstmt.setString(6, c.getGender());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int setUpdate(Connection conn,Customer c) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String qurey = "update customer set addr = ? where user_id = ?";
		try {
			pstmt = conn.prepareStatement(qurey);
			pstmt.setString(1, c.getAddr());
			pstmt.setString(2, c.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int setDelete(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "delete from customer where user_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
