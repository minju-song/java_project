package co.yedam.friend;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ScanExe {
	public static void main(String[] args) {		
		File file = new File("src/co/yedam/friend/friend.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		boolean run = true;
		while(true) {
			String line = sc.nextLine();
			String data[] = line.split(" ");
			
		}
	}
	
}
