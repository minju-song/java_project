package co.yedam.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.*;
import java.util.*;

public class FriendApp {
	static Scanner sc = new Scanner(System.in);
	List<Friend> friends = new ArrayList<>();
	
	public FriendApp() {
		loadFile();
	}
	
	public void start() {
		boolean run = true; 
		while(run) {			
			System.out.println("♥♥♥1.등록 2.목록 출력 3.종료♥♥♥");
			System.out.println("번호를 선택하세요");
			System.out.print(">> ");
			int menu = sc.nextInt(); 
			sc.nextLine();
			if(menu==1) {
				add();
			} else if(menu==2) {
				list();
			}else if (menu==3) {
				System.out.println("종료합니다.");
				saveFile();
				run = false;
			}
		}
	} // end of start
	
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
	private void add() {
		String name = printString("이름");
		String phone = printString("연락처");
		String birth = printString("생일(YY-MM-DD)");
		try {
			Friend fnd = new Friend(name, phone, sdf.parse(birth));
			friends.add(fnd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void list() {
		for(Friend fnd:friends) {
			System.out.println(fnd.toString());
		}
	}
	
	private void saveFile() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//friends 컬랙션에 값 -> 텍스트 저장
		try {
			FileWriter fw = new FileWriter("C:/Temp/friendList.txt");
			for(Friend fnd : friends) {
				String line = fnd.getName()+" "+fnd.getPhone()+" "+sdf.format(fnd.getBirth());
				fw.write(line+"\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadFile() {
		File file = new File("C:/Temp/friendList.txt");
		try {
			Scanner scn = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
//		boolean run = true;
		while(true) {
			String line = sc.nextLine();
			if(line.equals(null)) break;
			String data[] = line.split(" ");
			for(Friend fnd : friends) {
				fnd.setName(data[0]);
				fnd.setPhone(data[1]);
				Date birth = new Date();
				try {
					birth = sdf.parse(data[2]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fnd.setBirth(birth);
			}
		}
	}
	
	public String printString(String str) {
		System.out.print(str+" 입력>> ");
		return sc.next();
	}
}
