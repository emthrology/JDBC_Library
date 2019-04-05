package library.controller;

import java.util.ArrayList;

import library.model.vo.Book;
import library.service.BookService;
import library.view.LibraryMenu;

public class BookController {
	public void prtAllBookCtrl() {
		LibraryMenu lm = new LibraryMenu();
		ArrayList<Book> list = new BookService().prtAllBook();
		if(!list.isEmpty()) {
			lm.prtBookList(list);
		}else {
			lm.printMsg("현재 소장 도서 없음");
		}
	}
	
	public void prtBookByCodeCtrl(int code) {
		LibraryMenu lm = new LibraryMenu();
		Book b = new BookService().prtBookByCode(code);
		if(b != null) {
			lm.printBook(b);
		}else {
			lm.printMsg("검색하신 도서가 없음");
		}
		
	}
	
	public void insertBookCtrl(Book b) {
		LibraryMenu lm = new LibraryMenu();
		int result = new BookService().insertBook(b);
		if(result>0) {
			lm.printMsg("입력 성공");
		}else {
			lm.printMsg("입력 실패");
		}
	}
	
	public void deleteBookCtrl(int code) {
		LibraryMenu lm = new LibraryMenu();
		int result = new BookService().deleteBook(code);
		if(result>0) {
			lm.printMsg("삭제 성공");
		}else {
			lm.printMsg("삭제 실패");
		}
	}
}
