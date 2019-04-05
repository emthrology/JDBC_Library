package library.model.vo;

public class Book {
	private int bookNo;
	private String bookName;
	private String bookWriter;
	private int bookPrice;
	private String publisher;
	private String genre;
	
	public Book() {
		super();
		
	}

	public Book(int bookNo, String bookName, String bookWriter, int bookPrice, String publisher, String genre) {
		super();
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.bookPrice = bookPrice;
		this.publisher = publisher;
		this.genre = genre;
	}

	public int getBookNo() {
		return bookNo;
	}

	public String getBookName() {
		return bookName;
	}
	
	public String getBookWriter() {
		return bookWriter;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return bookNo +"\t"+ bookName +"\t"+ bookWriter +"\t"+ bookPrice +"\t"+ publisher +"\t"+ genre;
	}
	
	
}
