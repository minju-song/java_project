package co.yedam.loop;

public class ForExe {

	public static void main(String[] args) {
		
		
		
		//4
		for(int i=0; i<=10; i++) {
			for(int j=0; j<=10; j++) {
				if((4*i)+(5*j)==60) {
					System.out.printf("(%d, %d)\n", i, j);
				}
			}
		}
		
		
		//5
		System.out.println();
		System.out.println();
		for(int i=1; i<=4; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		//6
		System.out.println();
		System.out.println();
		for(int i=1; i<=4; i++) {
			for(int j=i; j<4; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.printf("\nend\n");
		

	}

}
