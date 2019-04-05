package library.model.vo;

import java.sql.Date;

public class Library {
	private int leaseNo;
	private int bookNo;
	private String userId;
	private Date leaseDate;
	private Date returnDate;
	
	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Library(int leaseNo, int bookNo, String userId, Date leaseDate, Date returnDate) {
		super();
		this.leaseNo = leaseNo;
		this.bookNo = bookNo;
		this.userId = userId;
		this.leaseDate = leaseDate;
		this.returnDate = returnDate;
	}

	public int getLeaseNo() {
		return leaseNo;
	}

	public int getBookNo() {
		return bookNo;
	}

	public String getUserId() {
		return userId;
	}

	public Date getLeaseDate() {
		return leaseDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setLeaseNo(int leaseNo) {
		this.leaseNo = leaseNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setLeaseDate(Date leaseDate) {
		this.leaseDate = leaseDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return leaseNo +"\t"+ bookNo +"\t"+ userId +"\t"+ leaseDate +"\t"+ returnDate;
	}
	
	
}
