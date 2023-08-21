package co.yedam.stream;

import java.io.*;

public class FileOutputStreamExe {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/out.data");
			fos.write(100);
			fos.write(110);
			fos.write(255);
			
			fos.flush(); //버퍼의 캐시값을 비움
			fos.close(); //리소드 환원
			

		} catch (IOException e) {
			// TODO Auto-generated catch block;
			e.printStackTrace();
		}
	}
}
