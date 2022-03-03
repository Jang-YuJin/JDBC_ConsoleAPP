package empminiprj.console;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import empminiprj.model.EmpDTO;
import empminiprj.service.EmpDAO;

public class EmpConsole {
	EmpDAO empDAO;
	private int page;//현재 페이지
	private String search;
	private String searchCol;
	
	public EmpConsole() {
		empDAO = new EmpDAO();
		page = 1;//2
		search = "";//30
		searchCol = "";//deptno
	}

	public void printEmpList() {
		List<EmpDTO> list = empDAO.getList(page, searchCol, search);
		int cnt = empDAO.getCount();//게시글 개수
		int lastPage = cnt % 5 == 0 ? cnt / 5 : cnt / 5 + 1;//마지막 페이지
		System.out.println("<사원 목록> 총 " + cnt + "명");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("empno\tename\tjob\tmgr\thiredate\tsal\tcomm\tdeptno");
		System.out.println("----------------------------------------------------------------------");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getEmpno() + "\t" + list.get(i).getEname() + "\t" + list.get(i).getJob() + "\t" + list.get(i).getMgr() + "\t" + list.get(i).getHiredate() + "\t" + list.get(i).getSal() + "\t" + list.get(i).getComm() + "\t" + list.get(i).getDeptno());
		}
		System.out.println("----------------------------------------------------------------------");
		System.out.println(page + "/" + lastPage);
	}

	public int inputEmpMenu() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 조회 | 2. 이전페이지 | 3. 다음페이지 | 4. 등록 | 5. 삭제 | 6. 검색 | 7. 종료");
		System.out.print(">");
		int menu = sc.nextInt();
		sc.nextLine();
		return menu;
	}

	public void movePrePage() {
		if(page == 1) {
			System.out.println("***** 이전페이지가 없습니다. *****");
			return;
		}
		page--;
		
	}

	public void moveNextPage() {
		List<EmpDTO> list = empDAO.getList(page, searchCol, search);
		int cnt = empDAO.getCount();//게시글 개수
		int lastPage = cnt % 5 == 0 ? cnt / 5 : cnt / 5 + 1;//마지막 페이지
		if (page == lastPage) {
			System.out.println("***** 다음페이지가 없습니다. *****");
			return;
		}
		page++;
	}

	public void searchEmp() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 컬럼> ");
		searchCol = sc.nextLine();
		System.out.print("검색어> ");
		search = sc.nextLine();
	}

	public void printAll() {
		page = 1;
		search = "";
		searchCol = "";
		printEmpList();
	}

	public void registerEmp() {
		EmpDTO empDTO = new EmpDTO();
		Scanner sc = new Scanner(System.in);
		System.out.print("등록할 empno> ");
		empDTO.setEmpno(sc.nextInt());
		sc.nextLine();
		System.out.print("등록할 ename> ");
		empDTO.setEname(sc.nextLine());
		System.out.print("등록할 job> ");
		empDTO.setJob(sc.nextLine());
		System.out.print("등록할 mgr> ");
		empDTO.setMgr(sc.nextInt());
		sc.nextLine();
		System.out.print("등록할 hiredate> ");
		empDTO.setHiredate(Date.valueOf(sc.nextLine()));
		System.out.print("등록할 sal> ");
		empDTO.setSal(sc.nextInt());
		sc.nextLine();
		System.out.print("등록할 comm> ");
		empDTO.setComm(sc.nextInt());
		sc.nextLine();
		System.out.print("등록할 deptno> ");
		empDTO.setDeptno(sc.nextInt());
		sc.nextLine();
		empDAO.insert(empDTO);
	}

	public void deleteEmp() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 empno> ");
		int empno = sc.nextInt();
		sc.nextLine();
		empDAO.delete(empno);
		
	}

}
