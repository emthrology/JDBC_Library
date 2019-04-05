package library.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.common.JDBCTemplate;
import library.model.vo.Lease;


public class LibDao {
	public ArrayList<Lease> setLibList(Connection conn) {
		ArrayList<Lease> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT LEASE_NO,USER_ID,USER_NAME,BOOK_NAME FROM Library " + 
				"JOIN Customer USING (USER_ID) JOIN Book USING(BOOK_NO)";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<Lease>();
			while(rset.next()) {
				Lease le = new Lease();
				le.setLeaseNo(rset.getInt("lease_no"));
				le.setUserId(rset.getString("user_id"));
				le.setUserName(rset.getString("user_name"));
				le.setBookName(rset.getString("book_name"));
				list.add(le);
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

	public Lease setById(Connection conn, String id) {
		Lease le = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT LEASE_NO,USER_ID,USER_NAME,BOOK_NAME FROM Library " + 
				"JOIN Customer USING (USER_ID) JOIN Book USING(BOOK_NO) where user_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				le = new Lease();
				le.setLeaseNo(rset.getInt("lease_no"));
				le.setUserId(rset.getString("user_id"));
				le.setUserName(rset.getString("user_name"));
				le.setBookName(rset.getString("book_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return le;
	}

	public Lease setByBName(Connection conn, String bName) {
		Lease le = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT LEASE_NO,USER_ID,USER_NAME,BOOK_NAME FROM Library " + 
				"JOIN Customer USING (USER_ID) JOIN Book USING(BOOK_NO) where book_name = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bName);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				le = new Lease();
				le.setLeaseNo(rset.getInt("lease_no"));
				le.setUserId(rset.getString("user_id"));
				le.setUserName(rset.getString("user_name"));
				le.setBookName(rset.getString("book_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return le;
	}

	public int setInsert(Connection conn, Lease le) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		//1,lease_no  2,book_no   3,user_id
		String query = "INSERT INTO LIBRARY VALUES"
				+ "(?,(SELECT BOOK_NO FROM BOOK WHERE BOOK_NAME = ?),?,sysdate,sysdate+2)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, le.getLeaseNo());
			pstmt.setString(2, le.getBookName());
			pstmt.setString(3, le.getUserId());
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
