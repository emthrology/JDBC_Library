package library.controller;

import java.util.ArrayList;

import library.model.vo.Customer;
import library.service.CustmService;
import library.view.LibraryMenu;

public class CustmController {
	public void printCustmListCtrl() {
		 LibraryMenu lm = new LibraryMenu();
		 ArrayList<Customer> list = new CustmService().printCustmList();
		 if(!list.isEmpty()) {
			 lm.prtCustmList(list);
		 }else {
			 lm.printMsg("현재 회원 없음");
		 }
	}
	
	public void printCustmByNameCtrl(String name) {
		LibraryMenu lm = new LibraryMenu();
		ArrayList<Customer> list = new CustmService().printCustmByName(name);
		if(!list.isEmpty()) {
			 lm.prtCustmList(list);
		 }else {
			 lm.printMsg("조건에 맞는 회원 없음");
		 }
	}
	
	public void printCustmByIdCtrl(String id) {
		LibraryMenu lm = new LibraryMenu();
		Customer c = new CustmService().printCustmById(id);
		if(c != null) {
			lm.printCustm(c);
		}else {
			lm.printMsg("조건에 맞는 회원 없음");
		}
	}
	
	public void insertCustmCtrl(Customer c) {
		LibraryMenu lm = new LibraryMenu();
		int result = new CustmService().insertCustm(c);
		if(result>0) {
			lm.printMsg("입력 성공");
		}else {
			lm.printMsg("입력 실패");
		}
	}
	
	public void updateCustmCtrl(Customer c) {
		LibraryMenu lm = new LibraryMenu();
		int result = new CustmService().updateCustm(c);
		if(result>0) {
			lm.printMsg("수정 성공");
		}else {
			lm.printMsg("수정 실패");
		}
	}
	
	public void deleteCustmCtrl(int userNo) {
		LibraryMenu lm = new LibraryMenu();
		int result = new CustmService().deleteCustm(userNo);
		if(result>0) {
			lm.printMsg("삭제 성공");
		}else {
			lm.printMsg("삭제 실패");
		}
	}
}
