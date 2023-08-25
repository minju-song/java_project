package co.yedam.board.service;

import java.io.*;
import java.util.*;

import co.yedam.board.vo.User;

//user의 정보를 불러와 list에 저장 후 로그인
public class UserServiceImpl implements UserService{
	List<User> list = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	
	public UserServiceImpl() {
		try {
			readFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//users.txt에서 정보를 읽고 user정보를 list컬렉션에 저장
	@Override
	public User checkLogin(String id, String pw) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				if(list.get(i).getPw().equals(pw)) {
					System.out.println();
					System.out.print(list.get(i).getName()+"님 ");
					return list.get(i);
				}
				else {
					return null;
				}
			}
		}
		return null;
	}
	
	public void readFile() throws Exception {
		File file = new File("C:/Temp/users.txt");
		FileInputStream fis = new FileInputStream(file);
		Reader reader = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(reader);
		
		while(true) {
			String str = br.readLine();
			if(str == null) break;
			String data[] = str.split(" ");
			User user = new User(data[0],data[1],data[2]);
			list.add(user);
		}
	}


}
