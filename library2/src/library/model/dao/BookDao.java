package library.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.common.JDBCTemplate;
import library.model.vo.Book;

public class BookDao {
	public ArrayList<Book> setPrtAllBook(Connection conn) {
		ArrayList<Book> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from book";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<Book>();
			while(rset.next()) {
				Book b = new Book();
				b.setBookNo(rset.getInt("book_no"));
				b.setBookName(rset.getString("book_name"));
				b.setBookWriter(rset.getString("book_writer"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setPublisher(rset.getString("publisher"));
				b.setGenre(rset.getString("genre"));
				list.add(b);
				
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

	public Book setBookByCode(Connection conn,int code) {
		Book b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from book where book_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, code);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				b = new Book();
				b.setBookNo(rset.getInt("book_no"));
				b.setBookName(rset.getString("book_name"));
				b.setBookWriter(rset.getString("book_writer"));
				b.setBookPrice(rset.getInt("book_price"));
				b.setPublisher(rset.getString("publisher"));
				b.setGenre(rset.getString("genre"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return b;
	}
	
	public int setInsert(Connection conn, Book b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into book values (?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b.getBookNo());
			pstmt.setString(2, b.getBookName());
			pstmt.setString(3, b.getBookWriter());
			pstmt.setInt(4, b.getBookPrice());
			pstmt.setString(5, b.getPublisher());
			pstmt.setString(6, b.getGenre());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int setDelete(Connection conn, int code) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "delete from book where book_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, code);
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
