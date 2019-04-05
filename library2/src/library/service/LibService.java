package library.service;

import java.sql.Connection;
import java.util.ArrayList;

import library.common.JDBCTemplate;
import library.model.dao.LibDao;
import library.model.vo.Lease;

public class LibService {
	public ArrayList<Lease> printAllLib() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Lease> list = new LibDao().setLibList(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public Lease printLibById(String id) {
		Connection conn = JDBCTemplate.getConnection();
		Lease le = new LibDao().setById(conn, id);
		JDBCTemplate.close(conn);
		return le;
	}
	
	public Lease prtLibByBName(String bName) {
		Connection conn = JDBCTemplate.getConnection();
		Lease le = new LibDao().setByBName(conn, bName);
		JDBCTemplate.close(conn);
		return le;
	}
	
	public int insertLib(Lease le) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new LibDao().setInsert(conn, le);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}	
