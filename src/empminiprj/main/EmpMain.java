package empminiprj.main;

import empminiprj.console.EmpConsole;

public class EmpMain {

	public static void main(String[] args) {
		EmpConsole console = new EmpConsole();
		boolean run = true;
		
		while(run) {
			console.printEmpList();
			int menu = console.inputEmpMenu();
			switch (menu) {
			case 1://이전페이지
				
				break;
			case 2://다음페이지
				
				break;
			case 3://등록
				
				break;
			case 4://종료
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
				System.out.println("잘못된 선택입니다.(1~4 선택)");
				break;
			}
		}
	}
}
