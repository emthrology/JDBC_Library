package library.service;

import java.sql.Connection;
import java.util.ArrayList;

import library.common.JDBCTemplate;
import library.model.dao.BookDao;
import library.model.vo.Book;

public class BookService {
	public ArrayList<Book> prtAllBook() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Book> list = new BookDao().setPrtAllBook(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public Book prtBookByCode(int code) {
		Connection conn = JDBCTemplate.getConnection();
		Book b = new BookDao().setBookByCode(conn,code);
		JDBCTemplate.close(conn);
		return b;
	}
	
	public int insertBook(Book b) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BookDao().setInsert(conn, b);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int deleteBook(int code) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BookDao().setDelete(conn, code);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
				
	}
}
