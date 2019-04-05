package library.model.vo;

public class Lease {
	// 대여관리에서는 조회시 
	//- 대여번호(library),회원아이디(customer),회원이름(customer),책이름(book) 이 나와야 함 (북 번호가 아님)
	private int leaseNo;
	private String userId;
	private String userName;
	private String bookName;
	
	public Lease() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lease(int leaseNo, String userId, String userName, String bookName) {
		super();
		this.leaseNo = leaseNo;
		this.userId = userId;
		this.userName = userName;
		this.bookName = bookName;
	}
	
	public int getLeaseNo() {
		return leaseNo;
	}
	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setLeaseNo(int leaseNo) {
		this.leaseNo = leaseNo;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	@Override
	public String toString() {
		return leaseNo +"\t"+ userId +"\t"+ userName +"\t"+ bookName;
	}
	
	

	

	
	
	
	
}
