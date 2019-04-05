package library.service;

import java.sql.Connection;
import java.util.ArrayList;

import library.common.JDBCTemplate;
import library.model.dao.CustmDao;
import library.model.vo.Customer;

public class CustmService {
	public ArrayList<Customer> printCustmList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Customer> list = new CustmDao().setCustmList(conn);
		JDBCTemplate.close(conn);
		return list;
	}
 	
	public ArrayList<Customer> printCustmByName(String name) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Customer> list = new CustmDao().setCustmoerByName(conn,name);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public Customer printCustmById(String id) {
		Connection conn = JDBCTemplate.getConnection();
		Customer c = new CustmDao().setCustomerById(conn,id);
		JDBCTemplate.close(conn);
		return c;
	}
	
	public int insertCustm(Customer c) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new CustmDao().setInsert(conn, c);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int updateCustm(Customer c) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new CustmDao().setUpdate(conn,c);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int deleteCustm(int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new CustmDao().setDelete(conn,userNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
