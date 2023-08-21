package co.yedam.stream;
import java.io.*;
public class FileCopy {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileInputStream fis = new FileInputStream("C:/Temp/img1.jpg");
			FileOutputStream fos = new FileOutputStream("C:/Temp/copy.jpg");
			byte[] buf = new byte[100];
			while(true) {
				int val = fis.read(buf);
				if(val == -1) break;
				fos.write(buf);
			}
			fis.close();
			fos.flush();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("END");
		long end = System.currentTimeMillis();
		System.out.println("걸린 시간: "+(end-start)+"ms");
	}
}
