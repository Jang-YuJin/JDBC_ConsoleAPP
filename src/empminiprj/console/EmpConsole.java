package empminiprj.console;

import java.util.List;
import java.util.Scanner;

import empminiprj.model.EmpDTO;
import empminiprj.service.EmpDAO;

public class EmpConsole {
	EmpDAO empDAO;
	
	public EmpConsole() {
		empDAO = new EmpDAO();
	}

	public void printEmpList() {
		List<EmpDTO> list = empDAO.getList(1);
		System.out.println("<사원 목록> 총 " + 1 + "명");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("empno\tename\tjob\tmgr\thiredate\tsal\tcomm\tdeptno");
		System.out.println("----------------------------------------------------------------------");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getEmpno() + "\t" + list.get(i).getEname() + "\t" + list.get(i).getJob() + "\t" + list.get(i).getMgr() + "\t" + list.get(i).getHiredate() + "\t" + list.get(i).getSal() + "\t" + list.get(i).getComm() + "\t" + list.get(i).getDeptno());
		}
		System.out.println("----------------------------------------------------------------------");
		System.out.println("페이지");
	}

	public int inputEmpMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 이전페이지 | 2. 다음페이지 | 3. 등록 | 4. 종료");
		System.out.print(">");
		int menu = sc.nextInt();
		sc.nextLine();
		return menu;
	}

}
