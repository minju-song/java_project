package co.yedam.board;
import java.util.*;

public class BoardApp {
	Scanner sc = new Scanner(System.in);
	private Board arr[] = new Board[10];
	int idx=0;
	
	void start() {
		boolean run = true;
		while(run) {
			System.out.println("------------------------------------------------");
			System.out.println("| 1.등록 | 2.목록 | 3.상세보기 | 4.수정 | 5.삭제 | 6.종료 |");
			System.out.println("------------------------------------------------");
			System.out.print("선택>> ");
			int sel = sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1:
				add();
				break;
			case 2:
				list();
				break;
			case 3:
				search();
				break;
			case 4:
				modify();
				break;
			case 5:
				delete();
				break;
			}
			
		}
		
		
	}
	
	void add() {
		arr[idx] = new Board();
		arr[idx].setNo(idx+1);
		System.out.print("제목>> ");
		arr[idx].setTitle(sc.nextLine());
		System.out.print("글 내용>> ");
		arr[idx].setContent(sc.nextLine());
		System.out.print("작성자>> ");
		arr[idx].setAuthor(sc.nextLine());
		System.out.println(arr[idx].getAuthor()+"님의 글이 등록되었습니다.");
		idx++;
	}
	
	void list() {
		System.out.println("글번호\t제목\t\t작성자");
		for(int i=0; i<arr.length; i++) {
			if(arr[i]!=null) {
				System.out.println(arr[i].getNo()+"\t\t"+arr[i].getTitle()+"\t\t"+arr[i].getAuthor());
			}
		}
	}
	
	void search() {
		System.out.print("글번호>> ");
		int sel = sc.nextInt();
		sc.nextLine();
		if(arr[sel-1] != null) {			
			System.out.println("글번호: "+arr[sel-1].getNo()+"\t\t작성자: "+arr[sel-1].getAuthor());
			System.out.println("글내용: "+arr[sel-1].getContent());
		}
		else System.out.println("없는 글입니다.");
	}
	
	void modify() {
		System.out.print("글번호>> ");
		int sel = sc.nextInt();
		sc.nextLine();
		if(arr[sel-1] != null) {			
			System.out.print("변경할 제목>> ");
			arr[sel-1].setTitle(sc.nextLine());
			System.out.print("변경할 내용>> ");
			arr[sel-1].setContent(sc.nextLine());
			System.out.println(arr[sel-1].getTitle()+"글이 수정되었습니다.");
		}
		else System.out.println("없는 글입니다.");
	}
	
	void delete() {
		System.out.print("삭제할 글번호>> ");
		int sel = sc.nextInt();
		sc.nextLine();
		if(arr[sel-1]!=null) {
			arr[sel-1] = null;
		}
		int len = arr.length-1;
//		for(int i=0; i<len; i++) {
//			for(int j=0; j<len; j++) {
//				if(arr[j]!=null && arr[j+1]!= null && arr[j])
//			}
//		}
		
		System.out.println(sel+"번 글이 삭제되었습니다.");
	}
	
}
