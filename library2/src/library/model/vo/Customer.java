package library.model.vo;

import java.sql.Date;

public class Customer {
	private int userNo;
	private String userId;
	private String userName;
	private int userAge;
	private String addr;
	private String gender;
	private Date enrollDate;
	
	public Customer() {
		super();
		
	}

	public Customer(int userNo, String userId, String userName, int userAge, String addr, String gender, Date enrollDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
		this.addr = addr;
		this.gender = gender;
		this.enrollDate = enrollDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public String getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public String getAddr() {
		return addr;
	}

	public String getGender() {
		return gender;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return userNo +"\t"+ userId +"\t"+ userName +"\t"+ userAge +"\t"+ addr +"\t"+ gender +"\t"+ enrollDate;
	}
	
	
}
