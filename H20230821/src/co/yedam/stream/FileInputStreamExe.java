package co.yedam.stream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExe {
	public static void main(String[] args) {
		try {
		FileInputStream fis = null;
		fis = new FileInputStream("C:/Temp/out.data");
		int idx = 1;
		while(true) {
			int val = fis.read();
			if(val == -1) break;
			System.out.println(idx+" : "+val);
			idx++;
		}
		
		fis.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block;
		e.printStackTrace();
	}
	
	System.out.println("end");
	}
}
