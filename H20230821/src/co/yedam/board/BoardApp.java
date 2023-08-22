package co.yedam.board;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

//board기능 구현
public class BoardApp {
	Scanner sc = new Scanner(System.in);
	BoardService service = new BoardServiceJdbc();
	UserService uservice = new UserServiceImpl();
	User user = null;
	public void start() {
		System.out.println();
		System.out.println("=====LOGIN=====");
		try {
			uservice.readFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean log = true;
		while(log) {
			user = uservice.checkLogin();
			if (user != null) {
				System.out.println("환영합니다!");
				break;
			}
			else {
				System.out.println("로그인 오류");
			}
			
		}
		boolean run = true;
		
		while(run) {
			System.out.println();
			System.out.println("=======================================");
			System.out.println("1.글등록 2.목록 3.수정 4.삭제 5.상세조회 9.종료");
			System.out.println("=======================================");
			System.out.print("선택>> ");
			
			int menu = sc.nextInt(); 
			sc.nextLine();
			
			switch(menu) {
			case 1:
				register();
				break;
			case 2:
				boardList();
				break;
			case 3:
				modify();
				break;
			case 4:
				delete();
				break;
			case 5:
				search();
				break;
			case 9:
				System.out.println("시스텀 종료");
				service.save();
				run = false;
			}
		}
	}
	
	public void register() {
		String title = printString("제목");
		String  content= printString("내용");
		sc.nextLine();
//		String writer = printString("작성자");
		Board board = new Board(title, content, user.name);
		
		if(service.add(board)) {
			System.out.println("등록 성공");
		}
		else System.out.println("등록 실패");
	}
	
	public void boardList() {
		int page = 1;
		while(true) {			
			List<Board> list= service.list(page);
			for(int i=0; i<list.size(); i++) {
//				System.out.println((5*(page-1))+i+1+") "+list.get(i).listInfo()); //impl
				System.out.println(list.get(i).getBrdNo()+") "+list.get(i).listInfo()); //jdbc
			}
			int totalCnt = service.total();
			System.out.print("\t");
			for(int i=1; i<=totalCnt; i++) {
				if(i==page) System.out.print(" ["+i+"]");
				else System.out.print(" "+i);
			}
//			System.out.printf("\t[%d/%dpage]\n",page, totalCnt);
			System.out.println();
			System.out.println();
			System.out.print("조회할 페이지 (-1은 종료)>> ");
			page = sc.nextInt();
			if(page == -1) break;
		}
	}
	
	public void modify() {
		String brdNo = printString("수정할 번호");
		String content = printString("내용");
		Board brd = new Board();
		brd.setBrdNo(Integer.parseInt(brdNo));
		brd.setBrdContent(content);
		if(service.modify(brd)) {
			System.out.println("수정 성공");
		}
		else System.out.println("수정 실패");
	}
	
	public void delete() {
		String brdNo = printString("번호");
		if(service.remove(Integer.parseInt(brdNo))) System.out.println("삭제 성공");
		else System.out.println("삭제 실패");
	}
	
	public void search() {
		String brdNo = printString("번호");
		Board result = service.search(Integer.parseInt(brdNo));
		System.out.println(result.showInfo());
	}
	
	public String printString(String str) {
		System.out.print(str+" 입력>> ");
		return sc.next();
		}
	}

