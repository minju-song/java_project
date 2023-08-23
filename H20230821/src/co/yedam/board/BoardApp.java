package co.yedam.board;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

//board기능 구현
public class BoardApp {
	Scanner sc = new Scanner(System.in);
	BoardService service = new BoardServiceJdbc();
	UserService uservice = new UserServiceJdbc();
//	ReplyService rservice = new ReplyServiceJdbc();
	User user = null;

	public void start() {
		System.out.println();
		System.out.println("=====LOGIN=====");
		try {
//			uservice.readFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean log = true;
		while (log) {
			String id = printString("아이디");
			String pw = printString("비밀번호");
			user = uservice.checkLogin(id, pw);
			if (user != null) {
				System.out.println("환영합니다!");
				break;
			} else {
				System.out.println("로그인 오류");
			}

		}
		boolean run = true;

		while (run) {
			System.out.println();
			System.out.println("=======================================");
			System.out.println("1.글등록 2.목록 3.수정 4.삭제 5.상세조회 9.종료");
			System.out.println("=======================================");
			System.out.print("선택>> ");

			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
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
//				rservice.
				run = false;
			}
		}
	}

	public void register() {
		String title = printString("제목");
		sc.nextLine();
		String content = printString("내용");
		sc.nextLine();
//		String writer = printString("작성자");
		Board board = new Board(title, content, user.name);

		if (service.add(board)) {
			System.out.println("등록 성공");
		} else
			System.out.println("등록 실패");
	}

	public void boardList() {
		int page = 1;
		while (true) {
			List<Board> list = service.list(page);
			for (int i = 0; i < list.size(); i++) {
//				System.out.println((5*(page-1))+i+1+") "+list.get(i).listInfo()); //impl
				System.out.println(list.get(i).getBrdNo() + ") " + list.get(i).listInfo()); // jdbc
			}
			int totalCnt = service.total();
			System.out.print("\t");
			for (int i = 1; i <= totalCnt; i++) {
				if (i == page)
					System.out.print(" [" + i + "]");
				else
					System.out.print(" " + i);
			}
//			System.out.printf("\t[%d/%dpage]\n",page, totalCnt);
			System.out.println();
			System.out.println();
			System.out.print("조회할 페이지 (-1은 종료)>> ");
			page = sc.nextInt();
			if (page == -1)
				break;
		}
	}

	public void modify() {
		int brdNo = Integer.parseInt(printString("수정할 번호"));
		User userWriter = service.checkWriter(brdNo);
//		System.out.println(user.getId());
		if (userWriter.getId().equals(user.getId())) {
			String content = printString("내용");
			Board brd = new Board();
			brd.setBrdNo(brdNo);
			brd.setBrdContent(content);
			if (service.modify(brd)) {
				System.out.println("수정 성공");
			} else
				System.out.println("수정 실패");
		} else {
			System.out.println("수정할 권한이 없습니다.");
		}
	}

	////////////////// 삭제권한
	public void delete() {
		int brdNo = Integer.parseInt(printString("번호"));
		User userWriter = service.checkWriter(brdNo);
		if (userWriter.getId().equals(user.getId())) {
			if (service.remove(brdNo))
				System.out.println("삭제 성공");
			else
				System.out.println("삭제 실패");
		} else
			System.out.println("삭제할 권한이 없습니다.");
	}

	public void search() {
		String brdNo = printString("조회할 게시글 번호");
		int brdNo2 = Integer.parseInt(brdNo);
		Board result = service.search(brdNo2);

		ReplyApp app = new ReplyApp(brdNo2);
		System.out.println(result.showInfo());
		app.start(result, user);

//		System.out.println(result.showInfo());
//		rservice.list(brdNo2);
//		String r = printString("댓글 작성:y   삭제:n   이전:o");
//		if(r.equals("y")) {			
//			rservice.add(result, user);
//		}
//		else if (r.equals("n")) {
//			rservice.delete(user);
//		}
	}

	public String printString(String str) {
		System.out.print(str + " 입력>> ");
		return sc.next();
	}
	class ReplyApp {
		ReplyService rservice = new ReplyServiceJdbc();
		private int brdNo;
		
		ReplyApp(int brdNo) {
			this.brdNo = brdNo;
		}
		
		public void start(Board brd, User user) {
			rservice.list(brdNo);
			String r = printString("댓글 작성:y   삭제:n   이전:o");
			sc.nextLine();
			if (r.equals("y")) {
				rservice.add(brd, user);
			} else if (r.equals("n")) {
				rservice.delete(user);
			}
		}
	}
}

