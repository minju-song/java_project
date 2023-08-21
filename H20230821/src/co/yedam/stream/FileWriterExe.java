package co.yedam.stream;

import java.io.*;
import java.util.*;

public class FileWriterExe {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("C:/Temp/names.txt");
			Scanner scn = new Scanner(System.in);
			
			System.out.println("START");
			
			while(true) {
				String line = scn.nextLine();
				if(line.equals("quit")) break;
				fw.write(line);
				fw.write("\n");
			}
			fw.flush();
			fw.close();
			scn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("END");
	}
}
