
import java.io.*;

public class FileExe {

	public static void main(String[] args) throws IOException {

		File path = new File("C:/Temp/fold");
		FileOutputStream fos = null; 
		String name[] = {"A","B","C"};
		if(!path.exists()) {
			path.mkdir();
		}
		for(int i=0; i<name.length; i++) {
			File file = new File("C:/Temp/fold/"+name[i]+".txt");
			try {
				file.createNewFile();
				Thread.sleep(800);
				fos = new FileOutputStream(file);
				System.out.println(name[i]+"작성 "+file);
				fos.write(name[i].toLowerCase().getBytes());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		fos.close();
		System.out.println("종료");
		
		for(int i=0; i<name.length; i++) {
			File file = new File("C:/Temp/fold/"+name[i]+".txt");
			FileInputStream fis = new FileInputStream(file);
			System.out.println((i+1)+"번째: "+(char)fis.read());
		}
	}

	private static void timeMsg(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}

}
