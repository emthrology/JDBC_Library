package library.controller;

import java.util.ArrayList;

import library.model.vo.Lease;
import library.service.LibService;
import library.view.LibraryMenu;

public class LibController {
	public void printAllLibCtrl() {
		LibraryMenu lm = new LibraryMenu();
		ArrayList<Lease> list = new LibService().printAllLib();
		if(!list.isEmpty()) {
			lm.prtlibList(list);
		}else {
			lm.printMsg("현재 대여중인 도서 없음");
		}
	}	
	
	public void printLibByIdCtrl(String id) {
		LibraryMenu lm = new LibraryMenu();
		Lease le = new LibService().printLibById(id);
		if(le != null) {
			lm.printLes(le);
		}else {
			lm.printMsg("조건에 맞는 회원 없음");
		}
	} 
	
	public void prtLibByBNameCtrl(String bName) {
		LibraryMenu lm = new LibraryMenu();
		Lease le = new LibService().prtLibByBName(bName);
		if(le != null) {
			lm.printLes(le);
		}else {
			lm.printMsg("책이 대여중이지 않습니다");
		}
	}
	
	public void insertLibCtrl(Lease le) {
		LibraryMenu lm = new LibraryMenu();
		int result = new LibService().insertLib(le);
		if(result>0) {
			lm.printMsg("입력 성공");
		}else {
			lm.printMsg("입력 실패");
		}
	}
}
