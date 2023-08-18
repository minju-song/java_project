package co.yedam.api;

public class SystemExe {
	public static void main(String[] args) {
		long start1 = System.currentTimeMillis();
		long start2 = System.nanoTime();
		for(int i=0; i<=1000000; i++) {
			System.out.println(i);
		}
		long end1 = System.currentTimeMillis();
		long end2 = System.nanoTime();
		
		System.out.println((end1 - start1)+" ms");
		System.out.println((end2 - start2)+" ns");
	}
}
