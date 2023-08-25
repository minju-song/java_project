package co.yedam.board.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.yedam.board.vo.Board;
import co.yedam.board.vo.Reply;
import co.yedam.board.vo.User;

public class ReplyServiceImpl implements ReplyService {
	List<Reply> replyList = new ArrayList<>();
	
	static Scanner sc = new Scanner(System.in);
	
	public ReplyServiceImpl() {
		init();
	}
	
	public void init() {
		try {
			FileInputStream fis = new FileInputStream("C:/Temp/reply.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			replyList = (List<Reply>) ois.readObject();
			
			ois.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	@Override
	public void add(Board brd, User user) {
//		sc.nextLine();
		System.out.print("댓글 작성>>");
		String cont = sc.nextLine();
		Reply rep = new Reply();
		rep.setBrdNo(brd.getBrdNo());
		rep.setContent(cont);
		rep.setRepNo(getMaxNo());
		rep.setRepWriter(user.name);
		replyList.add(rep);
		System.out.println("댓글이 등록되었습니다.");
		
		print();
		
	}
	
	private int getMaxNo() {
		int repNo = 0;
		for(int i=0; i<replyList.size(); i++) {
			if(replyList.get(i).getRepNo() > repNo) {
				repNo = replyList.get(i).getRepNo();
			}
		}
		return repNo+1;
	}

	@Override
	public void delete(User user) {
		System.out.print("삭제할 댓글 번호 입력>>");
		int del = sc.nextInt();
		for(int i=0; i<replyList.size(); i++) {
			if(del == replyList.get(i).getRepNo()) {
				replyList.remove(i);
				System.out.println("삭제되었습니다.");
			}
		}
	}

	@Override
	public void list(int brdNo) {
		//(rs.getInt("rep_no")+") "+rs.getString("rep_content")+"\t\t작성자: "+rs.getString("rep_write"))
		System.out.println(replyList.size());
		for(int i=0; i<replyList.size(); i++) {
			if (brdNo==replyList.get(i).getBrdNo()) {
				Reply t = replyList.get(i);
				System.out.println(t.getRepNo()+") "+t.getContent()+"\t\t작성자: "+t.getRepWriter());
			}
		}
		System.out.println();
		
	}
	
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/reply.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(replyList);
			oos.flush();
			oos.close();
			fos.close();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void print() {
		for(int i=0; i<replyList.size(); i++) {
			Reply t = replyList.get(i);
			System.out.println("댓글번호:"+t.getRepNo()+" 댓글내용:"+t.getContent()+" 게시글번호:"+t.getBrdNo());
		}
	}

	

}
