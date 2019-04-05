package library.view;

import java.util.ArrayList;
import java.util.Scanner;

import library.controller.BookController;
import library.controller.CustmController;
import library.controller.LibController;
import library.model.vo.Book;
import library.model.vo.Customer;
import library.model.vo.Lease;
import library.model.vo.Library;

public class LibraryMenu {
	Scanner sc = new Scanner(System.in);
	public void main() {
		while(true) {
			System.out.println("\n======도서관 프로그램======\n");
			System.out.println("1.책관리");
			System.out.println("2.회원관리");
			System.out.println("3.대여관리");
			System.out.println("0.종료");
			System.out.print("선택 > ");
			int sel = sc.nextInt();
			
			switch(sel) {
			case 1:subBook(); break;
			case 2:subCustm(); break;
			case 3:subLib(); break;
			case 0:System.out.println("프로그램 종료"); return;
			}
		}//while ends
		
	}//method main ends
	
	
	/*
	 * 컨트롤러용 메소드들
	 */
	public void printMsg(String msg) {
		System.out.println(msg);
	}
	
	public void printBook(Book b) {
		System.out.println(b);
	}
	
	public void printCustm(Customer c) {
		System.out.println(c);
	}

	public void printLib(Library l) {
		System.out.println(l);
	}
	
	public void printLes(Lease le) {
		System.out.println(le);
	}
	//컨트롤러용 메소드 끝
	
	/*
	 * 서브메뉴 book
	 */
	public void subBook() {
		BookController bc = new BookController();
		while(true) {
			System.out.println("\n===책관리 서브메뉴===\n");
			System.out.println("1.전체 책 조회");
			System.out.println("2.책 코드로 조회");
			System.out.println("3.책 추가하기");
			System.out.println("4.책 삭제하기");
			System.out.println("5.메인메뉴로 이동");
			System.out.print("선택 > ");
			int sel = sc.nextInt();
			
			switch(sel) {
			case 1:bc.prtAllBookCtrl(); break;
			case 2:bc.prtBookByCodeCtrl(bookPress2()); break;
			case 3:bc.insertBookCtrl(bookPress3()); break;
			case 4:bc.deleteBookCtrl(bookPress4()); break;
			
			case 5:return;	
			}
		}//while ends
	}//method subBook ends
	
	public void prtBookList(ArrayList<Book> list) {
		System.out.println("\n==소장 도서 목록==\n");
		for(Book b : list) {
			System.out.println(b);
		}
	}
	
	public int bookPress2() {
		System.out.println("\n==책 코드로 도서 검색==\n");
		System.out.print("검색할 책의 코드를 입력하세요 : ");
		int code = sc.nextInt();
		return code;
	}
	
	public Book bookPress3() {
		System.out.println("\n==책 추가하기==\n");
		System.out.print("책 코드 입력 : ");
		int code = sc.nextInt();
		System.out.print("책 제목 입력 : ");
		sc.nextLine();
		String bName = sc.nextLine();
		System.out.print("작가 입력 : ");
		String author = sc.nextLine();
		System.out.print("책 가격 입력 : ");
		int price = sc.nextInt();
		System.out.print("출판사 입력 : ");
		String publisher = sc.next();
		System.out.print("장르 입력 : ");
		String genre = sc.next();
		Book b = new Book(code, bName, author, price, publisher, genre);
		return b;
	}
	
	public int bookPress4() {
		System.out.println("\n==책 삭제하기==\n");
		System.out.print("삭제할 책 코드 입력 : ");
		int code = sc.nextInt();
		return code;
	}

	
	/*
	 * 서브메뉴 Customer
	 */
	public void subCustm() {
		CustmController cc = new CustmController();
		while(true) {
			System.out.println("\n===회원관리 서브메뉴===\n");
			System.out.println("1.회원 전체 조회");
			System.out.println("2.회원 이름으로 조회");
			System.out.println("3.회원 아이디로 조회");
			System.out.println("4.회원 가입");
			System.out.println("5.회원 정보 수정");
			System.out.println("6.회원 탈퇴");
			System.out.println("7.메인메뉴로 이동");
			System.out.print("선택 > ");
			int sel = sc.nextInt();
			
			switch(sel) {
			case 1:cc.printCustmListCtrl(); break;
			case 2:cc.printCustmByNameCtrl(custmPress2()); break;
			case 3:cc.printCustmByIdCtrl(custmPress3()); break;
			case 4:cc.insertCustmCtrl(custmPress4()); break;
			case 5:cc.updateCustmCtrl(custmPress5()); break;
			case 6:cc.deleteCustmCtrl(custmPress6()); break;
			case 7:return;	
			}
		}//while ends
		
	}//method subCustm ends
	
	public void prtCustmList(ArrayList<Customer> list) {
		System.out.println("\n==도서관 회원 목록==\n");
		for(Customer c : list) {
			System.out.println(c);
		}
	}
	
	public String custmPress2() {
		System.out.println("\n==회원 이름으로 조회==\n");
		System.out.print("회원 이름(일부분 가능) 입력 : ");
		String name =sc.next();
		return name;
	}
	
	public String custmPress3() {
		System.out.println("\n==회원 아이디로 조회==\n");
		System.out.print("회원 아이디 입력 : ");
		String id =sc.next();
		return id;
	}
	
	public Customer custmPress4() {
		System.out.println("\n==회원 추가==\n");
		System.out.print("고객번호 입력 : ");
		int userNo = sc.nextInt();
		System.out.print("고객아이디 입력 : ");
		String userId = sc.next();
		System.out.print("이름 입력 : ");
		sc.nextLine();
		String userName = sc.nextLine();
		System.out.print("나이 입력 : ");
		int userAge = sc.nextInt();
		System.out.print("주소 입력 : ");
		sc.nextLine();
		String addr = sc.nextLine();
		System.out.print("성별 입력(M,F) : ");
		String gender = sc.next();
		Customer c = new Customer(userNo, userId, userName, userAge, addr, gender, null);
		return c;
	}
	
	public Customer custmPress5() {
		System.out.println("\n==회원 정보 수정==\n");
		System.out.print("정보수정할 고객 아이디 입력 : ");
		String userId = sc.next();
		System.out.print("새로운 주소 입력 : ");
		sc.nextLine();
		String addr = sc.nextLine();
		Customer c = new Customer(0, userId, null, 0, addr, null, null);
		return c;
	}
	
	public int custmPress6() {
		System.out.println("\n==회원 삭제==\n");
		System.out.print("삭제할 고객 번호 입력 : ");
		int userNo = sc.nextInt();
		return userNo;
	}

	
	/*
	 * 서브메뉴 Library
	 */
	public void subLib() {
		LibController lc = new LibController();
		while(true) {
			System.out.println("\n===대여관리 서브메뉴===\n");
			System.out.println("1.대여 관리 전체 조회");
			System.out.println("2.회원 아이디로 대여 조회");
			System.out.println("3.책 이름으로 대여 조회");
			System.out.println("4.대여정보 추가");
			System.out.println("5.메인메뉴로 이동");
			System.out.print("선택 > ");
			int sel = sc.nextInt();
			
			
			switch(sel) {
			case 1:lc.printAllLibCtrl(); break;
			case 2:lc.printLibByIdCtrl(press2()); break;
			case 3:lc.prtLibByBNameCtrl(press3()); break;
			case 4:lc.insertLibCtrl(press4()); break;
			case 5:return;	
			}
		}//while ends
		
	}//method subLib ends
	
	public void prtlibList(ArrayList<Lease> list) {
		System.out.println("\n==전체 대여 목록==\n");
		for(Lease le : list) {
			System.out.println(le);
		}
	}
	
	public String press2() {
		System.out.println("\n==회원 아이디로 대여 조회==\n");
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		return id;
	}
	
	public String press3() {
		System.out.println("\n==책 이름으로 대여 조회==\n");
		System.out.print("책 이름 입력 : ");
		sc.nextLine();
		String bName = sc.nextLine();
		return bName;
	}
//	대여정보 추가시
//	- 대여번호,회원아이디,책이름 을 입력시 DB에서 해당 책 이름에 따른
//	정보를 가지고 책번호를 가져와서 DB에 넣어져야 함
//	(책 번호를 직접 프로그램 사용자가 넣어주면 안됨)
	
	public Lease press4() {
		System.out.println("\n==대여정보 추가==\n");
		System.out.print("대여번호 입력 : ");
		int leaseNo = sc.nextInt();
		System.out.print("회원아이디 입력 : ");
		String userId = sc.next();
		System.out.print("책이름 입력 : ");
		sc.nextLine();
		String bookName = sc.nextLine();
		Lease le = new Lease(leaseNo, userId, null, bookName);
		return le;
	}
	
}
