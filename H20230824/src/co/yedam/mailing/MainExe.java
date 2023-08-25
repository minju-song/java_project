package co.yedam.mailing;

import java.io.*;

import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MainExe {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		Thread thread = new Thread(new Runnable() {
//			public void run() {
//				wavplayer();
//			}
//		});
//		thread.start();
		
		boolean run = true;
		while(run) {
			System.out.println("1.추가 2.목록 3.메일 4.종료");
			System.out.print("선택>> ");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("추가합니다."); break;
			case 2:
				System.out.println("목록입니다."); break;
			case 3:
				sc.nextLine();
				mailsend();
				break;
			case 4:
				System.out.println("종료합니다."); run = false;
			}
		}
		System.out.println("종료함");
	}
	
	static void wavplayer() {
		while(true) {
			
			try {
				File file = new File("C:/Temp/sample.wav");
				AudioInputStream ais = AudioSystem.getAudioInputStream(file);
				Clip clip = AudioSystem.getClip();
				clip.open(ais);
				clip.start();
				
				Thread.sleep(clip.getMicrosecondLength()/1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static void mailsend() {
		
		System.out.print("수신자 메일>> ");
		String to = sc.nextLine();
		System.out.print("제목>> ");
		String title = sc.nextLine();
		System.out.print("내용>> ");
		StringBuilder sb = new StringBuilder();
		sb.append("<p color='pink'>&#128150;비밀번호 초기화 메일입니다.&#128150;</p>");
		sb.append("<p>새로운 비밀번호 : 12345</p>");
		String content = sc.nextLine();
		sb.append("<p>"+content+"</p>");
		sb.append("<b>다시 로그인하세요&#128293;</b>");
		
		content = sb.toString();
		
		SendMail sm = new SendMail();
		sm.sendMail(to, title, content);
//		sc.close();
		
	}
}


//로그인 3번 실패하면 메일 입력받고 비밀번호 12345 초기화 메일보낸 후 초기화하기