package empminiprj.main;

import empminiprj.console.EmpConsole;

public class EmpMain {

	public static void main(String[] args) {
		EmpConsole console = new EmpConsole();
		boolean run = true;
		
		while(run) {
			console.printEmpList();
			int menu = console.inputEmpMenu();
			System.out.println();
			switch (menu) {
			case 1://전체조회
				console.printAll();
				break;
			case 2://이전페이지
				console.movePrePage();
				break;
			case 3://다음페이지
				console.moveNextPage();
				break;
			case 4://등록
				console.registerEmp();
				break;
			case 5://삭제
				console.deleteEmp();
				break;
			case 6://검색
				console.searchEmp();
				break;
			case 7://종료
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
				System.out.println("잘못된 선택입니다.(1~6 선택)");
				break;
			}
		}
	}
}
