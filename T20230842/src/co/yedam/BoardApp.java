package co.yedam;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class BoardApp {
	Scanner sc = new Scanner(System.in);
	
	//board를 저장해놓을 list 선언
	List<Board> boards = new ArrayList<>();
	
	public BoardApp() {
		//boardApp이 생성되는 동시에 readFile함수를 실행하여 데이터 불러옴
		boards = readFile();
	}
	
	public void start() {
		boolean run = true;
		
		while(run) {
			//메뉴바 출력
			System.out.println();
			System.out.println("============================================");
			System.out.println("1.추가   2.수정   3.조회   4.삭제   5.목록   6.종료");
			System.out.println("============================================");
			int menu = Integer.parseInt(printString("선택"));
			
			switch(menu) {
			case 1:
				//등록
				register();
				break;
			case 2:
				//수정
				modify();
				break;
			case 3:
				//조회
				search();
				break;
			case 4:
				//삭제
				remove();
				break;
			case 5:
				//목록조회
				list();
				break;
			case 6:
				//종료 전 게시물을 파일에 출력
				saveFile(boards);
				run = false;
			}
		}
		System.out.println("프로그램이 종료되었습니다.");
		
		
	}
	
	//등록
	public void register() {
		String title = printString("제목");
		String content = printString("내용");
		String writer = printString("작성자");
		Date today = new Date(); //현재 시간 및 날짜
		Board brd = new Board( title, content, writer, today); //Board객체 생성
		boards.add(brd); //boards리스트에 추가함
		brd.setBrdNo(boards.indexOf(brd)+1); //글번호는 삭제 시 번호를 앞으로 당기기위해 인덱스 이용
		//인덱스는 0부터 시작하기 때문에 글번호는 인덱스 + 1
		System.out.println("["+title+"] 글이 등록되었습니다.");
	}
	
	//수정
	public void modify() {
		boolean ck = false;
		int brdnum = Integer.parseInt(printString("수정할 게시글 번호"));
		for(Board b : boards) {
			if(brdnum == b.getBrdNo()) {
				//입력한 번호와 boards리스트의 객체들의 글번호를 비교
				b.setBrdContent(printString("수정할 내용"));
				System.out.println(brdnum+"번 글이 수정되었습니다.");
				ck = true; break;
			}
		}
		if(ck == false) System.out.println("없는 번호입니다.");
		//같은 번호가 없으면 사용자에게 알림
	}
	
	//조회
	public void search() {
		boolean ck = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		//날짜를 깔끔하게 출력하기 위해 simpledateformat 이용
		int brdnum = Integer.parseInt(printString("조회할 게시글 번호"));
		//게시글 번호, 제목
		//내용
		//작성일, 작성자
		for(Board b : boards) {
			if(brdnum == b.getBrdNo()) {
				System.out.println();
				System.out.println("["+b.getBrdNo()+"번 게시글]  제목: "+b.getBrdTitle());
				System.out.println("내용: "+b.getBrdContent());
				System.out.println("작성일: "+sdf.format(b.getBrdDate())+"\t작성자: "+b.getBrdWriter());
				ck = true; break; 
			}
		}
		if(ck == false) System.out.println("없는 번호입니다.");
		//같은 번호가 없으면 사용자에게 알림
	}
	
	public void remove() {
		boolean ck = false;
		int brdnum = Integer.parseInt(printString("삭제할 게시글 번호"));
		for(Board b : boards) {
			if(brdnum == b.getBrdNo()) {
				boards.remove(b);
				System.out.println("삭제되었습니다.");
				//해당하는 게시글 삭제
				//삭제글 인덱스부터 게시글번호를 재설정해줌
				//arraylist는 인덱스가 자동으로 당겨지기 때문에 현재의 인덱스+1로 게시글번호 설정
				for(int i=brdnum-1; i<boards.size(); i++) {
					Board brd = boards.get(i);
					brd.setBrdNo(boards.indexOf(brd)+1);
				}
				ck = true; break;
			}
		}
		if(ck == false) System.out.println("없는 번호입니다.");
		//같은 번호가 없으면 사용자에게 알림
	}
	
	//목록
	public void list() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		//제목, 작성자, 작성일만 출력
		for(Board b : boards) {
			System.out.println(b.getBrdNo()+") 제목: "+b.getBrdTitle()+" \t작성자: "+b.getBrdWriter()+" \t작성일: "+sdf.format(b.getBrdDate()));
		}
	}
	
	
	//scanner로 입력받아 String으로 반환
	public String printString(String str) {
		System.out.print(str+">> ");
		return sc.nextLine();
	}
	
	
	//파일을 읽어 board객체 arraylist로 반환
	public ArrayList<Board> readFile() {
		File file = new File("C:/Temp/boardList.dat");
		List<Board> list = new ArrayList<>(); //파일에서 읽어온 데이터들을 저장할 리스트
		if(!file.exists()) {
			//파일이 존재하지 않으면 생성함
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			FileInputStream fis = new FileInputStream(file); //파일 입력 스트림
			ObjectInputStream ois = new ObjectInputStream(fis); //객체 입력 보조 스트림
			list = (List<Board>) ois.readObject(); //객체 입력 보조 스트림이 읽어온 데이터들을 list<Board>로 형변환하여 list에 저장
		} catch (Exception e) {
			return (ArrayList<Board>) list; //list 반환
		}
		return (ArrayList<Board>) list; 
	}
	
	
	//board객체 arraylist를 지정된 파일에 출력
	public void saveFile(List<Board> boards2) {
		File file = new File("C:/Temp/boardList.dat");
		if(!file.exists()) {
			//파일이 존재하지 않으면 생성
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			FileOutputStream fos = new FileOutputStream(file); //파일 출력 스트림
			ObjectOutputStream oos = new ObjectOutputStream(fos); //객체 출력 보조 스트림
			oos.writeObject(boards2); //파라미터로 들어온 boards2 리스트를 oos가 지정된 파일에 출력
			oos.flush();
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

